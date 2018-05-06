package Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jorrit
 */
@Entity
@NamedQueries({
        @NamedQuery(name = "profile.count", query = "SELECT COUNT(p) FROM Profile p"),
        @NamedQuery(name = "profile.findByname", query = "SELECT p FROM Profile p WHERE p.name = :name"),
        @NamedQuery(name = "profile.findByUsername", query = "SELECT p FROM Profile p JOIN Account a ON p.id = a.profile.id WHERE a.username = :username")
})
@XmlRootElement
public class Profile implements Serializable{

    @Id
    @GeneratedValue
    private long id;
    
    @Column(name = "name")
    private String name;

    @Column(name = "biography")
    private String biography;

    @Column(name = "location")
    private String location;

    @Column(name = "website")
    private  String website;

    @Column(name = "photo")
    private  String photo;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Profile> following;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> messages;

    /**
     *
     */
    public Profile() {
    }

    /**
     *
     * @param name
     * @param biography
     * @param location
     */
    public Profile(String name, String biography, String location) {
        this.name = name;
        this.biography = biography;
        this.location = location;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     *
     * @return
     */
    public String getBiography() {
        return biography;
    }

    /**
     *
     * @param biography
     */
    public void setBiography(String biography) {
        this.biography = biography;
    }

    /**
     *
     * @return
     */
    public String getLocation() {
        return location;
    }

    /**
     *
     * @param location
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     *
     * @return
     */
    public String getWebsite() {
        return website;
    }

    /**
     *
     * @param website
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     *
     * @return
     */
    public String getPhoto() {
        return photo;
    }

    /**
     *
     * @param photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
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
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public List<Profile> getFollowing() {
        return following;
    }

    /**
     *
     * @param following
     */
    public void setFollowing(List<Profile> following) {
        this.following = following;
    }

    /**
     *
     * @return
     */
    public List<Message> getMessages() {
        return messages;
    }

    /**
     *
     * @param messages
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
}
