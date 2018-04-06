package service;

import Models.Account;
import Models.Message;
import Models.Profile;
import Models.Role;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 *
 * @author Jorrit
 */
@Singleton
@Startup
public class StartUp {

    @Inject
    private AccountService as;

    /**
     *
     */
    public StartUp() {
    }

    @PostConstruct
    private void intData(){
        Account test = new Account("test", "test@test.nl", new Role("user"), "test");
        Profile testProfile = new Profile("testprofile","test test test", "test");
        List<Message> messages = new ArrayList<>();
        messages.add(new Message(testProfile, "init message"));
        testProfile.setMessages(messages);
        testProfile.getMessages().add(new Message(testProfile, "test message"));
        test.setProfile(testProfile);
        as.addAccount(test);
    }
}
