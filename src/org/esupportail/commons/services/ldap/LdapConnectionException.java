/**
 * ESUP-Portail Commons - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-commons
 */
package org.esupportail.commons.services.ldap;

/**
 * This exception is thrown when the connection to LDAP fails.
 */
public class LdapConnectionException extends LdapException {

	/**
	 * The id for serialization.
	 */
	private static final long serialVersionUID = -3012880829290566236L;

	/**
	 * Bean constructor.
	 */
	public LdapConnectionException() {
		super();
	}

	/**
	 * Bean constructor.
	 * @param message
	 */
	public LdapConnectionException(final String message) {
		super(message);
	}

	/**
	 * Bean constructor.
	 * @param cause
	 */
	public LdapConnectionException(final Exception cause) {
		super(cause);
	}

	/**
	 * Bean constructor.
	 * @param message
	 * @param cause
	 */
	public LdapConnectionException(final String message, final Exception cause) {
		super(message, cause);
	}

}
