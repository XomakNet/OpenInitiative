/**
 * 
 */
package net.xomak.openinitiative.model;

/**
 * User's role model
 * @author Konstantin Danilov
 *
 */
public class UserRole {

	private int id;
	private String name;
	/**
	 * Administrator of the system (can change settings)
	 */
	private boolean isAdministrator;
	/**
	 * Can respond to the initiative
	 */
	private boolean isResponser;
	
	public UserRole(int id, String name, boolean isAdministrator,
			boolean isResponser) {
		super();
		this.id = id;
		this.name = name;
		this.isAdministrator = isAdministrator;
		this.isResponser = isResponser;
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
