package service;

import Models.Account;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

@Singleton
@Startup
public class StartUp {

    @Inject
    private AccountService service;

    public StartUp() {
    }

    @PostConstruct
    private void intData(){
        service.addAccount(new Account("test", "test@test.nl", 3));
    }
}
