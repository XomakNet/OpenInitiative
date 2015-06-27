/**
 * 
 */
package net.xomak.openinitiative.model;

/**
 * Model of initiative
 * @author Konstantin Danilov
 */
public class Initiative implements Commentable {

	private int id;
	private String name;
	private String description;
	private ComplexText text;
	/**
	 * Current status of the initiative
	 */
	private Status status;
	private int votesFor;
	private int votesAgainst;
	private InitiativeCategory category;
	private User owner;

	public Initiative(int id, String name, String description,
			ComplexText text, Status status, int votesNumber,
			InitiativeCategory category, User owner) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.text = text;
		this.status = status;
		this.votesFor = votesNumber;
		this.category = category;
		this.owner = owner;
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

	/**
	 * @return the text
	 */
	public ComplexText getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(ComplexText text) {
		this.text = text;
	}

	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}

	/**
	 * @return the votesNumber
	 */
	public int getVotesNumber() {
		return votesFor;
	}

	/**
	 * @param votesNumber the votesNumber to set
	 */
	public void setVotesNumber(int votesNumber) {
		this.votesFor = votesNumber;
	}

	/**
	 * @return the category
	 */
	public InitiativeCategory getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(InitiativeCategory category) {
		this.category = category;
	}

	/**
	 * @return the owner
	 */
	public User getOwner() {
		return owner;
	}

	/**
	 * @param owner the owner to set
	 */
	public void setOwner(User owner) {
		this.owner = owner;
	}

	/**
	 * @return the votesAgainst
	 */
	public int getVotesAgainst() {
		return votesAgainst;
	}

	/**
	 * @param votesAgainst the votesAgainst to set
	 */
	public void setVotesAgainst(int votesAgainst) {
		this.votesAgainst = votesAgainst;
	}
	
	

}
