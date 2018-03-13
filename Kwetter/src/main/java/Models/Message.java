package Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

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

    public Message() {
    }

    public Message(Profile owner, String content) {
        this.content = content;
        this.owner = owner;
    }

    public Message(String content, Profile owner, List<Profile> mentions, List<Tag> tags) {
        this.content = content;
        this.owner = owner;
        this.mentions = mentions;
        this.tags = tags;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Profile> getMentions() {
        return mentions;
    }

    public void setMentions(List<Profile> mentions) {
        this.mentions = mentions;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}
