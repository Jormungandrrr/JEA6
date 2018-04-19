/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Models.Account;
import Models.Role;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import service.AccountService;

/**
 *
 * @author Jorrit
 */
@Path("login")
@Stateless
public class LoginResource {
    
    @Inject
    private AccountService a;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Account login(@QueryParam("username") String username, @QueryParam("password") String password) {
        if (a.checkIfExists(username)) {
             Account acc = a.findByUserName(username);
             if (acc.getPassword().equals(a.hashPassword(password))) {
                return acc;
            }
             else{
                 return null;
             }
        }
        else{
            return null;
        }
    }
}

