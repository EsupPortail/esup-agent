package org.esupportail.esupAgent.web.controllers;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.esupportail.commons.services.ldap.LdapUser;
import org.esupportail.commons.services.ldap.LdapUserService;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.esupAgent.domain.beans.User;

public class TestController extends AbstractContextAwareController {

	private String loginAs;

	private final Logger logger = new LoggerImpl(getClass());

	private LdapUser testUser;

	private LdapUserService ldapUserService;
	
	

	/**
	 * @return the ldapUserService
	 */
	public LdapUserService getLdapUserService() {
		return ldapUserService;
	}

	/**
	 * @param ldapUserService the ldapUserService to set
	 */
	public void setLdapUserService(LdapUserService ldapUserService) {
		this.ldapUserService = ldapUserService;
	}

	/**
	 * @return the ldapUid
	 */
	public String getLoginAs() {
		return loginAs;
	}

	/**
	 * @param ldapUid
	 *            the ldapUid to set
	 */
	public void setLoginAs(String loginAs) {
		this.loginAs = loginAs;
	}

	public TestController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + "#" + hashCode();
	}

	/**
	 * @see org.esupportail.esupAgent.web.controllers.AbstractDomainAwareBean#reset()
	 */
	@Override
	public void reset() {
		super.reset();
		enter();
	}

	/**
	 * @return true if the current user is allowed to view the page.
	 */
	public boolean isPageAuthorized() {
		return true;
	}

	/**
	 * JSF callback.
	 * 
	 * @return a String.
	 */
	public String enter() {
		if (!isPageAuthorized()) {
			addUnauthorizedActionMessage();
			return null;
		}
		return "navigationTest";
	}

	public void cherche(FacesContext context, UIComponent componentToValidate,
			Object value) throws ValidatorException {
		try {
			logger.info("Saisie : " + (String)value);
			testUser = this.ldapUserService.getLdapUser((String)value);
			logger.info("user : " + testUser.toString());
		} catch (Exception e) {
			throw new ValidatorException(
					getFacesErrorMessage("GESTION.TEXT.INVALIDINPUT"));
		}
	}

	public String affiche() {
		if (!isPageAuthorized()) {
			addUnauthorizedActionMessage();
			return null;
		}
		//getSessionController().setValeurTest(loginAs+ "aaa");
		getSessionController().setUserLoginUnder(getDomainService().getUser(testUser.getId()));
		logger.info(getSessionController().getUserLoginUnder().getId());
		return "navigationWelcome";
	}
}
