package net.xomak.openinitiative.model;

import javax.persistence.*;

/**
 * Something, that can have user comments
 * @author Konstantin Danilov
 *
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Commentable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
}
