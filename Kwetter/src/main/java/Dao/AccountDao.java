package Dao;

import Models.Account;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;

@Stateless @JPA
public class AccountDao extends DaoFacade<Account> {
    @PersistenceContext(unitName = "KwetterPU")
    private EntityManager em;

    public AccountDao() {
        super(Account.class);
    }

    protected EntityManager getEntityManager() {
        return em;
    }

    public Account findByName(String name) {
        TypedQuery<Account> query = em.createNamedQuery("account.findByname", Account.class);
        query.setParameter("userName", name);
        List<Account> result = query.getResultList();
        System.out.println("count: " + result.size());
        return result.get(0);
    }

    public ArrayList<Account> getAccounts() {
        Query query = em.createQuery("SELECT a FROM Account a");
        return  new ArrayList<>(query.getResultList());
    }
}
