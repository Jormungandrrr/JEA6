/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Models.Account;
import Models.Role;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import static javax.ws.rs.core.HttpHeaders.AUTHORIZATION;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;
import javax.ws.rs.core.UriInfo;
import service.AccountService;
import service.KeyGenerator;

/**
 *
 * @author Jorrit
 */
@Path("login")
@Stateless
public class LoginResource {
    
    @Inject
    private KeyGenerator KeyGenerator;
    
    @Inject
    private AccountService a;
    
    @Context
    private UriInfo uriInfo;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response login(@QueryParam("username") String username, @QueryParam("password") String password) {
        if (a.checkIfExists(username)) {
             Account acc = a.findByUserName(username);
             if (acc.getPassword().equals(a.hashPassword(password))) {
                String token = issueToken(username);
                acc.setToken(token);
                return Response.ok(acc).header(AUTHORIZATION, "Bearer " + token).build();
            }
             else{
                 return Response.status(UNAUTHORIZED).build();
             }
        }
        else{
            return Response.status(UNAUTHORIZED).build();
        }
    }
    
    private String issueToken(String user) {
        Key key = KeyGenerator.generateKey();
        String jwtToken;
        jwtToken = Jwts.builder()
                .setSubject(user)
                .setIssuer(uriInfo.getAbsolutePath().toString())
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
                .signWith(SignatureAlgorithm.HS512, key)
                .compact();
        return jwtToken;
    }
    
    private Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
}

