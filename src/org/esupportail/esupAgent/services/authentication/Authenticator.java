package org.esupportail.esupAgent.services.authentication;

import org.esupportail.esupAgent.domain.beans.User;

/**
 * The interface of authenticators.
 */
public interface Authenticator {

	/**
	 * @return the authenticated user.
	 */
	User getUser();

}