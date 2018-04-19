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
        Profile testaAdminProfile = new Profile("testadminprofile","test test test", "test");
        List<Message> messages = new ArrayList<>();
        messages.add(new Message(testaAdminProfile, "init message"));
        testaAdminProfile.setMessages(messages);
        testaAdminProfile.getMessages().add(new Message(testaAdminProfile, "test message"));
        testadmin.setProfile(testaAdminProfile);
        as.addAccount(testadmin);
        
        Account testuser = new Account("testuser", "test@test.nl", new Role("user"),"test");
        Profile testUserProfile = new Profile("testuserprofile","test test test", "test");
        List<Message> usermessages = new ArrayList<>();
        usermessages.add(new Message(testaAdminProfile, "init message"));
        testUserProfile.setMessages(usermessages);
        testUserProfile.getMessages().add(new Message(testUserProfile, "test message"));
        testuser.setProfile(testUserProfile);
        as.addAccount(testuser);
        
        Account testModerator = new Account("testmoderator", "test@test.nl", new Role("moderator"),"test");
        Profile testModeratorProfile = new Profile("testmoderatorprofile","test test test", "test");
        List<Message> moderatormessages = new ArrayList<>();
        moderatormessages.add(new Message(testaAdminProfile, "init message"));
        testModeratorProfile.setMessages(moderatormessages);
        testModeratorProfile.getMessages().add(new Message(testModeratorProfile, "test message"));
        testModerator.setProfile(testModeratorProfile);
        as.addAccount(testModerator);
    }
}
