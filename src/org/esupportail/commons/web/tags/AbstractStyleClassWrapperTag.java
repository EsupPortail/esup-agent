/**
 * ESUP-Portail Commons - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-commons
 */
package org.esupportail.commons.web.tags;


/**
 * An abstract class for tags that wrap into a HTML and set a default style class.
 */
public abstract class AbstractStyleClassWrapperTag extends AbstractWrapperTag {

	/**
	 * Constructor.
	 */
	public AbstractStyleClassWrapperTag() {
		super();
	}
	
	/**
	 * @see org.esupportail.commons.web.tags.AbstractWrapperTag#getStyleClass()
	 */
	@Override
	protected String getStyle() {
		return null;
	}
	
}
