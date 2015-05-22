package org.esupportail.esupAgent.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.esupportail.commons.services.ldap.LdapUser;
import org.esupportail.commons.services.ldap.LdapUserService;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.commons.services.smtp.SmtpService;
import org.esupportail.commons.services.smtp.SmtpUtils;
import org.esupportail.esupAgent.domain.beans.ContactMail;
import org.esupportail.esupAgent.domain.beans.EnvoiMail;
import org.esupportail.esupAgent.domain.beans.User;
import org.esupportail.esupAgent.services.application.AgentApplicationServiceImpl;

public class QuestionController extends AbstractContextAwareController {

	private LdapUser userLdap;
	private LdapUserService ldapUserService;
	private String message;
	private String titre;
	private EnvoiMail envoiMail;
	private List<SelectItem> choixContact;
	private String contactSelected=null;

	public String getContactSelected() {
		return contactSelected;
	}

	public void setContactSelected(String contactSelected) {
		this.contactSelected = contactSelected;
	}

	public List<SelectItem> getChoixContact() {		
		envoiMail = ((AgentApplicationServiceImpl) getApplicationService())
				.getEnvoiMail();
		List<SelectItem> choixContact = new ArrayList<SelectItem>();
		logger.debug("envoieMail : " + envoiMail.getContactList().size());
		for (Entry<String, ContactMail> entry : envoiMail.getContactList()
				.entrySet()) {
			if (contactSelected==null){
				contactSelected=entry.getKey();
			}			
			choixContact.add(new SelectItem(entry.getKey(), entry.getValue()
					.getLibelle()));
		}
		return choixContact;
	}

	public void setChoixContact(List<SelectItem> choixContact) {
		this.choixContact = choixContact;
	}

	public EnvoiMail getEnvoiMail() {
		envoiMail = ((AgentApplicationServiceImpl) getApplicationService())
				.getEnvoiMail();
		if (envoiMail.getContactList() != null) {
			logger.debug("envoieMail : " + envoiMail.getContactList().size());
			for (Entry<String, ContactMail> entry : envoiMail.getContactList()
					.entrySet()) {
				System.out.println("Key = " + entry.getKey() + ", Value = "
						+ entry.getValue());
			}
		}
		return envoiMail;
	}

	public void setEnvoiMail(EnvoiMail envoiMail) {
		this.envoiMail = envoiMail;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre
	 *            the titre to set
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
		getEnvoiMail();
		if (!isPageAuthorized()) {
			addUnauthorizedActionMessage();
			return null;
		}
		logger.info("dans QuestionController::enter");
		return "navigationQuestion";
	}

	public String sendMessage() {
		InternetAddress[] destinataires = null;
		logger.info("dans QuestionController::sendMessage");
		logger.info("Message : " + message);
		if (envoiMail.getContactList() != null) {
			for (Entry<String, ContactMail> entry : envoiMail.getContactList()
					.entrySet()) {
				if (entry.getKey().equals(contactSelected)) {
					logger.info("taille "
							+ entry.getValue().getAddressList().size());
					destinataires = new InternetAddress[entry.getValue()
							.getAddressList().size()];
					for (int i = 0; i < entry.getValue().getAddressList()
							.size(); i++) {
						logger.info((String) entry.getValue().getAddressList()
								.get(i));
						try {
							destinataires[i] = new InternetAddress(
									(String) entry.getValue().getAddressList()
											.get(i));
						} catch (AddressException e) {
							// TODO Auto-generated catch block
							logger.info("Erreur sur mail : " + e.getMessage());
						}
						/*
						 * try { destinataires[i] = new InternetAddress((String)
						 * entry .getValue().getAddressList().get(i));
						 * logger.info((String) entry
						 * .getValue().getAddressList().get(i)); } catch
						 * (AddressException e) { // TODO Auto-generated catch
						 * block e.printStackTrace(); }
						 */

					}
					break;
				}
			}
		}

		// try {
		//
		// this.smtpService.send(new InternetAddress(
		// ((AgentApplicationServiceImpl) getApplicationService())
		// .getConfigAgent().getContactHarpege()),
		// "[esup-agent]" + getCurrentUser().getDisplayName() + ":"
		// + titre, message, message);
		//
		// } catch (AddressException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

//		for (int j = 0; j < destinataires.length; j++) {
//			logger.info(j + " : " + destinataires[j].getAddress());
//		}
		try {
			String subject = "[esup-agent] " + getCurrentUser().getDisplayName()
								+ " : " + titre;
			if (destinataires==null || destinataires.length == 0) {
				String contact = ((AgentApplicationServiceImpl) getApplicationService()).getConfigAgent().getContactHarpege();
				destinataires = new InternetAddress[] { new InternetAddress(contact) };
			}
				logger.info(destinataires[0].toString());
				this.smtpService.sendtocc(destinataires, null, null, subject, null, message, null);
			FacesMessage fm = new FacesMessage("Le message a \u00E9t\u00E9 envoy\u00E9");
            FacesContext.getCurrentInstance().addMessage(null,fm);
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "navigationQuestion";

	}
	
	public void validateMessage(FacesContext ctx, UIComponent componentToValidate, Object obj)
	   throws ValidatorException {
	       if (obj != null){
	           if (((String)obj).length()<20)
	               throw new ValidatorException(new FacesMessage("Erreur : le message ne doit pas comporter moins de 20 caract\u00E8res"));	           
	       }
	   }

	public void validateTitre(FacesContext ctx, UIComponent componentToValidate, Object obj)
	   throws ValidatorException {
	       if (obj != null){
	           if (((String)obj).length()<1)
	               throw new ValidatorException(new FacesMessage("Erreur : il manque un titre"));
	       }
	   }
	
}
