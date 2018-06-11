/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidservice.raidservice;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jorrit
 */
public class Raid implements Serializable{
    String gymName;
    String boss;
    long x;
    long y;
    long time;
    List<Player> players;

    public Raid(String gymName, String boss, long x, long y, long time) {
        this.gymName = gymName;
        this.boss = boss;
        this.time = time;
        this.x = x;
        this.y = y;
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

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }
    
    
}
