/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Raid;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;

/**
 *
 * @author Jorrit
 */
@Stateless
@JPA
public class RaidDao  extends DaoFacade<Raid> {
    
    public RaidDao() {
        super(Raid.class);
    }
     
    protected EntityManager getEntityManager() {
        return em;
    }


}
