/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bossservice.bossservice;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Jorrit
 */
@ApplicationScoped
public class BossService {

    private List<Boss> bosses = new ArrayList<>();

    @PostConstruct
    public void init() {
        this.bosses.add(new Boss(5, "MewTwo", 49430, 2184, 2275, 6.0));
        this.bosses.add(new Boss(5, "Kyogre", 51968, 2236, 2328, 2.0));
        this.bosses.add(new Boss(4, "Tyrannitar", 34707, 2011, 2097, 5.0));
        this.bosses.add(new Boss(3, "Kyogre", 18144, 1574, 1650, 10.0));
    }

    public Boss create(Boss b) {
        this.bosses.add(b);
        return b;
    }
    
    public Boss get(String bossname) {
        for (Boss b : this.bosses) {
            if (b.name.equals(bossname)) {
                return b;
            }
        }
        return null;
    }

    public List<Boss> getBosses() {
        return this.bosses;
    }
}
