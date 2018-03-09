/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Models.Account;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.AccountService;

/**
 *
 * @author Jorrit
 */
@Path("accounts")
@Stateless
public class AccountResource {
    @Inject
    private AccountService a;

    @GET
    public List<Account> getAll() {
        return a.getAccounts();
    }

    @GET
    @Path("{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccount(@PathParam("name") String name) {
        Account acc = a.findByName(name);
        return acc;
    }
}
