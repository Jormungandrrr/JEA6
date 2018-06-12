/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bossservice.bossservice;

/**
 *
 * @author Jorrit
 */
public class Boss {
    
    int tier;
    String name;
    int bossCP;
    int minCP;
    int maxCP;
    double catchRate;

    public Boss(int tier, String name, int bossCP, int minCP, int maxCP, double catchRate) {
        this.tier = tier;
        this.name = name;
        this.bossCP = bossCP;
        this.minCP = minCP;
        this.maxCP = maxCP;
        this.catchRate = catchRate;
    }

    public int getTier() {
        return tier;
    }

    public void setTier(int tier) {
        this.tier = tier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBossCP() {
        return bossCP;
    }

    public void setBossCP(int bossCP) {
        this.bossCP = bossCP;
    }

    public int getMinCP() {
        return minCP;
    }

    public void setMinCP(int minCP) {
        this.minCP = minCP;
    }

    public int getMaxCP() {
        return maxCP;
    }

    public void setMaxCP(int maxCP) {
        this.maxCP = maxCP;
    }

    public double getCatchRate() {
        return catchRate;
    }

    public void setCatchRate(double catchRate) {
        this.catchRate = catchRate;
    }
    
    
    
}
