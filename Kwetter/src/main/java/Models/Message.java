package Models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.inject.Inject;
import javax.xml.bind.annotation.XmlRootElement;
import service.ProfileService;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "content")
    private String content;
    
    @Column(name = "posterid")
    private long posterId;
    
    @Column(name = "poster")
    private String poster;
    
    @Column(name = "posterImage")
    private String posterImage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "profileId")
    private Profile owner;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Profile> likes;

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
        this.posterId = owner.getId();
        this.poster = owner.getName();
        this.posterImage = owner.getPhoto();
        this.tags = getTagsFromMessage(content);
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
        this.poster = this.owner.getName();
        this.posterImage = this.owner.getPhoto();
        this.posterId = this.owner.getId();
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
    public List<Profile> getLikes() {
        return likes;
    }

    /**
     *
     * @param likes
     */
    public void setLikes(List<Profile> likes) {
        this.likes = likes;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getPosterImage() {
        return posterImage;
    }

    public void setPosterImage(String posterImage) {
        this.posterImage = posterImage;
    }

    public long getPosterId() {
        return posterId;
    }

    public void setPosterId(long posterid) {
        this.posterId = posterid;
    }
    
     private List<Tag> getTagsFromMessage(String message) {
        Pattern MY_PATTERN = Pattern.compile("#(\\S+)");
        Matcher mat = MY_PATTERN.matcher(message);
        ArrayList<Tag> hashTags = new ArrayList<Tag>();
        while (mat.find()) {
            hashTags.add(new Tag(mat.group(1)));
        }
        return hashTags;
    }
     
//    public List<Profile> getMentionsFromMessage(String message) {
//        Pattern MY_PATTERN = Pattern.compile("@(\\S+)");
//        Matcher mat = MY_PATTERN.matcher(message);
//        ArrayList<Profile> mentions = new ArrayList<Profile>();
//        while (mat.find()) {
//             mentions.add(p.findByName(mat.group(1)));
//        }
//        return mentions;
//    }
    
}
