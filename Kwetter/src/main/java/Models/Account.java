package Models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author Jorrit
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "account.findByname", query = "SELECT a FROM Account a WHERE a.userName = :userName"),
        @NamedQuery(name = "account.count", query = "SELECT COUNT(a) FROM Account a"),
        @NamedQuery(name = "account.checkIfExists", query = "SELECT COUNT(a) FROM Account a Where a.userName = :userName")
})
        
@XmlRootElement
public class Account implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    private String userName;

    private String email;
    
    private String hash;

    @ManyToOne(cascade = CascadeType.ALL)
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
     * @param userName
     * @param email  
     * @param rights
     * @param hash
     */
    public Account(String userName, String email, Role role, String hash) {
        this.userName = userName;
        this.email = email;
        this.role = role;
        this.hash = hash;
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
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
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

    /**
     *
     * @return
     */
    public String getHash() {
        return hash;
    }

    /**
     *
     * @param hash
     */
    public void setHash(String hash) {
        this.hash = hash;
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
        return Objects.equals(this.userName, other.userName);
    }
}
