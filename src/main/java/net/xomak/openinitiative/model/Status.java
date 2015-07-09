/**
 * 
 */
package net.xomak.openinitiative.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Initiative's status
 * @author Konstantin Danilov
 *
 */
@Entity
public class Status {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String description;
	private boolean isFinal;
	private boolean isVotingActive;
	private boolean isCommentable;
	private boolean isSearchable;

	protected Status() {

	}

	/**
	 *
	 * @param name
	 * @param description
	 * @param isFinal
	 * @param isVotingActive
	 * @param isCommentable
	 * @param isSearchable
	 */
	public Status(final String name, final String description, final boolean isFinal, final boolean isVotingActive, final boolean isCommentable, final boolean isSearchable) {
		this.name = name;
		this.description = description;
		this.isFinal = isFinal;
		this.isVotingActive = isVotingActive;
		this.isCommentable = isCommentable;
		this.isSearchable = isSearchable;
	}

	public Status(String name, String description) {
		super();
		this.name = name;
		this.description = description;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean getIsFinal() {
		return isFinal;
	}

	public void setIsFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	public boolean getIsVotingActive() {
		return isVotingActive;
	}

	public void setIsVotingActive(boolean isVotingActive) {
		this.isVotingActive = isVotingActive;
	}

	public boolean getIsCommentable() {
		return isCommentable;
	}

	public void setIsCommentable(boolean isCommentable) {
		this.isCommentable = isCommentable;
	}

	public boolean getIsSearchable() {
		return isSearchable;
	}

	public void setIsSearchable(boolean isSearchable) {
		this.isSearchable = isSearchable;
	}
}
