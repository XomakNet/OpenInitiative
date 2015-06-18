/**
 * 
 */
package net.xomak.openinitiative.model;

/**
 * Attachment to ComplexText (some file, e.g. image)
 * @author Konstantin Danilov
 *
 */
public class Attachment {

	protected int id;
	protected String serverPath;
	
	public Attachment(int id, String serverPath) {
		super();
		this.id = id;
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

}
