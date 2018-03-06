package Dao;

import Models.Account;

import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.inject.Default;

@Stateless @Default
public class AccountDaoColl implements AccountDao{

    CopyOnWriteArrayList<Account> accounts = new CopyOnWriteArrayList<>();

    @Override
    public void create(Account account) {
        accounts.add(account);
    }

    @Override
    public void remove(Account account) {
        accounts.remove(account);
    }

    @Override
    public ArrayList<Account> getAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public Account findByName(String userName) {
        for (Account student : accounts) {
            if (student.getUserName().contentEquals(userName)) {
                return student;
            }
        }
        return null;
    }


    @PostConstruct
    public void init(){
        System.out.println("AccountDaoColl");
    }


    public AccountDaoColl() {
    }
}
