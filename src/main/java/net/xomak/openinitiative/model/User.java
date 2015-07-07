/**
 *
 */
package net.xomak.openinitiative.model;

/**
 * User of the system
 * @author Konstantin Danilov
 *
 */

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String login;
    private String email;
    @ManyToOne(optional = false)
    private UserRole role;
    private String passwordHash;

    protected User() {

    }

    /**
     * Creates user
     * @param login
     * @param email
     * @param role
     * @param passwordHash
     */
    public User(final String login, final String email, final UserRole role, final String passwordHash) {
        this.login = login;
        this.email = email;
        this.role = role;
        this.passwordHash = passwordHash;
    }

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


    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }


    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }


    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }


    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * @return the role
     */
    public UserRole getRole() {
        return role;
    }


    /**
     * @param role the role to set
     */
    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}