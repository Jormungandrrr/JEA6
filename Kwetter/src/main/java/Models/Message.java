package Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Message implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "messageId")
    private long id;

    @Column(name = "content")
    private String content;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ownerId")
    private Profile owner;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Profile> mentions;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tag> tags;

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

    public Profile getOwner() {
        return owner;
    }

    public void setOwner(Profile owner) {
        this.owner = owner;
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
