package com.raidservice.raidservice;

import java.util.Date;
import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/raids")
public class RaidEndpoint {

    @Inject
    private RaidService service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Raid> get() {
        return service.getRaids();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Raid create(@QueryParam("gym") String gym, @QueryParam("boss") String boss, @QueryParam("lat") double lat, @QueryParam("lng") double lng, @QueryParam("minutes") int minutes) {
        long date = new Date().getTime() + minutes * 60000;
        return service.create(new Raid(gym,boss,lat,lng,date));
    }
    
    @POST
    @Path("/gym")
    @Produces(MediaType.APPLICATION_JSON)
    public Boolean join(@QueryParam("gymname") String gym, @QueryParam("playername") String name) {
        return service.joinRaid(gym, name);
    }
}
