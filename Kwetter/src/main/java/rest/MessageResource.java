/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Models.Message;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import service.MessageService;

/**
 *
 * @author Jorrit
 */
@Path("messages")
@Stateless
public class MessageResource {
   @Inject
    private MessageService m;

    @GET
    public List<Message> getAll() {
        return m.getMessages();
    }
}
