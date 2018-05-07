package Dao;

import Models.Account;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

/**
 *
 * @author Jorrit
 */
@Stateless @JPA
public class AccountDao extends DaoFacade<Account> {

    /**
     *
     */
    public AccountDao() {
        super(Account.class);
    }

    /**
     *
     * @return
     */
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     * @param name username
     * @return account from the given name
     */
    public Account findByName(String name) {
        TypedQuery<Account> query = em.createNamedQuery("account.findByname", Account.class);
        query.setParameter("username", name);
        List<Account> result = query.getResultList();
        return result.get(0);
    }

    /**
     *
     * @return list of all accounts
     */
    public ArrayList<Account> getAccounts() {
        Query query = em.createQuery("SELECT a FROM Account a");
        return  new ArrayList<>(query.getResultList());
    }
    
    /**
     *
     * @param name username
     * @return true if the username exists in the database
     */
    public Account login(String name, String password){
        Query query = em.createNamedQuery("account.login", Account.class)
        .setParameter("username", name)
        .setParameter("password", password);
        List<Account> result = query.getResultList();
        return result.get(0);
    }
}
