package net.xomak.openinitiative.model;

import javax.persistence.*;

/**
 * Created by regis on 10.07.2015.
 */
@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames = {"InitiativeId", "UserId"}))
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    /**
     * User voted for this initiative
     */
    @ManyToOne(optional = false)
    @JoinColumn(name="InitiativeId")
    private Initiative initiative;
    /**
     * Voted user
     */
    @ManyToOne(optional = false)
    @JoinColumn(name="UserId")
    private User user;
    /**
     * Has user voted for or against the initiative
     */
    private boolean votedFor;

    public Vote(final Initiative initiative, final User user, final boolean votedFor) {
        this.initiative = initiative;
        this.user = user;
        this.votedFor = votedFor;
    }

    protected Vote() {

    }

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    public Initiative getInitiative() {
        return initiative;
    }

    public void setInitiative(final Initiative initiative) {
        this.initiative = initiative;
    }

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public boolean isVotedFor() {
        return votedFor;
    }

    public void setVotedFor(final boolean votedFor) {
        this.votedFor = votedFor;
    }
}
