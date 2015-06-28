/**
 * 
 */
package net.xomak.openinitiative.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Attachment to ComplexText (some file, e.g. image)
 * @author Konstantin Danilov
 *
 */
@Entity
public class Attachment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String serverPath;

	protected Attachment() {
	}

	public Attachment(String serverPath) {
		super();
		this.serverPath = serverPath;
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
	 * @return the serverPath
	 */
	public String getServerPath() {
		return serverPath;
	}

	/**
	 * @param serverPath the serverPath to set
	 */
	public void setServerPath(String serverPath) {
		this.serverPath = serverPath;
	}

	@Override
	public String toString() {
		return "Attachment{" +
				"id=" + id +
				", serverPath='" + serverPath + '\'' +
				'}';
	}


}
