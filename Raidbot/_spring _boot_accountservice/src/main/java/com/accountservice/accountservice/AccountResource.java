package com.accountservice.accountservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestMapping("/account")
@RestController
public class AccountResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Account account() {
        return new Account("test");
    }
}
