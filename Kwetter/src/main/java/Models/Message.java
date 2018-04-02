package Models;

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
    @NamedQuery(name = "message.count", query = "SELECT COUNT(m) FROM Message m")})
@XmlRootElement
public class Message implements Serializable {

    @Id
    @GeneratedValue
    private long id;

    @Column(name = "content")
    private String content;

    @Column(name = "likes")
    private int likes;

    @Column(name = "dislike")
    private int dislike;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileId")
    private Profile owner;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Profile> mentions;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tag> tags;

    /**
     *
     */
    public Message() {
    }

    /**
     *
     * @param owner
     * @param content
     */
    public Message(Profile owner, String content) {
        this.content = content;
        this.owner = owner;
    }

    /**
     *
     * @param content
     * @param owner
     * @param mentions
     * @param tags
     */
    public Message(String content, Profile owner, List<Profile> mentions, List<Tag> tags) {
        this.content = content;
        this.owner = owner;
        this.mentions = mentions;
        this.tags = tags;
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
    public String getContent() {
        return content;
    }

    /**
     *
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     *
     * @return
     */
    public List<Profile> getMentions() {
        return mentions;
    }

    /**
     *
     * @param mentions
     */
    public void setMentions(List<Profile> mentions) {
        this.mentions = mentions;
    }

    /**
     *
     * @return
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     *
     * @param tags
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    /**
     *
     * @return
     */
    public int getLikes() {
        return likes;
    }

    /**
     *
     * @param likes
     */
    public void setLikes(int likes) {
        this.likes = likes;
    }
    
    
}
