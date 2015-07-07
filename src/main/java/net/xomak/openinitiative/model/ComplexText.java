/**
 * 
 */
package net.xomak.openinitiative.model;

import javax.persistence.*;
import java.util.Collection;

/**
 * Model for complex text (with attachments and formatting).
 * @author Konstantin Danilov
 *
 */
@Entity
public class ComplexText {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@OneToMany(cascade = CascadeType.ALL)
	private Collection<Attachment> attachments;

	@Lob
	@Column(length = 65535)
	private String text;

	protected ComplexText() {

	}

	public ComplexText(String text) {
		super();
		this.text = text;
	}

	public ComplexText(String text, Collection<Attachment> attachments) {
		super();
		this.attachments = attachments;
		this.text = text;
	}

	/**
	 * @return id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * Adds attachment to the text
	 * @param newAttachment attachment to add
	 */
	public void addAtachment(Attachment newAttachment) {
		attachments.add(newAttachment);
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the attachments
	 */
	public Collection<Attachment> getAttachments() {
		return attachments;
	}

	/**
	 * @param attachments to set
	 */
	public void setAttachments(Collection<Attachment> attachments) {
		this.attachments = attachments;
	}
}
