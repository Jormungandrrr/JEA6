package service;

import Models.Account;
import Models.Profile;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class StartUp {

    @Inject
    private AccountService as;

    public StartUp() {
    }

    @PostConstruct
    private void intData(){
        Account test = new Account("test", "test@test.nl", 3);
        test.setAccountProfile(new Profile("test test test", "test"));
        
        as.addAccount(test);
    }
}
