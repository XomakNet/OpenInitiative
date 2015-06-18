/**
 * 
 */
package net.xomak.openinitiative.models;

import java.util.Date;

/**
 * Status history item.
 * @author Konstantin Danilov
 *
 */
public class StatusHistoryItem {

	protected int id;
	protected Status newStatus;
	protected Date dateTime;
	/**
	 * User's comment, linked with this change of status
	 */
	protected Comment comment;
	
	public StatusHistoryItem(int id, Status newStatus, Date dateTime,
			Comment comment) {
		super();
		this.id = id;
		this.newStatus = newStatus;
		this.dateTime = dateTime;
		this.comment = comment;
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
	 * @return the newStatus
	 */
	public Status getNewStatus() {
		return newStatus;
	}

	/**
	 * @param newStatus the newStatus to set
	 */
	public void setNewStatus(Status newStatus) {
		this.newStatus = newStatus;
	}

	/**
	 * @return the dateTime
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the comment
	 */
	public Comment getComment() {
		return comment;
	}

	/**
	 * @param comment the comment to set
	 */
	public void setComment(Comment comment) {
		this.comment = comment;
	}

	

}
