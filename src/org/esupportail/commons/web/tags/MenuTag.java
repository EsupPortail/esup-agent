/**
 * ESUP-Portail Commons - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-commons
 */
package org.esupportail.commons.web.tags;

import javax.faces.component.UIComponent;

import org.esupportail.commons.web.tags.config.TagsConfigurator;

/**
 * ESUP-Portail implementation of the 'menu' tag.
 */
public class MenuTag extends UlTag {

	/**
	 * Constructor.
	 */
	public MenuTag() {
		super();
	}

	/**
	 * @see org.esupportail.commons.web.tags.UlTag#setProperties(javax.faces.component.UIComponent)
	 */
	@Override
	protected void setProperties(final UIComponent component) {
		TagsConfigurator tagsConfigurator = TagsConfigurator.getInstance(); 
		setStyleClass(tagsConfigurator.getMenuStyleClass());
		super.setProperties(component);
	}
}
