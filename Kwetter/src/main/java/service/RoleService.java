/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import Dao.JPA;
import Dao.RoleDao;
import Models.Role;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Jorrit
 */
@Stateless
public class RoleService {

    @Inject
    @JPA
    private RoleDao roleDao;

     /**
     *
     * @param P
     */
    public void addRole(Role r) {
            roleDao.create(r);
        }

    /**
     *
     * @param P
     */
    public void removeRole(Role r) {
            roleDao.remove(r);
        }

    /**
     *
     * @return
     */
    public ArrayList<Role> getRoles() {
            return roleDao.getProfiles();
        }
        
    /**
     *
     * @param id
     * @return
     */
    public Role findById(int id) {
            return roleDao.find(id);
        }

    /**
     *
     */
    public RoleService() {
        }

}
