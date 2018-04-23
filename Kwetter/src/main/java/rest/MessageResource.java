/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Models.Message;
import Models.Profile;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import service.MessageService;
import service.ProfileService;

/**
 *
 * @author Jorrit
 */
@Path("messages")
@Stateless
public class MessageResource {

    @Inject
    private MessageService m;
    @Inject
    private ProfileService p;

    /**
     *
     * @return
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Message> getAll() {
        return m.getMessages();
    }

    /**
     *
     * @param id
     * @return
     */
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Message getMessage(@PathParam("id") int id) {
        Message message = m.findById(id);
        return message;
    }
    
    /**
     *
     * @param name
     * @param content
     */
    @PUT
    public void createmessage(@QueryParam("name") String name, @QueryParam("content") String content) {
        
        m.addMessage(new Message());
    }
    
    /**
     *
     * @param id
     * @param profileid
     */
    @POST
    @Path("{id}")
    public void likemessage(@PathParam("id") int id, @QueryParam("profileid") long profileid) {
         Message message = m.findById(id);
         Profile prof = p.findById(profileid);
         List<Profile> likes = message.getLikes();
         likes.add(prof);
         message.setLikes(likes);
    }
    
}
