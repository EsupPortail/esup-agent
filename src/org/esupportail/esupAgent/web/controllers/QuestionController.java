package org.esupportail.esupAgent.web.controllers;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.esupportail.commons.services.ldap.LdapUser;
import org.esupportail.commons.services.ldap.LdapUserService;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.commons.services.smtp.SmtpService;
import org.esupportail.commons.services.smtp.SmtpUtils;
import org.esupportail.esupAgent.domain.beans.User;
import org.esupportail.esupAgent.services.application.AgentApplicationServiceImpl;

public class QuestionController extends AbstractContextAwareController {

	private LdapUser userLdap;
	private LdapUserService ldapUserService;
	private String message;
	private String titre;
	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	private SmtpService smtpService;

	/**
	 * @return the smtpService
	 */
	public SmtpService getSmtpService() {
		return smtpService;
	}

	/**
	 * @param smtpService
	 *            the smtpService to set
	 */
	public void setSmtpService(SmtpService smtpService) {
		this.smtpService = smtpService;
	}

	public QuestionController() {
		super();
		message = "";
	}

	/**
	 * @return the userLdap
	 */
	public LdapUser getUserLdap() {
		return userLdap;
	}

	/**
	 * @param userLdap
	 *            the userLdap to set
	 */
	public void setUserLdap(LdapUser userLdap) {
		this.userLdap = userLdap;
	}

	/**
	 * @return the ldapUserService
	 */
	public LdapUserService getLdapUserService() {
		return ldapUserService;
	}

	/**
	 * @param ldapUserService
	 *            the ldapUserService to set
	 */
	public void setLdapUserService(LdapUserService ldapUserService) {
		this.ldapUserService = ldapUserService;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message
	 *            the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	private final Logger logger = new LoggerImpl(getClass());

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
		logger.info("dans QuestionController::enter");
		return "navigationQuestion";
	}

	public void sendMessage(){
		logger.info("dans QuestionController::sendMessage");
		logger.info("Message : " + message);
		try {
			this.smtpService.send(new InternetAddress(((AgentApplicationServiceImpl) getApplicationService())
					.getConfigAgent().getContactHarpege()), "[esup-agent]" + getCurrentUser().getDisplayName() + ":" + titre, message, message);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
