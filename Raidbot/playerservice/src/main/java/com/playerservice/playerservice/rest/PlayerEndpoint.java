package com.playerservice.playerservice.rest;

import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/players")
public class PlayerEndpoint {

    @Inject
    private PlayerService service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Player> get() {
        return service.getPlayers();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Player create(@QueryParam("name") String name, @QueryParam("level") int level) {
        return service.create(new Player(name, level));
    }
}
