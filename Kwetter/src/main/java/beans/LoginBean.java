/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import Models.Account;
import java.io.Serializable;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;
import service.AccountService;

/**
 *
 * @author Jorrit
 */
@Named(value = "login")
@ViewScoped
public class LoginBean implements Serializable {

    private String username;
    private String password;
    @Inject
    private AccountService as;

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @param event
     */
    public void login(ActionEvent event) {
        FacesMessage message = null;
        boolean loggedIn = false;

        if (username != null && password != null && as.checkIfExists(username)) {
            Account acc = as.findByUserName(username);
            if (acc != null && username.equals(acc.getUserName()) && password.equals(acc.getHash())) {
                loggedIn = true;
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
            } else {
                loggedIn = false;
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
            }
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
    }

}
