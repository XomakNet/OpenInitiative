/**
 * 
 */
package net.xomak.openinitiative.model;

import java.util.Date;

/**
 * Comment to the commentable
 * @author Konstantin Danilov
 *
 */
public class Comment implements Commentable {
	
	private int id;
	private ComplexText text;
	/**
	 * Parent commentable object for this
	 */
	private Commentable parent;
	/**
	 * Root commentable object. (The top level of the tree)
	 */
	private Commentable root;
	private Date datetime;
	private int rating;
	
	public Comment(ComplexText text, Commentable reffersTo,
			Date datetime) {
		super();
		this.text = text;
		this.parent = reffersTo;
		this.datetime = datetime;
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
	
	
	

}
