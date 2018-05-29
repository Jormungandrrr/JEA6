package service;

import Dao.AccountDao;
import Dao.JPA;
import Models.Account;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Inject;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.DatatypeConverter;

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
    public Account findById(long id) {
        return accountDao.find(id);
    }

    /**
     *
     * @param username
     * @return
     */
    public void update(Account a) {
        accountDao.edit(a);
    }

    public Account login(String username, String password) {
        return accountDao.login(username, hashPassword(password));
    }
    /**
    * Returns SHA-256 encoded string
    * @param password - the string to be encoded
    * @return SHA-256 encoded string
    * @throws UnsupportedEncodingException if UTF-8 is not supported by the system
    * @throws NoSuchAlgorithmException if SHA-256 is not supported by the system
    */
    public static String hashPassword(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(password.getBytes("UTF-8"));
            byte[] digest = md.digest();
            return DatatypeConverter.printBase64Binary(digest).toString();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(AccountService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    /**
     *
     */
    public AccountService() {
    }

}
