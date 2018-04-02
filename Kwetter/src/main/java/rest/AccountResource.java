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
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
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
@Path("accounts")
@Stateless
public class AccountResource {

    @Inject
    private AccountService a;

    /**
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Account> getAll() {
        return a.getAccounts();
    }

    /**
     *
     * @param username
     * @return
     */
    @GET
    @Path("{username}")
    @Produces(MediaType.APPLICATION_JSON)
    public Account getAccount(@PathParam("username") String username) {
        Account acc = a.findByUserName(username);
        return acc;
    }

    /**
     *
     * @param username
     * @param email
     * @param hash
     */
    @PUT
    public void createAccount(@QueryParam("username") String username, @QueryParam("email") String email, @QueryParam("hash") String hash) {
        a.addAccount(new Account(username, email, 3, hash));
    }

    /**
     *
     * @param username
     * @param email
     * @param rights
     */
    @POST
    @Path("{username}")
    public void updateAccount(@PathParam("username") String username,@QueryParam("email") String email, @QueryParam("rights") int rights) {
        Account acc = a.findByUserName(username);
        acc.setEmail(email);
        acc.setRights(rights);
    }

    /**
     *
     * @param username
     */
    @DELETE
    @Path("{username}")
    public void deleteAccount(@PathParam("username") String username) {
        Account acc = a.findByUserName(username);
        a.removeAccount(acc);
    }
}
