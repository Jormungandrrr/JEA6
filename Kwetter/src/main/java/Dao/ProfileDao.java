/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Profile;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Jorrit
 */
@Stateless @JPA
public class ProfileDao extends DaoFacade<Profile> {
    
     public ProfileDao() {
        super(Profile.class);
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    public ArrayList<Profile> getProfiles() {
        Query query = em.createQuery("SELECT p FROM Profile p");
        return  new ArrayList<>(query.getResultList());
    }
}
