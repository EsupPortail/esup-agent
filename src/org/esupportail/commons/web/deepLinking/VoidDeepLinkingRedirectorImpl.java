/**
 * ESUP-Portail Commons - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-commons
 */
package org.esupportail.commons.web.deepLinking;

import java.util.Map;

/**
 * A deep linking redirector that does nothing.
 */
public class VoidDeepLinkingRedirectorImpl extends AbstractDeepLinkingRedirector {

	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = -6391565892488759730L;

	/**
	 * Bean constructor.
	 */
	public VoidDeepLinkingRedirectorImpl() {
		super();
	}

	/**
	 * @see org.esupportail.commons.beans.AbstractI18nAwareBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() {
		// non need to check anything
	}

	/**
	 * @see org.esupportail.commons.web.deepLinking.DeepLinkingRedirector#redirect(java.util.Map)
	 */
	public String redirect(
			@SuppressWarnings("unused")
			final Map<String, String> params) {
		return null;
	}

}
