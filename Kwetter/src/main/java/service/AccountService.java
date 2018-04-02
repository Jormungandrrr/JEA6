package service;

import Dao.AccountDao;
import Dao.JPA;
import Models.Account;

import javax.inject.Inject;
import javax.ejb.Stateless;
import java.util.ArrayList;

/**
 *
 * @author Jorrit
 */
@Stateless
public class AccountService {

    @Inject
    @JPA
    private AccountDao accountDao;

    /**
     *
     * @param account
     */
    public void addAccount(Account account) {
        accountDao.create(account);
    }

    /**
     *
     * @param account
     */
    public void removeAccount(Account account) {
        accountDao.remove(account);
    }

    /**
     *
     * @return
     */
    public ArrayList<Account> getAccounts() {
        return accountDao.getAccounts();
    }

    /**
     *
     * @param username
     * @return
     */
    public Account findByUserName(String username) {
        return accountDao.findByName(username);
    }

    /**
     *
     * @param id
     * @return
     */
    public Account findById(int id) {
        return accountDao.find(id);
    }
    
    /**
     *
     * @param username
     * @return
     */
    public boolean checkIfExists(String username) {
        return accountDao.checkIfExists(username);
    }

    /**
     *
     */
    public AccountService() {
    }

}
