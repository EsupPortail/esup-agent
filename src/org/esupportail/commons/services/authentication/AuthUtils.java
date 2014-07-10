/**
 * ESUP-Portail Commons - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-commons
 */
package org.esupportail.commons.services.authentication;

import java.util.List;
import java.util.Map;

import org.esupportail.commons.services.authentication.info.AuthInfo;
import org.esupportail.commons.services.authentication.info.AuthInfoImpl;

/** 
 * Authentication utilities.
 */
public abstract class AuthUtils {
	
	/**
	 * Type for null authentication.
	 */
	public static final String NONE = ""; 

	/**
	 * Type for application authentication.
	 */
	public static final String APPLICATION = "application"; 

	/**
	 * Type for CAS authentication.
	 */
	public static final String CAS = "cas"; 

	/**
	 * Type for Shibboleth authentication.
	 */
	public static final String SHIBBOLETH = "shibboleth"; 

	/**
	 * Constructor.
	 */
	private AuthUtils() {
		super();
	}

	/**
	 * @param id 
	 * @param type 
	 * @param attributes 
	 * @return an AuthInfo
	 */
	public static AuthInfo authInfo(
			final String id,
			final String type,
			final Map<String, List<String>> attributes) {
		return new AuthInfoImpl(id, type, attributes);
	}
	
	/**
	 * @param id 
	 * @param type 
	 * @return an AuthInfo
	 */
	public static AuthInfo authInfo(
			final String id,
			final String type) {
		return authInfo(id, type, null);
	}
	
	/**
	 * @param userId
	 * @return a database AuthInfo
	 */
	public static AuthInfo applicationAuthInfo(final String userId) {
		return new AuthInfoImpl(userId, APPLICATION);
	}
	
}
