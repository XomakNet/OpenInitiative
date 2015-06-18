/**
 * 
 */
package net.xomak.openinitiative.model;

import java.util.ArrayList;

/**
 * Model for complex text (with attachments and formatting).
 * @author Konstantin Danilov
 *
 */
public class ComplexText {

	protected ArrayList<Attachment> attachments;
	protected String text;
	
	public ComplexText(ArrayList<Attachment> attachments, String text) {
		super();
		this.attachments = attachments;
		this.text = text;
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
	public ArrayList<Attachment> getAttachments() {
		return attachments;
	}
}
