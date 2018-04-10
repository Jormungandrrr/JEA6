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
        Account testadmin = new Account("testadmin", "test@test.nl", new Role("admin"),"test");
        Profile testaAdminProfile = new Profile("testprofile","test test test", "test");
        List<Message> messages = new ArrayList<>();
        messages.add(new Message(testaAdminProfile, "init message"));
        testaAdminProfile.setMessages(messages);
        testaAdminProfile.getMessages().add(new Message(testaAdminProfile, "test message"));
        testadmin.setProfile(testaAdminProfile);
        as.addAccount(testadmin);
        
        Account testuser = new Account("testuser", "test@test.nl", new Role("user"),"test");
        Profile testUserProfile = new Profile("testprofile","test test test", "test");
        testUserProfile.setMessages(messages);
        testUserProfile.getMessages().add(new Message(testUserProfile, "test message"));
        testadmin.setProfile(testUserProfile);
        as.addAccount(testuser);
    }
}
