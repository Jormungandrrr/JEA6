package Models;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author Jorrit
 */
@Entity
public class Tag implements Serializable{
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    public Tag(String name) {
        this.name = name;
    }
    
    /**
     *
     */
    public Tag() {
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
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

}
