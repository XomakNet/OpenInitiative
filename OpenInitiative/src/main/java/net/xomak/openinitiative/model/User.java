/**
 * 
 */
package net.xomak.openinitiative.model;

/**
 * User of the system
 * @author Konstantin Danilov
 *
 */
public class User {

	private int id;
	private String login;
	private String email;
	private UserRole role;
	// TODO External auth module property
	
	
	public User(int id, String login, String email, UserRole role) {
		super();
		this.id = id;
		this.login = login;
		this.email = email;
		this.role = role;
	}


	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
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
	
	

}
