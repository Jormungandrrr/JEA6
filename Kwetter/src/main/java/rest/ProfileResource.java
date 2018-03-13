/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Models.Account;
import Models.Message;
import Models.Profile;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Profile getProfile(@PathParam("id") int id) {
        Profile prof = p.findById(id);
        return prof;
    }

    @PUT
    public void createprofile(@QueryParam("name") String name, @QueryParam("biography") String bio, @QueryParam("location") String loc) {
        p.addprofile(new Profile(name, bio, loc));
    }

    @POST
    @Path("{id}")
    public void updateProfile(@PathParam("id") int id, @QueryParam("biography") String bio, @QueryParam("location") String location, @QueryParam("photo") String photo, @QueryParam("website") String website) {
        Profile prof = p.findById(id);
        prof.setBiography(bio);
        prof.setLocation(location);
        prof.setPhoto(photo);
        prof.setWebsite(website);
    }
    
    @POST
    @Path("{id}/message")
    public void addMessage(@PathParam("id") int id, @QueryParam("content") String content) {
        Profile prof = p.findById(id);
        prof.getMessages().add(new Message(prof, content));
    }
    
    @DELETE
    @Path("{id}/message")
    public void deleteMessage(@PathParam("id") int id, @QueryParam("content") String content) {
        Profile prof = p.findById(id);
        prof.getMessages().remove(new Message(prof, content));
    }
    
    @POST
    @Path("{id}/follower")
    public void addFollower(@PathParam("id") int id, @QueryParam("followerid") int followerid) {
        Profile prof = p.findById(id);
        Profile follower = p.findById(followerid);
        prof.getFollowing().add(follower);
    }
    
    @DELETE
    @Path("{id}/follower")
    public void removeFollower(@PathParam("id") int id, @QueryParam("followerid") int followerid) {
        Profile prof = p.findById(id);
        Profile follower = p.findById(followerid);
        prof.getFollowing().remove(follower);
    }

    @DELETE
    @Path("{id}")
    public void deleteProfile(@PathParam("id") int id) {
        Profile prof = p.findById(id);
        p.removeProfile(prof);
    }
}
