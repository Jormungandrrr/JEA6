/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Models.Account;
import Models.Role;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;
import service.AccountService;
import service.RoleService;

/**
 *
 * @author Jorrit
 */
@Named(value = "admin")
@ManagedBean
@SessionScoped
public class AdminBean implements Serializable {

    @Inject
    private AccountService as;
    @Inject
    private RoleService rs;

    private List<Account> accounts;
    private List<Role> roles;

    @PostConstruct
    public void init() {
        accounts = as.getAccounts();
        roles = rs.getRoles();
    }
    
    public void onRoleChange() {
       for(Account a : accounts){
            as.update(a);
       }
    }

    public List<Role> getRoles() {
        return roles;
    }
    
    public List<Account> getAccounts() {
        return accounts;
    }
}
