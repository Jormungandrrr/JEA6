package Models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "account.findByname", query = "SELECT a FROM Account a WHERE a.userName = :userName"),
        @NamedQuery(name = "account.count", query = "SELECT COUNT(a) FROM Account a")})
@XmlRootElement
public class Account implements Serializable{

    @Id
    @GeneratedValue
    private long id;

    private String userName;

    private String email;

    private int rights;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="profileid")
    private Profile AccountProfile;

    public Account() {
    }

    public Account(String userName, String email, int rights) {
        this.userName = userName;
        this.email = email;
        this.rights = rights;
    }

    public long getId() {
        return id;
    }

    public void setId(long accountId) {
        this.id = accountId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRights() {
        return rights;
    }

    public void setRights(int rights) {
        this.rights = rights;
    }

    public Profile getAccountProfile() {
        return AccountProfile;
    }

    public void setAccountProfile(Profile accountProfile) {
        AccountProfile = accountProfile;
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
