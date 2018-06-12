package com.bossservice.bossservice;

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

@Path("/bosses")
public class BossEndpoint {

    @Inject
    private BossService service;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Boss> get() {
        return service.getBosses();
    }
    
    @GET
    @Path("boss")
    @Produces(MediaType.APPLICATION_JSON)
    public Boss getBoss(@QueryParam("name") String name) {
        return service.get(name);
    }
}
