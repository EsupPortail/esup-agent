/**
 * ESUP-Portail Commons - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-commons
 */
package org.esupportail.commons.services.exceptionHandling;

import java.io.Serializable;



/**
 * A factory for exception services.
 * 
 * See /properties/exceptionHandling/exceptionHandling-example.xml.
 */
public interface ExceptionServiceFactory extends Serializable {
	
	/**
	 * @return a new ExceptionService instance.
	 */
	ExceptionService getExceptionService();

}
