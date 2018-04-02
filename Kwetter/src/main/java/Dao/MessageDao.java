
package Dao;

/**
 *
 * @author Jorrit
 */
import Models.Message;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author Jorrit
 */
@Stateless @JPA
public class MessageDao extends DaoFacade<Message>{
    
    /**
     *
     */
    public MessageDao() {
        super(Message.class);
    }

    /**
     *
     * @return entity manager
     */
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     * @return list of all messages
     */
    public ArrayList<Message> getMessages() {
        Query query = em.createQuery("SELECT m FROM Message m");
        return  new ArrayList<>(query.getResultList());
    }
}
