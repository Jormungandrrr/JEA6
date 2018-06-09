/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.raidservice.raidservice.rest;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Jorrit
 */
@RequestScoped
public class RaidService {

    private List<Raid> raids = new ArrayList<Raid>();

    public Raid create(Raid r) {
        this.raids.add(r);
        return r;
    }

    public List<Raid> getRaids() {
        return this.raids;
    }
}
