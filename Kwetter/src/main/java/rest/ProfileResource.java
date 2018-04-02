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
import service.MessageService;
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
    
    @Inject
    private MessageService m;

    /**
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Profile> getAll() {
        return p.getProfiles();
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Profile getProfile(@PathParam("id") int id) {
        Profile prof = p.findById(id);
        return prof;
    }

    /**
     *
     * @param name
     * @param bio
     * @param loc
     */
    @PUT
    public void createprofile(@QueryParam("name") String name, @QueryParam("biography") String bio, @QueryParam("location") String loc) {
        p.addprofile(new Profile(name, bio, loc));
    }

    /**
     *
     * @param id
     * @param bio
     * @param location
     * @param photo
     * @param website
     */
    @POST
    @Path("{id}")
    public void updateProfile(@PathParam("id") int id, @QueryParam("biography") String bio, @QueryParam("location") String location, @QueryParam("photo") String photo, @QueryParam("website") String website) {
        Profile prof = p.findById(id);
        prof.setBiography(bio);
        prof.setLocation(location);
        prof.setPhoto(photo);
        prof.setWebsite(website);
    }
    
    /**
     *
     * @param id
     * @param content
     */
    @POST
    @Path("{id}/message")
    public void addMessage(@PathParam("id") int id, @QueryParam("content") String content) {
        Profile prof = p.findById(id);
        prof.getMessages().add(new Message(prof, content));
    }
    
    /**
     *
     * @param id
     * @param messageid
     */
    @DELETE
    @Path("{id}/message")
    public void deleteMessage(@PathParam("id") int id, @QueryParam("content") int messageid) {
        Profile prof = p.findById(id);
        Message toremove = m.findById(messageid);
        prof.getMessages().remove(toremove);
    }
    
    /**
     *
     * @param id
     * @param followerid
     */
    @POST
    @Path("{id}/follower")
    public void addFollower(@PathParam("id") int id, @QueryParam("followerid") int followerid) {
        Profile prof = p.findById(id);
        Profile follower = p.findById(followerid);
        prof.getFollowing().add(follower);
    }
    
    /**
     *
     * @param id
     * @param followerid
     */
    @DELETE
    @Path("{id}/follower")
    public void removeFollower(@PathParam("id") int id, @QueryParam("followerid") int followerid) {
        Profile prof = p.findById(id);
        Profile follower = p.findById(followerid);
        prof.getFollowing().remove(follower);
    }

    /**
     *
     * @param id
     */
    @DELETE
    @Path("{id}")
    public void deleteProfile(@PathParam("id") int id) {
        Profile prof = p.findById(id);
        p.removeProfile(prof);
    }
}
