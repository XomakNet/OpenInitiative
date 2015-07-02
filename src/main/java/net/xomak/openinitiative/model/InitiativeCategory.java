/**
 * 
 */
package net.xomak.openinitiative.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.validation.constraints.Size;

/**
 * Model of initiative's category
 * @author Konstantin Danilov
 *
 */
@Entity
public class InitiativeCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Size(min = 1, max = 100, message = "Название должно быть не короче 1 символа и не длиннее 100")
	private String name;

	@Size(max = 200, message = "Описание должно быть не длиннее 200 символов")
	private String description;
	private boolean isActive;

	protected InitiativeCategory() {

	}

	public InitiativeCategory(String name, String description, boolean isActive) {
		this.name = name;
		this.description = description;
		this.isActive = isActive;
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

	@Override
	public String toString() {
		return "InitiativeCategory{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(boolean isActive) {
		this.isActive = isActive;
	}
}
