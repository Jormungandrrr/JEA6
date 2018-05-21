/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Models.Account;
import Models.Message;
import Models.Role;
import java.io.Serializable;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.inject.Inject;
import service.AccountService;
import service.MessageService;
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
    @Inject
    private MessageService ms;

    private List<Account> accounts;
    private List<Role> roles;
    private List<Message> messages;

    @PostConstruct
    public void init() {
        accounts = as.getAccounts();
        roles = rs.getRoles();
        messages = ms.getMessages();
    }
    
    public void onRoleChange() {
       for(Account a : accounts){
            as.update(a);
       }
    }
    
    public void onMessageDelete() {
       for(Message m : messages){
            //TODO Delete
       }
    }

    public List<Role> getRoles() {
        return roles;
    }
    
    public List<Account> getAccounts() {
        return accounts;
    }
    
    public List<Message> getmessages() {
        return messages;
    }
}
