package service;

import Dao.AccountDao;
import Dao.JPA;
import Models.Account;

import javax.inject.Inject;
import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
public class AccountService {

    @Inject
    @JPA
    private AccountDao accountDao;

    public void addAccount(Account account) {
        accountDao.create(account);
    }

    public void removeAccount(Account account) {
        accountDao.remove(account);
    }

    public ArrayList<Account> getAccounts() {
        return accountDao.getAccounts();
    }

    public Account findByUserName(String username) {
        return accountDao.findByName(username);
    }

    public Account findById(int id) {
        return accountDao.find(id);
    }

    public AccountService() {
    }

}
