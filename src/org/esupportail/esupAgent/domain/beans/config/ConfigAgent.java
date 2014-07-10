/**
 * 
 */
package org.esupportail.esupAgent.domain.beans.config;

import java.util.ArrayList;
import java.util.List;

import org.esupportail.commons.services.smtp.SmtpService;
import org.esupportail.esupAgent.domain.DomainService;
import org.esupportail.esupAgent.domain.beans.User;
import org.springframework.beans.factory.InitializingBean;
/**
 * @author SŽbastien Montel
 * 
 */
public class ConfigAgent implements InitializingBean {

	private List<User> admins;
	private String admins_string;
	private String wsdl_url_referentiel_geographique;
	private String wsdl_url_referentiel_rh;
	private String wsdl_url_dossier_rh_personnel;
	private String wsdl_url_dossier_rh_administratif;
	private String ldap_HarpegeId;
	private DomainService domainService;
	private boolean visualisationCompte;
	private String contactHarpege;
	private boolean wsdl_anonymous;
	private String wsdl_usr_name;
	private String wsdl_usr_password;
	


	/**
	 * @return the wsdl_anonymous
	 */
	public boolean getWsdl_anonymous() {
		return wsdl_anonymous;
	}

	/**
	 * @param wsdl_anonymous the wsdl_anonymous to set
	 */
	public void setWsdl_anonymous(boolean wsdl_anonymous) {
		this.wsdl_anonymous = wsdl_anonymous;
	}

	/**
	 * @return the wsdl_usr_name
	 */
	public String getWsdl_usr_name() {
		return wsdl_usr_name;
	}

	/**
	 * @param wsdl_usr_name the wsdl_usr_name to set
	 */
	public void setWsdl_usr_name(String wsdl_usr_name) {
		this.wsdl_usr_name = wsdl_usr_name;
	}

	/**
	 * @return the wsdl_usr_password
	 */
	public String getWsdl_usr_password() {
		return wsdl_usr_password;
	}

	/**
	 * @param wsdl_usr_password the wsdl_usr_password to set
	 */
	public void setWsdl_usr_password(String wsdl_usr_password) {
		this.wsdl_usr_password = wsdl_usr_password;
	}

	/**
	 * @return the contactHarpege
	 */
	public String getContactHarpege() {
		return contactHarpege;
	}

	/**
	 * @param contactHarpege the contactHarpege to set
	 */
	public void setContactHarpege(String contactHarpege) {
		this.contactHarpege = contactHarpege;
	}

	/**
	 * @return the visualisationCompte
	 */
	public boolean getVisualisationCompte() {
		return visualisationCompte;
	}

	/**
	 * @param visualisationCompte the visualisationCompte to set
	 */
	public void setVisualisationCompte(boolean visualisationCompte) {
		this.visualisationCompte = visualisationCompte;
	}

	public void afterPropertiesSet() throws Exception {
		 admins=new ArrayList<User>();
		 String[] tabAdmin= admins_string.split(",");
		 for (String login : tabAdmin) {
			User admin=new User(login.trim());
			admins.add(admin);
		}
	}

	public List<User> getAdmins() {
		return admins;
	}

	public void setAdmins(List<User> admins) {
		this.admins = admins;
	}

	public String getWsdl_url_referentiel_geographique() {
		return wsdl_url_referentiel_geographique;
	}

	public void setWsdl_url_referentiel_geographique(
			String wsdl_url_referentiel_geographique) {
		this.wsdl_url_referentiel_geographique = wsdl_url_referentiel_geographique;
	}

	public String getWsdl_url_referentiel_rh() {
		return wsdl_url_referentiel_rh;
	}

	public void setWsdl_url_referentiel_rh(String wsdl_url_referentiel_rh) {
		this.wsdl_url_referentiel_rh = wsdl_url_referentiel_rh;
	}

	public String getWsdl_url_dossier_rh_personnel() {
		return wsdl_url_dossier_rh_personnel;
	}

	public void setWsdl_url_dossier_rh_personnel(
			String wsdl_url_dossier_rh_personnel) {
		this.wsdl_url_dossier_rh_personnel = wsdl_url_dossier_rh_personnel;
	}

	public String getWsdl_url_dossier_rh_administratif() {
		return wsdl_url_dossier_rh_administratif;
	}

	public void setWsdl_url_dossier_rh_administratif(
			String wsdl_url_dossier_rh_administratif) {
		this.wsdl_url_dossier_rh_administratif = wsdl_url_dossier_rh_administratif;
	}

	public String getAdmins_string() {
		return admins_string;
	}

	public void setAdmins_string(String adminsString) {
		admins_string = adminsString;
	}

	/**
	 * @return the domainService
	 */
	public DomainService getDomainService() {
		return domainService;
	}

	/**
	 * @return the ldap_HarpegeId
	 */
	public String getLdap_HarpegeId() {
		return ldap_HarpegeId;
	}

	/**
	 * @param ldap_HarpegeId the ldap_HarpegeId to set
	 */
	public void setLdap_HarpegeId(String ldap_HarpegeId) {
		this.ldap_HarpegeId = ldap_HarpegeId;
	}

	/**
	 * @param domainService
	 *            the domainService to set
	 */
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

}
