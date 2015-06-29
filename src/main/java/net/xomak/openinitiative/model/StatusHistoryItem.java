/**
 * 
 */
package net.xomak.openinitiative.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Status history item.
 * @author Konstantin Danilov
 *
 */
@Entity
public class StatusHistoryItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@ManyToOne
	private Status newStatus;

	private Date dateTime;
	/**
	 * User's comment, linked with this change of status
	 */
	@OneToOne
	private Comment comment;

	protected StatusHistoryItem() {

	}

	public StatusHistoryItem(Status newStatus, Date dateTime,
			Comment comment) {
		super();
		this.newStatus = newStatus;
		this.dateTime = dateTime;
		this.comment = comment;
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
