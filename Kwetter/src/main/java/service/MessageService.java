package service;

import Dao.JPA;
import Dao.MessageDao;
import Models.Message;

import javax.inject.Inject;
import javax.ejb.Stateless;
import java.util.ArrayList;

/**
 *
 * @author Jorrit
 */
@Stateless
public class MessageService {

    @Inject
    @JPA
    private MessageDao messageDao;

    /**
     *
     * @param message
     */
    public void addMessage(Message message) {
        messageDao.create(message);
    }

    /**
     *
     * @param message
     */
    public void removeMessage(Message message) {
        messageDao.remove(message);
    }

    /**
     *
     * @return
     */
    public ArrayList<Message> getMessages() {
        return messageDao.getMessages();
    }
    
    public ArrayList<Message> getFlaggedMessages() {
        return messageDao.getFlaggedMessages();
    }

    /**
     *
     * @param id
     * @return
     */
    public Message findById(long id) {
        return messageDao.find(id);
    }

    /**
     *
     */
    public MessageService() {
    }

}
