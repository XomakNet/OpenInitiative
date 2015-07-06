/**
 * 
 */
package net.xomak.openinitiative.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * User's role model
 * @author Konstantin Danilov
 *
 */
@Entity
public class UserRole {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	/**
	 * Administrator of the system (can change settings)
	 */
	private boolean isAdministrator;
	/**
	 * Can respond to the initiative
	 */
	private boolean isResponser;

	protected UserRole() {

	}

	public UserRole(String name, boolean isAdministrator,
			boolean isResponser) {
		super();
		this.name = name;
		this.isAdministrator = isAdministrator;
		this.isResponser = isResponser;
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the isAdministrator
	 */
	public boolean isAdministrator() {
		return isAdministrator;
	}

	/**
	 * @param isAdministrator the isAdministrator to set
	 */
	public void setAdministrator(boolean isAdministrator) {
		this.isAdministrator = isAdministrator;
	}

	/**
	 * @return the isResponser
	 */
	public boolean isResponser() {
		return isResponser;
	}

	/**
	 * @param isResponser the isResponser to set
	 */
	public void setResponser(boolean isResponser) {
		this.isResponser = isResponser;
	}

}
