package service;

import Dao.AccountDao;
import Dao.JPA;
import Models.Account;

import javax.inject.Inject;
import javax.ejb.Stateless;
import java.util.ArrayList;

@Stateless
public class AccountService {

        @Inject @JPA
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

        public Account findByName(String name) {
            return accountDao.findByName(name);
        }

        public AccountService() {
        }

    }
