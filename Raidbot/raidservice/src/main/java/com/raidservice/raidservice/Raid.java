/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidservice.raidservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorrit
 */
public class Raid implements Serializable{
    String gymName;
    String boss;
    double lat;
    double lng;
    long time;
    List<Player> players = new ArrayList<>();

    public Raid(String gymName, String boss, double lat, double lng, long time) {
        this.gymName = gymName;
        this.boss = boss;
        this.time = time;
        this.lat = lat;
        this.lng = lng;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(long lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(long lng) {
        this.lng = lng;
    }
    
    
}
