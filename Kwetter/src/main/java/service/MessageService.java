package service;

import Dao.AccountDao;
import Dao.JPA;
import Dao.MessageDao;
import Models.Account;
import Models.Message;

import javax.inject.Inject;
import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
public class MessageService {

    @Inject
    @JPA
    private MessageDao messageDao;

    public void addMessage(Message message) {
        messageDao.create(message);
    }

    public void removeMessage(Message message) {
        messageDao.remove(message);
    }

    public ArrayList<Message> getMessages() {
        return messageDao.getMessages();
    }

    public Message findById(int id) {
        return messageDao.find(id);
    }

    public MessageService() {
    }

}
