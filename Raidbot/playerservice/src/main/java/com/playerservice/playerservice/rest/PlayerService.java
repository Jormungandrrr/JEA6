/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.playerservice.playerservice.rest;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Jorrit
 */
@ApplicationScoped
public class PlayerService {

    private List<Player> players = new ArrayList<>();

    @PostConstruct
    public void init() {
    }

    public Player create(Player p) {
        this.players.add(p);
        return p;
    }

    public List<Player> getPlayers() {
        return this.players;
    }
}
