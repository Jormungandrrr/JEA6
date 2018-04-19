package Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import javax.xml.bind.DatatypeConverter;
import service.AccountService;

/**
 *
 * @author Jorrit
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "account.findByname", query = "SELECT a FROM Account a WHERE a.username = :username"),
        @NamedQuery(name = "account.count", query = "SELECT COUNT(a) FROM Account a"),
        @NamedQuery(name = "account.checkIfExists", query = "SELECT COUNT(a) FROM Account a Where a.username = :username")
})
        
@XmlRootElement
public class Account implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    private String username;

    private String email;
    
    @JsonIgnore
    private String password;

    //@ManyToOne(cascade = CascadeType.ALL)
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "rolename", referencedColumnName = "name")
    private Role role;

    @OneToOne(cascade = CascadeType.ALL)
    private Profile profile;

    /**
     *
     */
    public Account() {
    }

    /**
     *
     * @param username
     * @param email  
     * @param rights
     * @param hash
     */
    public Account(String username, String email, Role role, String password){
        this.username = username;
        this.email = email;
        this.role = role;
        this.password = AccountService.hashPassword(password);
    }

    /**
     *
     * @return
     */
    public long getId() {
        return id;
    }

    /**
     *
     * @param accountId
     */
    public void setId(long accountId) {
        this.id = accountId;
    }

    /**
     *
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @param userName
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    /**
     *
     * @return
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     *
     * @param prof
     */
    public void setProfile(Profile prof) {
        profile = prof;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
         this.password = AccountService.hashPassword(password);
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        return Objects.equals(this.username, other.username);
    }
}
