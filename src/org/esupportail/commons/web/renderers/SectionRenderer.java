/**
 * ESUP-Portail Commons - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-commons
 */
package org.esupportail.commons.web.renderers;

import org.esupportail.commons.web.tags.config.TagsConfigurator;

/**
 * ESUP-Portail renderer for the section tag.
 */
public class SectionRenderer extends AbstractTagWrapperRenderer {

	/**
	 * The renderer type.
	 */
	public static final String RENDERER_TYPE = "org.esupportail.SectionRenderer";

	/**
	 * Constructor.
	 */
	public SectionRenderer() {
		super();
	}
	
	/**
	 * @see org.esupportail.commons.web.renderers.AbstractTagWrapperRenderer#getTag()
	 */
	@Override
	protected String getTag() {
		return TagsConfigurator.getInstance().getSectionTag();
	}

}
