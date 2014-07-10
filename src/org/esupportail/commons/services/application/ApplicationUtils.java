/**
 * ESUP-Portail Commons - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-commons
 */
package org.esupportail.commons.services.application; 

import org.esupportail.commons.utils.BeanUtils;

/**
 * A class that provides static utilities for applications.
 */
public final class ApplicationUtils {
	
	/**
	 * The name of the application service bean.
	 */
	private static final String APPLICATION_SERVICE_BEAN = "applicationService";

	/**
	 * Private constructor.
	 */
	private ApplicationUtils() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return an application service.
	 */
	public static ApplicationService createApplicationService() {
		return (ApplicationService) BeanUtils.getBean(APPLICATION_SERVICE_BEAN);
	}
	
}

