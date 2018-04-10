/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Models.Account;
import Models.Role;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import service.AccountService;

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

    private List<Account> accounts;
    private List<String> roles = Arrays.asList("admin", "moderator", "user");

    @PostConstruct
    public void init() {
        accounts = as.getAccounts();
    }
    
    public void onRightChange(Account a, Role role) {
       a.setRole(role);
       as.update(a);
    }

    public List<String> getRoles() {
        return roles;
    }
    
    public List<Account> getAccounts() {
        return accounts;
    }
}
