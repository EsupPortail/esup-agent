package org.esupportail.esupAgent.web.controllers;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.esupportail.esupAgent.domain.beans.Agent;
import org.esupportail.esupAgent.domain.beans.User;
import org.esupportail.esupAgent.services.application.AgentApplicationServiceImpl;

import org.esupportail.commons.services.ldap.LdapUser;
import org.esupportail.commons.services.ldap.LdapUserService;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.commons.utils.BeanUtils;

/**
 * @author Sebastien Montel
 * 
 */
public class GestionController extends AbstractContextAwareController {

	private String loginAs;
	private LdapUser userLdap;
	private LdapUserService ldapUserService;
	private CarriereController carriereController;
	private ContratController contratController;

	private final Logger logger = new LoggerImpl(getClass());

	/**
	 * @return the loginAs
	 */
	public String getLoginAs() {
		return loginAs;
	}

	/**
	 * @param loginAs
	 *            the loginAs to set
	 */
	public void setLoginAs(String loginAs) {
		this.loginAs = loginAs;
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
	 * @return the carriereController
	 */
	public CarriereController getCarriereController() {
		return carriereController;
	}

	/**
	 * @param carriereController the carriereController to set
	 */
	public void setCarriereController(CarriereController carriereController) {
		this.carriereController = carriereController;
	}
	
	

	/**
	 * @return the contratController
	 */
	public ContratController getContratController() {
		return contratController;
	}

	/**
	 * @param contratController the contratController to set
	 */
	public void setContratController(ContratController contratController) {
		this.contratController = contratController;
	}

	/**
	 * @return true if the current user is allowed to view the page.
	 */
	public boolean isPageAuthorized() {
		User currentUser = getCurrentUser();
		if (currentUser == null) {
			return false;
		}
		return currentUser.getAdmin();
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
		logger.info("dans GestionController::enter");
		return "navigationGestion";
	}

	public String seConnecterSous() {
		User newUser;
		//Agent newAgent = new Agent();

		if (!isPageAuthorized()) {
			addUnauthorizedActionMessage();
			return null;
		}
		newUser = getDomainService().getUser(userLdap.getId());
/*		newAgent.setSupannEmpId(new Integer(userLdap
				.getAttribute("supannEmpId")).intValue());
		newAgent
				.setWsdl_url_dossier_rh_personnel(((AgentApplicationServiceImpl) getApplicationService())
						.getConfigAgent().getWsdl_url_dossier_rh_personnel());
		newUser.setAgent(newAgent);*/

		getSessionController().setUserLoginUnder(newUser);
		carriereController.deleteInfo();
		contratController.deleteInfo();
//logger.info("seConnecterSous" + newUser.getAgent().getConsulterEtatCivil().getIndividuReponseEtatCivil().getPrenom());
		
		return "navigationGestion";

	}

	public String revenir() throws Exception {
		if (!isPageAuthorized()) {
			addUnauthorizedActionMessage();
			return null;
		}
		userLdap = null;
		loginAs = null;
		getSessionController().setUserLoginUnder(null);
		
		return "navigationGestion";
	}

	public void validateInput(FacesContext context,
			UIComponent componentToValidate, Object value)
			throws ValidatorException {
		try {
			userLdap = this.ldapUserService.getLdapUser((String) value);
		} catch (Exception e) {
			throw new ValidatorException(
					getFacesErrorMessage("GESTION.TEXT.INVALIDINPUT"));
		}

	}
}
