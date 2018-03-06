package Dao;

import Models.Account;
import java.util.ArrayList;

public interface AccountDao {

    void create(Account account);

    void remove(Account account);

    Account findByName(String name);

    ArrayList<Account> getAccounts();

}
