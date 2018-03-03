package Models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Account implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private long id;

    @Column(name = "username", length = 50)
    private String userName;

    @Column(name = "email")
    private String email;

    @Column(name = "rights")
    private int rights;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="profileId")
    private Profile AccountProfile;

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
}
