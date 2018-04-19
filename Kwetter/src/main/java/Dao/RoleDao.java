/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Models.Role;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author Jorrit
 */
@Stateless @JPA
public class RoleDao extends DaoFacade<Role>{
     public RoleDao() {
        super(Role.class);
    }

    /**
     *
     * @return
     */
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     * @return list of all roles
     */
    public ArrayList<Role> getRoles() {
        Query query = em.createQuery("SELECT r FROM Role r");
        return new ArrayList<>(query.getResultList());
    }
}
