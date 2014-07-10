/**
 * ESUP-Portail Commons - Copyright (c) 2004-2008 ESUP-Portail consortium.
 */
package org.esupportail.commons.domain;

import java.io.Serializable;
import java.util.Locale;

import org.esupportail.commons.exceptions.PasswordException;

/**
 * The interface of password managers.
 */
public interface UserPasswordManager extends Serializable {

	/**
	 * @return a ramdom password.
	 */
	String generate();

	/**
	 * Check a password.
	 * @param password the password to check
	 * @param locale 
	 * @throws PasswordException 
	 */
	void check(final String password, final Locale locale) throws PasswordException;

}
