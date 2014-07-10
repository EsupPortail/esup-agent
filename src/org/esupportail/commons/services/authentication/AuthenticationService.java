/**
 * ESUP-Portail Commons - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-commons
 */
package org.esupportail.commons.services.authentication;

import java.io.Serializable;

import org.esupportail.commons.services.authentication.info.AuthInfo;
import org.springframework.beans.factory.InitializingBean;


/** 
 * The interface of the service used to get authentication.
 */
public interface AuthenticationService extends Serializable, InitializingBean {
	
	/**
	 * @return true if enabled.
	 */
	boolean isEnabled();
	
	/**
	 * @return the current auth.
	 */
	AuthInfo getAuthInfo();
	
}
