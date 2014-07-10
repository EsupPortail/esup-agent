/**
 * ESUP-Portail ESUP Agent - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-agent
 */
package org.esupportail.esupAgent.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationCoordonneesPersonnelles.AdresseDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationCoordonneesPersonnelles.ConsultationCoordonneesPersonnellesDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ModificationAdressePersonnelle.AdressePersonnelleDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ModificationAdressePersonnelle.PaysDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ModificationAdressePersonnelle.VoieDto;
import gouv.education.harpege.transverse.dto.refGeo.VoirieDto;

import org.esupportail.commons.services.ldap.LdapUserService;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.esupAgent.domain.beans.Agent;
import org.esupportail.esupAgent.domain.beans.User;
import org.esupportail.esupAgent.web.beans.ReferenceGeographique;

/**
 * A visual bean for the welcome page.
 */
public class WelcomeController extends AbstractContextAwareController {

	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = -239570715531002003L;

	private LdapUserService ldapUserService;
	private final Logger logger = new LoggerImpl(getClass());
	private Boolean isAfficheFormTelephonePortable = false;
	private Boolean isAfficheFormEmail = false;
	private Boolean isAfficheFormAdresse = false;
	private String telephonePortable = "";
	private String email = "";
	private AdresseDto adresseDto;
	private List<SelectItem> choixVoirie;
	//private AdressePersonnelleDto adressePersonnelleDto = new AdressePersonnelleDto();
	private String codeVoie;
	private String codePostal;
	private String ville;
	private String numeroVoie;
	private String nomVoie;
	private String telephoneDomicile;
	private String numeroFax;
	private String temoinAdressePrincipale;
	private String habitantChez;
	private Integer identifiantAdresse;
	private String codePays;
	private String bisTer;
	
	

	public String getCodePays() {
		return getSessionController().getCurrentUser().getAgent()
		.getConsulterCoordonneesPersonnellesDto()[0].getAdresseDto().getPays().getCodePays();
	}

	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}

	public Integer getIdentifiantAdresse() {
		return getSessionController().getCurrentUser().getAgent()
		.getConsulterCoordonneesPersonnellesDto()[0].getAdresseDto().getIdentifiantAdresse();
	}

	public void setIdentifiantAdresse(Integer identifiantAdresse) {
		this.identifiantAdresse = identifiantAdresse;
	}

	public String getHabitantChez() {
		return getSessionController().getCurrentUser().getAgent()
				.getConsulterCoordonneesPersonnellesDto()[0].getAdresseDto()
				.getHabitantChez();
	}

	public void setHabitantChez(String habitantChez) {
		this.habitantChez = habitantChez;
	}

	public String getTemoinAdressePrincipale() {
		/*logger.info("temoin :" + getSessionController().getCurrentUser().getAgent()
				.getConsulterCoordonneesPersonnellesDto()[0].getAdresseDto()
				.getTemoinAdressePrincipale());*/
		return getSessionController().getCurrentUser().getAgent()
				.getConsulterCoordonneesPersonnellesDto()[0].getAdresseDto()
				.getTemoinAdressePrincipale();
	}

	public void setTemoinAdressePrincipale(String temoinAdressePrincipale) {
		this.temoinAdressePrincipale = temoinAdressePrincipale;
	}

	public String getNumeroVoie() {
		return getSessionController().getCurrentUser().getAgent()
				.getConsulterCoordonneesPersonnellesDto()[0].getAdresseDto()
				.getNumeroVoie();
	}

	public void setNumeroVoie(String numeroVoie) {
		this.numeroVoie = numeroVoie;
	}

	public String getNomVoie() {
		return getSessionController().getCurrentUser().getAgent()
				.getConsulterCoordonneesPersonnellesDto()[0].getAdresseDto()
				.getNomVoie();
	}

	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	public String getTelephoneDomicile() {
		return getSessionController().getCurrentUser().getAgent()
				.getConsulterCoordonneesPersonnellesDto()[0].getAdresseDto()
				.getTelephoneDomicile();
	}

	public void setTelephoneDomicile(String telephoneDomicile) {
		this.telephoneDomicile = telephoneDomicile;
	}

	public String getNumeroFax() {
		return getSessionController().getCurrentUser().getAgent()
				.getConsulterCoordonneesPersonnellesDto()[0].getAdresseDto()
				.getNumeroFax();
	}

	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}

	public String getVille() {
		return getSessionController().getCurrentUser().getAgent()
				.getConsulterCoordonneesPersonnellesDto()[0].getAdresseDto()
				.getVille();
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePostal() {
		return getSessionController().getCurrentUser().getAgent()
				.getConsulterCoordonneesPersonnellesDto()[0].getAdresseDto()
				.getCodePostal();
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	
	
	public String getBisTer() {
		return getSessionController().getCurrentUser().getAgent()
		.getConsulterCoordonneesPersonnellesDto()[0].getAdresseDto().getBisTer();
	}

	public void setBisTer(String bisTer) {
		this.bisTer = bisTer;
	}

	public String getCodeVoie() {
		return getSessionController().getCurrentUser().getAgent()
				.getConsulterCoordonneesPersonnellesDto()[0].getAdresseDto()
				.getVoie().getCodeVoie();
	}

	public void setCodeVoie(String codeVoie) {
		this.codeVoie = codeVoie;
	}

	
	public List<SelectItem> getChoixBisTer(){
		List<SelectItem> choixBisTer = new ArrayList<SelectItem>();
		choixBisTer.add(new SelectItem("",""));
		choixBisTer.add(new SelectItem("B","Bis"));
		choixBisTer.add(new SelectItem("T","Ter"));
		choixBisTer.add(new SelectItem("Q","Quater"));
		choixBisTer.add(new SelectItem("C","Quinquies"));
		return choixBisTer;
	}
	
	public List<SelectItem> getChoixVoirie() {
		VoirieDto[] voirieDtoTab;
		ReferenceGeographique referenceGeographique;
		referenceGeographique = new ReferenceGeographique(
				getSessionController().getCurrentUser().getAgent()
						.getWsdl_anonymous(), getSessionController()
						.getCurrentUser().getAgent().getWsdl_usr_name(),
				getSessionController().getCurrentUser().getAgent()
						.getWsdl_usr_password(), getSessionController()
						.getCurrentUser().getAgent()
						.getWsdl_url_referentiel_geographique());

		List<SelectItem> choixVoirie = new ArrayList<SelectItem>();
		voirieDtoTab = referenceGeographique.getVoirieReponseWSDto()
				.getVoirieDtoTab();
		for (VoirieDto v : voirieDtoTab) {
			choixVoirie
					.add(new SelectItem(v.getCodeVoie(), v.getLibelleVoie()));
		}
		return choixVoirie;

	}

	public AdresseDto getAdresseDto() {
		return getSessionController().getCurrentUser().getAgent()
				.getConsulterCoordonneesPersonnellesDto()[0].getAdresseDto();
	}

	public void setAdresseDto(AdresseDto adresseDto) {
		this.adresseDto = adresseDto;
	}

	public Boolean getIsAfficheFormAdresse() {
		return isAfficheFormAdresse;
	}

	public void setIsAfficheFormAdresse(Boolean isAfficheFormAdresse) {
		this.isAfficheFormAdresse = isAfficheFormAdresse;
	}

	public Boolean getIsAfficheFormEmail() {
		return isAfficheFormEmail;
	}

	public void setIsAfficheFormEmail(Boolean isAfficheFormEmail) {
		this.isAfficheFormEmail = isAfficheFormEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephonePortable() {
		return telephonePortable;
	}

	public void setTelephonePortable(String numeroPortable) {
		this.telephonePortable = numeroPortable;
	}

	public Boolean getIsAfficheFormTelephonePortable() {
		return isAfficheFormTelephonePortable;
	}

	public void setIsAfficheFormTelephonePortable(
			Boolean isAfficheFormTelephonePortable) {
		this.isAfficheFormTelephonePortable = isAfficheFormTelephonePortable;
	}

	public void modPortable() {
		getSessionController().getCurrentUser().getAgent()
				.modifierCoordonneesPersonnelles(telephonePortable, null);
		isAfficheFormTelephonePortable = false;
	}

	public void modEmail() {
		getSessionController().getCurrentUser().getAgent()
				.modifierCoordonneesPersonnelles(null, email);
		isAfficheFormEmail = false;
	}

	public void modAdresse() {
		AdressePersonnelleDto adressePersonnelleDto = new AdressePersonnelleDto();

		/*logger.info("code voie " + this.codeVoie + "\n" + "code Postal "
				+ this.codePostal + "\n" + "Ville " + this.ville + "\n"
				+ "numero voie " + this.numeroVoie + "\n" + "nom voie "
				+ this.nomVoie + "\n" + "telephone domicile "
				+ this.telephoneDomicile + "\n" + "fax " + this.numeroFax + "\n" 
				+ "temoin principale " + this.temoinAdressePrincipale + "\n"
				+ "habitant chez " + this.habitantChez + "\n" 
				+ "identifiantAdresse " + this.identifiantAdresse  + "\n"
				+ "code Pays" + this.codePays);*/

		adressePersonnelleDto.setIdentifiantAdresse(this.getIdentifiantAdresse());
		adressePersonnelleDto.setNumeroIndividu(getSessionController()
				.getCurrentUser().getAgent().getSupannEmpId());
		adressePersonnelleDto.setNumeroVoie(this.numeroVoie);
		adressePersonnelleDto.setBisTer(bisTer);
		adressePersonnelleDto.setVoie(new VoieDto());
		adressePersonnelleDto.getVoie().setCodeVoie(this.codeVoie);
		adressePersonnelleDto.setNomVoie(this.nomVoie);
		adressePersonnelleDto.setHabitantChez(this.habitantChez);
		adressePersonnelleDto.setCodePostal(this.codePostal);
		adressePersonnelleDto.setVille(this.ville);
		adressePersonnelleDto.setTelephoneDomicile(this.telephoneDomicile);
		adressePersonnelleDto.setNumeroFax(this.numeroFax);
		adressePersonnelleDto.setTemoinAdressePrincipale(this.getTemoinAdressePrincipale());
		adressePersonnelleDto.setPays(new PaysDto());
		adressePersonnelleDto.getPays().setCodePays(this.getCodePays());

		getSessionController().getCurrentUser().getAgent().modifierAdressePersonnelle(adressePersonnelleDto);
		isAfficheFormAdresse = false;
	}

	/**
	 * Bean constructor.
	 */
	public WelcomeController() {
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
		/*
		 * if (getSessionController().getUserLoginUnder()!=null){
		 * logger.info(getSessionController
		 * ().getUserLoginUnder().getAgent().getConsulterEtatCivil
		 * ().getIndividuReponseEtatCivil().getNomPatronymique()); }
		 */
		isAfficheFormTelephonePortable = false;
		isAfficheFormEmail = false;
		isAfficheFormAdresse = false;
		
		return "navigationWelcome";
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

	public User getDisplayUser() {

		if (getSessionController().getUserLoginUnder() != null) {
			return getSessionController().getUserLoginUnder();
		} else {

			return getSessionController().getCurrentUser();

		}

	}

	public void afficheModTelephonePortable() {
		if (getSessionController().getCurrentUser().getAgent()
				.getTelephonePortableModifiable()) {
			isAfficheFormTelephonePortable = !isAfficheFormTelephonePortable;

		}
	}

	public void afficheModEmail() {
		if (getSessionController().getCurrentUser().getAgent()
				.getEmailModifiable()) {
			isAfficheFormEmail = !isAfficheFormEmail;

		}
	}

	public void afficheModAdresse() {
		if (getSessionController().getCurrentUser().getAgent()
				.getAdresseModifiable()) {
			isAfficheFormAdresse = !isAfficheFormAdresse;

		}
	}
}
