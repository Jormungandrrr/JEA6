package Models;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import javax.json.Json;
import javax.json.JsonObject;
import javax.xml.bind.annotation.XmlTransient;
import service.AccountService;

/**
 *
 * @author Jorrit
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "account.findByname", query = "SELECT a FROM Account a WHERE a.username = :username")
    ,
        @NamedQuery(name = "account.count", query = "SELECT COUNT(a) FROM Account a")
    ,
        @NamedQuery(name = "account.login", query = "SELECT a FROM Account a Where a.username = :username AND a.password = :password")
})

@XmlRootElement
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String username;

    private String email;

    @XmlTransient
    private String password;

    private String token;

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
    public Account(String username, String email, Role role, String password) {
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
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

    public JsonObject toJson(URI self) {
        return Json.createObjectBuilder()
                .add("username", this.username)
                .add("email", this.email)
                .add("role", this.role.getName())
                .add("_links", Json.createObjectBuilder()
                        .add("rel", "self")
                        .add("href", self.toString())
                )
                .build();
    }
}
