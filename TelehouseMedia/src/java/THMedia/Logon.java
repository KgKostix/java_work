/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package THMedia;

import java.util.LinkedList;
import lib.MediaInfo;

/**
 *
 * @author Konstantin Goncharov
 */
public class Logon {

	public Logon() {
		login = null;
		password = null;
	}

	private String login;
	private String password;

	/**
	 * @return the login
	 */
	public String getLogin() {

		return login;
	}

	/**
	 * @param login the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
