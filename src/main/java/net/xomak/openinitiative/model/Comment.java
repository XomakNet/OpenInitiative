/**
 * 
 */
package net.xomak.openinitiative.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Comment to the commentable
 * @author Konstantin Danilov
 *
 */
@Entity
public class Comment extends Commentable {

	@OneToOne(cascade = CascadeType.ALL)
	private ComplexText text;

	/**
	 * Parent commentable object for this
	 */
	@ManyToOne
	private Commentable parent;

	/**
	 * Root commentable object. (The top level of the tree)
	 */
	@ManyToOne
	private Commentable root;

	private Date datetime;
	private int rating;

	@ManyToOne
	private User owner;

	public Comment(ComplexText text, Commentable parent, Commentable root, Date datetime, int rating) {
		this.text = text;
		this.parent = parent;
		this.root = root;
		this.datetime = datetime;
		this.rating = rating;
	}

	protected Comment() {

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
	 * @return the reffersTo
	 */
	public Commentable getReffersTo() {
		return parent;
	}

	/**
	 * @param reffersTo the reffersTo to set
	 */
	public void setReffersTo(Commentable reffersTo) {
		this.parent = reffersTo;
	}

	/**
	 * @return the datetime
	 */
	public Date getDatetime() {
		return datetime;
	}

	/**
	 * @param datetime the datetime to set
	 */
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	/**
	 * @return the votes
	 */
	public int getVotes() {
		return rating;
	}

	/**
	 * @param votes the votes to set
	 */
	public void setVotes(int votes) {
		this.rating = votes;
	}

	/**
	 * @return the root
	 */
	public Commentable getRoot() {
		return root;
	}

	/**
	 * @param root the root to set
	 */
	public void setRoot(Commentable root) {
		this.root = root;
	}

	/**
	 * @return parent
	 */
	public Commentable getParent() {
		return parent;
	}

	/**
	 * @param parent to set
	 */
	public void setParent(Commentable parent) {
		this.parent = parent;
	}

	/**
	 * @return rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}
}
