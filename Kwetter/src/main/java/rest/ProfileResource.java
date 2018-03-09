/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Models.Account;
import Models.Profile;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import service.AccountService;
import service.ProfileService;

/**
 *
 * @author Jorrit
 */
@Path("profiles")
@Stateless
public class ProfileResource {
    @Inject
    private ProfileService p;

    @GET
    public List<Profile> getAll() {
        return p.getProfiles();
    }
}
