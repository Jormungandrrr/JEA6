/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Models.Message;
import Models.Profile;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.inject.Inject;
import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import service.ProfileService;

/**
 *
 * @author Jorrit
 */
@ServerEndpoint(value = "/messageSocket/{username}")
public class LiveMessageEndpoint {

    @Inject
    private ProfileService profileService;
    
    private Session session;
    private static Set<LiveMessageEndpoint> Endpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> users = new HashMap<>();

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) throws IOException {
        this.session = session;
        Endpoints.add(this);
        Profile p = profileService.findByUsername(username);
        users.put(session.getId(), username);
        broadcast("connected to " + p.getName());
    }
    
    @OnMessage
    public void onMessage(Session session, String message) 
      throws IOException {
        broadcast(message);
    }
 
    @OnClose
    public void onClose(Session session) throws IOException {
  
        Endpoints.remove(this);
        broadcast("Disconnected!");
    }

    
    private static void broadcast(String message) 
      throws IOException {
        Endpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    endpoint.session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
