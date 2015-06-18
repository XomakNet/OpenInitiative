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
	
	protected int id;
	protected ComplexText text;
	protected Commentable reffersTo;
	protected Date datetime;
	public Comment() {
	}
	
	public Comment(int id, ComplexText text, Commentable reffersTo,
			Date datetime) {
		super();
		this.id = id;
		this.text = text;
		this.reffersTo = reffersTo;
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
		return reffersTo;
	}

	/**
	 * @param reffersTo the reffersTo to set
	 */
	public void setReffersTo(Commentable reffersTo) {
		this.reffersTo = reffersTo;
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
	
	

}
