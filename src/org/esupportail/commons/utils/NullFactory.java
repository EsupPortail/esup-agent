/**
 * ESUP-Portail Commons - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-commons
 */
package org.esupportail.commons.utils; 

/**
 * A class to create null beans.
 */
public abstract class NullFactory {

	/**
	 * Constructor.
	 */
	private NullFactory() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return a null object
	 */
	public static Object create() {
		return null;
	}

}
