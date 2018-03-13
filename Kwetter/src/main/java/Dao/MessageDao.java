
package Dao;

/**
 *
 * @author Jorrit
 */
import Models.Message;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless @JPA
public class MessageDao extends DaoFacade<Message>{
    
    public MessageDao() {
        super(Message.class);
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    public ArrayList<Message> getMessages() {
        Query query = em.createQuery("SELECT m FROM Message m");
        return  new ArrayList<>(query.getResultList());
    }
}
