/**
 * ESUP-Portail Commons - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-commons
 */
package org.esupportail.commons.web.renderers;

import org.apache.myfaces.shared_impl.renderkit.html.HTML;

/**
 * ESUP-Portail renderer for the 'li' tag.
 */
public class LiRenderer extends AbstractTagWrapperRenderer {

	/**
	 * The renderer type.
	 */
	public static final String RENDERER_TYPE = "org.esupportail.LiRenderer";

	/**
	 * Constructor.
	 */
	public LiRenderer() {
		super();
	}
	
	/**
	 * @see org.esupportail.commons.web.renderers.AbstractTagWrapperRenderer#getTag()
	 */
	@Override
	protected String getTag() {
		return HTML.LI_ELEM;
	}

}
