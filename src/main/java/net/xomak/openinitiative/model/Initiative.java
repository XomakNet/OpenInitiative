/**
 * 
 */
package net.xomak.openinitiative.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Model of initiative
 * @author Konstantin Danilov
 */
@Entity
public class Initiative extends Commentable {


	@OneToOne(cascade = CascadeType.ALL)
	private ComplexText text;

	/**
	 * Current status of the initiative
	 */
	@OneToOne
	private Status status;

	@ManyToMany
	private Collection<InitiativeCategory> categories;

	@ManyToOne
	private User owner;

	@OneToMany
	private Collection<StatusHistoryItem> statusHistory;

	private String name;
	private String description;


	private int votesFor;
	private int votesAgainst;


	protected Initiative() {

	}

	public Initiative(String name, String description,
			ComplexText text, Status status, int votesNumber,
			Collection<InitiativeCategory> categories, User owner) {
		super();
		this.name = name;
		this.description = description;
		this.text = text;
		this.status = status;
		this.votesFor = votesNumber;
		this.categories = categories;
		this.owner = owner;
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
	 * @return categories
	 */
	public Collection<InitiativeCategory> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(Collection<InitiativeCategory> categories) {
		this.categories = categories;
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

	/**
	 * @return collection of statusHistoryItem
	 */
	public Collection<StatusHistoryItem> getStatusHistory() {
		return statusHistory;
	}

	/*
	 * @param statusHistory collection of statusHistoryItem
	 */
	public void setStatusHistory(Collection<StatusHistoryItem> statusHistory) {
		this.statusHistory = statusHistory;
	}

	/**
	 * @return votesFor number
	 */
	public int getVotesFor() {
		return votesFor;
	}

	/**
	 * @param votesFor votesFor value to set
	 */
	public void setVotesFor(int votesFor) {
		this.votesFor = votesFor;
	}
}
