/**
 * 
 */
package org.esupportail.esupAgent.domain.beans.config;

import java.util.ArrayList;
import java.util.List;

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
	private DomainService domainService;

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
	 * @param domainService
	 *            the domainService to set
	 */
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}

}
