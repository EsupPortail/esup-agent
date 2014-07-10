package org.esupportail.esupAgent.web.controllers;

import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.esupAgent.domain.beans.User;

/**
 * 
 * @author Sebastien Montel
 *
 */
public class AvancementController extends AbstractContextAwareController {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3269978828430014588L;
	
	private final Logger logger = new LoggerImpl(getClass());
	
	
	public AvancementController() {
		super();
	}
	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + "#" + hashCode();
	}

	/**
	 * @return true if the current user is allowed to view the page.
	 */
	public boolean isPageAuthorized() {
		User currentUser = getCurrentUser();
		if (currentUser == null) {
			return false;
		}
		return true;
	}
	
	public String enter() {
		if (!isPageAuthorized()) {
			addUnauthorizedActionMessage();
			return null;
		}
		getDisplayUser().getAgent().getConsulterDonneesAvancement();
		return "navigationAvancement";
	}
	
	public User getDisplayUser() {

		if (getSessionController().getUserLoginUnder() != null) {

			return getSessionController().getUserLoginUnder();
		} else {

			return getSessionController().getCurrentUser();

		}

	}
	
}
