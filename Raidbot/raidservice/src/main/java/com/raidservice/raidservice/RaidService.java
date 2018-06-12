/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidservice.raidservice;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jorrit
 */
@ApplicationScoped
public class RaidService {

    private List<Raid> raids = new ArrayList<>();

    @PostConstruct
    public void init() {
    }

    public Raid create(Raid r, String bossName) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8083/raidbot/bosses/boss?name=" + bossName);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        JsonObject o = new JsonParser().parse(response).getAsJsonObject();
        r.boss = new Gson().fromJson(o.toString(), Boss.class);
        this.raids.add(r);
        return r;
    }

    public boolean joinRaid(String gymname, String playername) {
        Client client = ClientBuilder.newClient();
        WebTarget target = client.target("http://localhost:8081/raidbot/players/name?name=" + playername);
        String response = target.request(MediaType.APPLICATION_JSON).get(String.class);
        JsonObject o = new JsonParser().parse(response).getAsJsonObject();
        Player p = new Gson().fromJson(o.toString(), Player.class);
        if (p != null) {
            for (Raid r : this.raids) {
                if (r.gymName.equals(gymname)) {
                    r.players.add(p);
                    return true;
                }
            }
        }
        return false;
    }

    public List<Raid> getRaids() {
        return this.raids;
    }
}
