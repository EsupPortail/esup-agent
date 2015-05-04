package org.esupportail.esupAgent.domain.beans;

import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationDonneesAvancement.DonneesAvancementDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationDonneesAvancement.DonneesAvancementReponseWSDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationDonneesPosition.DonneesPositionsDto_V3;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationDonneesPosition.DonneesPositionsReponseWSDto_V3;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationDonneesTableauAvancement.DonneesTableauxAvancementDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationDonneesTableauAvancement.DonneesTableauxAvancementReponseWSDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationElementsCarriere.CarriereDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationElementsCarriere.CarriereDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationElementsCarriere.ElementCarriereDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationElementsCarriere.ElementCarriereFinalDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationElementsCarriere.ElementsCarriereReponseWSDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationElementsCarriere.ElementsCarriereReponseWSDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationContrats.AvenantContratDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationContrats.InformationsContratsDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationContrats.InformationsContratsReponseWSDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationOccupationAffectation.InformationOccupationAffectationGlobalDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationOccupationAffectation.InformationsOccupationAffectationDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationOccupationAffectation.InformationsOccupationAffectationReponseWSDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationCoordonneesPersonnelles.ConsultationCoordonneesPersonnellesDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationCoordonneesPersonnelles.ConsultationCoordonneesPersonnellesReponseWSDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationCoordonnneesBancaires.ConsultationCoordonneesBancairesDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationCoordonnneesBancaires.ConsultationCoordonneesBancairesDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationCoordonnneesBancaires.ConsultationCoordonneesBancairesReponseWSDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationCoordonnneesBancaires.ConsultationCoordonneesBancairesReponseWSDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationDiplomes.ConsultationDiplomesDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationDiplomes.ConsultationDiplomesReponseWSDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationInformationsEtatCivil.ConsultationEtatCivilResponseWSDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationSituationFamiliale.ConsultationSituationFamilialeDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationSituationFamiliale.ConsultationSituationFamilialeReponseWSDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationSituationFamiliale.EnfantDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationSituationFamiliale.EnfantDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ModificationAdressePersonnelle.AdressePersonnelleDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ModificationAdressePersonnelle.ModificationCoordonneesPersonnellesReponseWSDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ModificationCoordonneesPersonnelles.ModificationAdressePersonnelleReponseWSDto;
import gouv.education.harpege.transverse.exception.HarpegeFonctionnelleException;
import gouv.education.harpege.transverse.exception.HarpegeTechniqueException;
import gouv.education.harpege.webservice.client.dossierRhAdministratif.DossierRhAdministratifSoapBindingStub;
import gouv.education.harpege.webservice.client.dossierRhAdministratif.DossierRhAdministratifWebService;
import gouv.education.harpege.webservice.client.dossierRhAdministratif.DossierRhAdministratifWebServiceServiceLocator;
import gouv.education.harpege.webservice.client.dossierRhPersonnel.DossierRhPersonnelSoapBindingStub;
import gouv.education.harpege.webservice.client.dossierRhPersonnel.DossierRhPersonnelWebService;
import gouv.education.harpege.webservice.client.dossierRhPersonnel.DossierRhPersonnelWebServiceServiceLocator;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;

import javax.xml.rpc.ServiceException;

import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.esupAgent.domain.beans.comparators.AvenantContratSort;
import org.esupportail.esupAgent.domain.beans.comparators.ContratSort;
import org.esupportail.esupAgent.domain.beans.comparators.DiplomeSort;
import org.esupportail.esupAgent.domain.beans.comparators.ElementCarriereSort;
import org.esupportail.esupAgent.domain.beans.comparators.EnfantSort;

/**
 * @author uhp
 * 
 */
public class Agent {

	/**
	 * identifiant de l'adresse
	 */
	private Integer identifiantAdresse;

	/**
	 * numéro de voie
	 */
	private String numeroVoie;

	/**
	 * bisTer
	 */
	private String bisTer;

	/**
	 * Code de la voie
	 */
	private String codeVoie;

	/**
	 * Libellé de la voie
	 */
	private String libelleVoie;

	/**
	 * nom de la voie
	 */
	private String nomVoie;

	/**
	 * habitant chez
	 */
	private String habitantChez;

	/**
	 * localite
	 */
	private String localite;

	/**
	 * code postal
	 */
	private String codePostal;

	/**
	 * ville
	 */
	private String ville;

	/**
	 * code pays
	 */
	private String codePays;

	/**
	 * libellé pays
	 */
	private String libellePays;

	/**
	 * code Postal étranger
	 */
	private String codePostalEtranger;

	/**
	 * téléphone domicile
	 */
	private String telephoneDomicile;

	/**
	 * numéro Fax
	 */
	private String numeroFax;

	/**
	 * témoin adresse principale
	 */
	private String temoinAdressePrincipale;

	/**
	 * téléphone portable
	 */
	private String telephonePortable;

	/**
	 * 
	 */
	private String email;

	/**
	 * témoin téléphone portable modifiable
	 */
	private boolean telephonePortableModifiable;
	
	/**
	 * témoin email modifiable
	 */
	private boolean emailModifiable;
	
	/**
	 * témoin adresse modifiable
	 */	
	private boolean adresseModifiable;

	private boolean wsdl_anonymous;
	private String wsdl_usr_name;
	private String wsdl_usr_password;
	private boolean visualisationCompte;
	
	private Integer supannEmpId;
	private DossierRHAdministratif dossierRHAdministratif;
	private DossierRhPersonnelWebServiceServiceLocator dossierRhPersonnelWebServiceServiceLocator;
	private DossierRhAdministratifWebServiceServiceLocator dossierRhAdministratifWebServiceServiceLocator;
	private String wsdl_url_dossier_rh_administratif;
	private String wsdl_url_dossier_rh_personnel;
	private String wsdl_url_referentiel_geographique;
	private DossierRhPersonnelWebService dossierRhPersonnelWS;
	private DossierRhPersonnelSoapBindingStub dossierRhPersonnelWSStub;
	private ConsultationEtatCivilResponseWSDto_V2 consulterEtatCivil;
	private ConsultationSituationFamilialeReponseWSDto_V2 consulterSituationFamiliale;
	private final Logger logger = new LoggerImpl(getClass());
	private ConsultationSituationFamilialeDto_V2 consulterSituationFamilleDto;
	private ConsultationCoordonneesPersonnellesDto[] consulterCoordonneesPersonnellesDto;
	private ConsultationDiplomesReponseWSDto consulterDiplomes;
	private DossierRhAdministratifWebService dossierRhAdministratifWebService;
	private DossierRhAdministratifSoapBindingStub dossierRhAdministratifWebServiceStub;
	private ArrayList<AvenantContratDto> lstAvenantsContratDto;
	private DonneesPositionsReponseWSDto_V3 consulterDonneesPosition;

	
	
	
	public boolean getAdresseModifiable() {
		return adresseModifiable;
	}

	public void setAdresseModifiable(boolean adresseModifiable) {
		this.adresseModifiable = adresseModifiable;
	}

	public boolean getEmailModifiable() {
		return emailModifiable;
	}

	public void setEmailModifiable(boolean emailModifiable) {
		this.emailModifiable = emailModifiable;
	}

	public boolean getTelephonePortableModifiable() {
		return telephonePortableModifiable;
	}

	public void setTelephonePortableModifiable(
			boolean telephonePortableModifiable) {
		this.telephonePortableModifiable = telephonePortableModifiable;
	}

	/**
	 * @return the wsdl_anonymous
	 */
	public boolean getWsdl_anonymous() {
		return wsdl_anonymous;
	}

	/**
	 * @param wsdl_anonymous
	 *            the wsdl_anonymous to set
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
	 * @param wsdl_usr_name
	 *            the wsdl_usr_name to set
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
	 * @param wsdl_usr_password
	 *            the wsdl_usr_password to set
	 */
	public void setWsdl_usr_password(String wsdl_usr_password) {
		this.wsdl_usr_password = wsdl_usr_password;
	}

	public DossierRHAdministratif getDossierRHAdministratif() {
		return dossierRHAdministratif;
	}

	public void setDossierRHAdministratif(
			DossierRHAdministratif dossierRHAdministratif) {
		this.dossierRHAdministratif = dossierRHAdministratif;
	}
	
	
	

	public String getWsdl_url_referentiel_geographique() {
		return wsdl_url_referentiel_geographique;
	}

	public void setWsdl_url_referentiel_geographique(
			String wsdlUrlReferentielGeographique) {
		wsdl_url_referentiel_geographique = wsdlUrlReferentielGeographique;
	}

	/**
	 * @return the supannEmpId
	 */
	public Integer getSupannEmpId() {
		return supannEmpId;
	}

	/**
	 * @param supannEmpId
	 *            the supannEmpId to set
	 */
	public void setSupannEmpId(Integer supannEmpId) {
		this.supannEmpId = supannEmpId;
	}

	public ConsultationEtatCivilResponseWSDto_V2 getConsultationEtatCivil() {
		if (consulterEtatCivil == null) {

			dossierRhPersonnelWebServiceServiceLocator = new DossierRhPersonnelWebServiceServiceLocator();

			dossierRhPersonnelWebServiceServiceLocator
					.setdossierRhPersonnelEndpointAddress(wsdl_url_dossier_rh_personnel);

			try {
				if (wsdl_anonymous) {
					logger.info("SUPANNEMPID : " + supannEmpId);
					dossierRhPersonnelWS = dossierRhPersonnelWebServiceServiceLocator
							.getdossierRhPersonnel();
					consulterEtatCivil = dossierRhPersonnelWS
							.consulterEtatCivil_V2(supannEmpId);
				} else {
					logger.info("SUPANNEMPID : " + supannEmpId);
					dossierRhPersonnelWSStub = (DossierRhPersonnelSoapBindingStub) dossierRhPersonnelWebServiceServiceLocator
							.getdossierRhPersonnel();
					dossierRhPersonnelWSStub.setUsername(wsdl_usr_name);
					dossierRhPersonnelWSStub.setPassword(wsdl_usr_password);
					consulterEtatCivil = dossierRhPersonnelWSStub
							.consulterEtatCivil_V2(supannEmpId);

				}

			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				logger.info("erreur Service" + e.getMessage());
			} catch (HarpegeTechniqueException e) {
				// TODO Auto-generated catch block
				logger.info("erreur technique" + e.getMessage());
			} catch (HarpegeFonctionnelleException e) {
				// TODO Auto-generated catch block
				logger.info("erreur fonctionnelle" + e.getMessage());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				logger.info("erreur remoteexception" + e.getMessage());
			}
			/*logger.info("Agent :: nom "
					+ consulterEtatCivil.getIndividuReponseEtatCivil_V2()
							.getNomPatronymique());*/
		}
		return consulterEtatCivil;
	}

	/**
	 * @return the consulterEtatCivil
	 */
	public ConsultationEtatCivilResponseWSDto_V2 getConsulterEtatCivil() {
		return consulterEtatCivil;
	}

	public EnfantDto_V2[] getListeEnfants() {
		if (consulterSituationFamilleDto != null) {
			EnfantDto_V2[] lstEnfants = consulterSituationFamilleDto
					.getListeEnfants();

			if (lstEnfants != null) {
				Comparator<EnfantDto_V2> eltComparaison = new EnfantSort();
				Arrays.sort(lstEnfants, eltComparaison);

				return lstEnfants;
			}

			return null;
		}

		return null;
	}

	/**
	 * @return the consulterSituationFamiliale
	 */
	public ConsultationSituationFamilialeDto_V2 getConsulterSituationFamiliale() {
		try {
			ConsultationSituationFamilialeReponseWSDto_V2 consulterSituationFamilialeWSDto_V2;
			if (wsdl_anonymous) {
				consulterSituationFamilialeWSDto_V2 = dossierRhPersonnelWS
						.consulterSituationFamiliale_V2(supannEmpId);
			} else {
				consulterSituationFamilialeWSDto_V2 = dossierRhPersonnelWSStub
						.consulterSituationFamiliale_V2(supannEmpId);
			}
			consulterSituationFamilleDto = consulterSituationFamilialeWSDto_V2
					.getConsultationSituationFamilleDto();
		} catch (HarpegeTechniqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HarpegeFonctionnelleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return consulterSituationFamilleDto;
	}

	public ConsultationCoordonneesBancairesDto_V2[] getConsultationCoordonneesBancaires() {
		ConsultationCoordonneesBancairesDto_V2[] consultationCoordonneesBancairesDto = null;
		try {
			ConsultationCoordonneesBancairesReponseWSDto_V2 consulterCoordonneesBancaires;
			if (wsdl_anonymous) {
				consulterCoordonneesBancaires = dossierRhPersonnelWS
						.consulterCoordonneesBancaires_V2(supannEmpId, "P");
			} else {
				consulterCoordonneesBancaires = dossierRhPersonnelWSStub
						.consulterCoordonneesBancaires_V2(supannEmpId, "P");
			}
			consultationCoordonneesBancairesDto = consulterCoordonneesBancaires
					.getListeCoordonneesBancairesDto();
		} catch (HarpegeTechniqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HarpegeFonctionnelleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return consultationCoordonneesBancairesDto;
	}

	/**
	 * @param consulterSituationFamiliale
	 *            the consulterSituationFamiliale to set
	 */
	public void setConsulterSituationFamiliale(
			ConsultationSituationFamilialeReponseWSDto_V2 consulterSituationFamiliale) {
		this.consulterSituationFamiliale = consulterSituationFamiliale;
	}

	/**
	 * @param consulterEtatCivil
	 *            the consulterEtatCivil to set
	 */
	public void setConsulterEtatCivil(
			ConsultationEtatCivilResponseWSDto_V2 consulterEtatCivil) {
		this.consulterEtatCivil = consulterEtatCivil;
	}

	/**
	 * @return the wsdl_url_dossier_rh_administratif
	 */
	public String getWsdl_url_dossier_rh_administratif() {
		return wsdl_url_dossier_rh_administratif;
	}

	/**
	 * @param wsdl_url_dossier_rh_administratif
	 *            the wsdl_url_dossier_rh_administratif to set
	 */
	public void setWsdl_url_dossier_rh_administratif(
			String wsdl_url_dossier_rh_administratif) {
		this.wsdl_url_dossier_rh_administratif = wsdl_url_dossier_rh_administratif;
	}

	/**
	 * @return the wsdl_url_dossier_rh_personnel
	 */
	public String getWsdl_url_dossier_rh_personnel() {
		return wsdl_url_dossier_rh_personnel;
	}

	/**
	 * @param wsdl_url_dossier_rh_personnel
	 *            the wsdl_url_dossier_rh_personnel to set
	 */
	public void setWsdl_url_dossier_rh_personnel(
			String wsdl_url_dossier_rh_personnel) {
		this.wsdl_url_dossier_rh_personnel = wsdl_url_dossier_rh_personnel;
	}

	/**
	 * @return the dossierRhPersonnel
	 */
	public DossierRhPersonnelWebService getDossierRhPersonnelWS() {
		return dossierRhPersonnelWS;
	}

	/**
	 * @param dossierRhPersonnel
	 *            the dossierRhPersonnel to set
	 */
	public void setDossierRhPersonnelWS(
			DossierRhPersonnelWebService dossierRhPersonnel) {
		this.dossierRhPersonnelWS = dossierRhPersonnel;
	}

	public ConsultationCoordonneesPersonnellesDto[] getConsulterCoordonneesPersonnellesDto() {
		try {
			ConsultationCoordonneesPersonnellesReponseWSDto consulterCoordonneesPersonnelles;
			if (wsdl_anonymous) {
				consulterCoordonneesPersonnelles = dossierRhPersonnelWS
						.consulterCoordonneesPersonnelles(supannEmpId, "O");
			} else {
				consulterCoordonneesPersonnelles = dossierRhPersonnelWSStub
						.consulterCoordonneesPersonnelles(supannEmpId, "O");
			}
			consulterCoordonneesPersonnellesDto = consulterCoordonneesPersonnelles
					.getListeCoordonneesPersonnelleDto();

			/*
			 * identifiantAdresse=consulterCoordonneesPersonnellesDto[0].getAdresseDto
			 * ().getIdentifiantAdresse(); numeroVoie =
			 * consulterCoordonneesPersonnellesDto
			 * [0].getAdresseDto().getNumeroVoie(); bisTer =
			 * consulterCoordonneesPersonnellesDto
			 * [0].getAdresseDto().getBisTer();
			 * codeVoie=consulterCoordonneesPersonnellesDto
			 * [0].getAdresseDto().getVoie().getCodeVoie();
			 * libelleVoie=consulterCoordonneesPersonnellesDto
			 * [0].getAdresseDto().getVoie().getLibelleVoie();
			 * nomVoie=consulterCoordonneesPersonnellesDto
			 * [0].getAdresseDto().getNomVoie();
			 * habitantChez=consulterCoordonneesPersonnellesDto
			 * [0].getAdresseDto().getHabitantChez();
			 * localite=consulterCoordonneesPersonnellesDto
			 * [0].getAdresseDto().getLocalite();
			 * codePostal=consulterCoordonneesPersonnellesDto
			 * [0].getAdresseDto().getCodePostal();
			 * ville=consulterCoordonneesPersonnellesDto
			 * [0].getAdresseDto().getVille();
			 * codePays=consulterCoordonneesPersonnellesDto
			 * [0].getAdresseDto().getPays().getCodePays();
			 * libellePays=consulterCoordonneesPersonnellesDto
			 * [0].getAdresseDto().getPays().getLibellePays();
			 * codePostalEtranger
			 * =consulterCoordonneesPersonnellesDto[0].getAdresseDto
			 * ().getCodePostalEtranger();
			 * telephoneDomicile=consulterCoordonneesPersonnellesDto
			 * [0].getAdresseDto().getTelephoneDomicile();
			 * numeroFax=consulterCoordonneesPersonnellesDto
			 * [0].getAdresseDto().getNumeroFax();
			 * temoinAdressePrincipale=consulterCoordonneesPersonnellesDto
			 * [0].getAdresseDto().getTemoinAdressePrincipale();
			 * telephonePortable
			 * =consulterCoordonneesPersonnellesDto[0].getTelephonePortable();
			 * 
			 * logger.info("identifiantAdresse : "+identifiantAdresse);
			 * logger.info("numeroVoie :"+numeroVoie);
			 * logger.info("bisTer :"+bisTer);
			 * logger.info("codeVoie :"+codeVoie);
			 * logger.info("libelleVoie :"+libelleVoie);
			 * logger.info("nomVoie :"+nomVoie);
			 * logger.info("habitantChez :"+habitantChez);
			 * logger.info("localite :"+localite);
			 * logger.info("codePostal :"+codePostal);
			 * logger.info("ville :"+ville); logger.info("codePays :"+codePays);
			 * logger.info("libellePays :"+libellePays);
			 * logger.info("codePostalEtranger :"+codePostalEtranger);
			 * logger.info("telephoneDomicile :"+telephoneDomicile);
			 * logger.info("numeroFax :"+numeroFax);
			 * logger.info("temoinAdressePrincipale :"+temoinAdressePrincipale);
			 * logger.info("telephonePortable :"+telephonePortable);
			 */

			return consulterCoordonneesPersonnellesDto;
		} catch (HarpegeTechniqueException ex) {
			ex.printStackTrace();
		} catch (HarpegeFonctionnelleException ex) {
			ex.printStackTrace();
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public String getConsulterDonneesActuelles() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dossierRhAdministratifWebServiceServiceLocator = new DossierRhAdministratifWebServiceServiceLocator();
			dossierRhAdministratifWebServiceServiceLocator
					.setdossierRhAdministratifEndpointAddress(wsdl_url_dossier_rh_administratif);

			Calendar dateActuel = new GregorianCalendar();
			ElementsCarriereReponseWSDto_V2 elementsCarriereReponseWSDto_V2 = null;
			if (wsdl_anonymous) {
				dossierRhAdministratifWebService = dossierRhAdministratifWebServiceServiceLocator
						.getdossierRhAdministratif();
				elementsCarriereReponseWSDto_V2 = dossierRhAdministratifWebService
						.consultationElementsCarriere_V2(supannEmpId,
								dateActuel);
			} else {
				dossierRhAdministratifWebServiceStub = (DossierRhAdministratifSoapBindingStub) dossierRhAdministratifWebServiceServiceLocator
						.getdossierRhAdministratif();
				dossierRhAdministratifWebServiceStub.setUsername(wsdl_usr_name);
				dossierRhAdministratifWebServiceStub
						.setPassword(wsdl_usr_password);
				elementsCarriereReponseWSDto_V2 = dossierRhAdministratifWebServiceStub
						.consultationElementsCarriere_V2(supannEmpId,
								dateActuel);
			}

			ElementCarriereFinalDto_V2 elementsCarriereFinalDto_V2 = elementsCarriereReponseWSDto_V2
					.getElementsCarriereFinalDto_V2();
			if (elementsCarriereFinalDto_V2 != null) {
				CarriereDto_V2[] carriereDto_V2 = elementsCarriereFinalDto_V2
						.getElementsCarriereDto();
				
				CarriereDto_V2  elementCarriereFinalDto_V2 = carriereDto_V2[0]; 
				ElementCarriereDto[] lstElementCarriereDto = elementCarriereFinalDto_V2.getElementCarriereDto();
				Comparator<ElementCarriereDto> eltComparaison = new ElementCarriereSort();
				Arrays.sort(lstElementCarriereDto, eltComparaison);
				
				//logger.debug("indice : " + lstElementCarriereDto[lstElementCarriereDto.length-1].getIndiceDto().getIndiceNouveauMajore());
				
				//return (carriereDto_V2[carriereDto_V2.length - 1]
				//		.getElementCarriereDto())[carriereDto_V2[carriereDto_V2.length - 1]
				//		.getElementCarriereDto().length - 1].getIndiceDto()
				//		.getIndiceNouveauMajore();
				return lstElementCarriereDto[lstElementCarriereDto.length-1].getIndiceDto().getIndiceNouveauMajore();
			}

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HarpegeTechniqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HarpegeFonctionnelleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public DonneesAvancementDto[] getConsulterDonneesAvancement() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dossierRhAdministratifWebServiceServiceLocator = new DossierRhAdministratifWebServiceServiceLocator();
			dossierRhAdministratifWebServiceServiceLocator
					.setdossierRhAdministratifEndpointAddress(wsdl_url_dossier_rh_administratif);

			dossierRhAdministratifWebService = dossierRhAdministratifWebServiceServiceLocator
					.getdossierRhAdministratif();
			DonneesAvancementReponseWSDto donneesAvancementReponseWSDto;

			if (wsdl_anonymous) {
				dossierRhAdministratifWebService = dossierRhAdministratifWebServiceServiceLocator
						.getdossierRhAdministratif();
				donneesAvancementReponseWSDto = dossierRhAdministratifWebService
						.consulterDonneesAvancement(supannEmpId);
			} else {
				dossierRhAdministratifWebServiceStub = (DossierRhAdministratifSoapBindingStub) dossierRhAdministratifWebServiceServiceLocator
						.getdossierRhAdministratif();
				dossierRhAdministratifWebServiceStub.setUsername(wsdl_usr_name);
				dossierRhAdministratifWebServiceStub
						.setPassword(wsdl_usr_password);
				donneesAvancementReponseWSDto = dossierRhAdministratifWebServiceStub
						.consulterDonneesAvancement(supannEmpId);
			}

			for (DonneesAvancementDto da : donneesAvancementReponseWSDto
					.getDonneesAvancementDto()) {
				logger.debug("Bonification échelon : "
						+ da.getBonificationEchelon());
				logger.debug("Echelon : "
						+ da.getEchelonFuturDto().getCodeEchelonFutur());
				logger.debug("Libellé échelon"
						+ da.getEchelonFuturDto().getLibelleEchelonFutur());
				logger.debug("INM : " + da.getIndiceMajoreFutur());

				logger.debug("Indice brut : " + da.getIndiceBrutFutur());
				if (da.getDatePrevisionnelle() != null) {
					logger.debug("Date prévisionnelle : "
							+ sdf.format(da.getDatePrevisionnelle().getTime()));
				}
				logger.debug(da.getBonificationEchelon());

			}

			return donneesAvancementReponseWSDto.getDonneesAvancementDto();

		} catch (HarpegeTechniqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HarpegeFonctionnelleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * @return the consulterDiplomes
	 */
	public ConsultationDiplomesReponseWSDto getConsulterDiplomes() {
		consulterDiplomes = null;
		try {

			if (wsdl_anonymous) {

				consulterDiplomes = dossierRhPersonnelWS
						.consulterDiplomes(supannEmpId);
			} else {

				consulterDiplomes = dossierRhPersonnelWSStub
						.consulterDiplomes(supannEmpId);
			}

			logger.debug("consulterDiplomes " + consulterDiplomes.toString());
			logger.debug("consulterDiplomes " + consulterDiplomes.getTaille());
			if (consulterDiplomes.getTaille() != 0) {
				Comparator<ConsultationDiplomesDto> eltComparaison = new DiplomeSort();
				Arrays.sort(consulterDiplomes.getConsultationDiplomesDto(),
						eltComparaison);
			}

		} catch (HarpegeTechniqueException ex) {
			ex.printStackTrace();
		} catch (HarpegeFonctionnelleException ex) {
			ex.printStackTrace();
		} catch (RemoteException ex) {
			ex.printStackTrace();
		}
		return consulterDiplomes;
	}

	/**
	 * @param consulterDiplomes
	 *            the consulterDiplomes to set
	 */
	public void setConsulterDiplomes(
			ConsultationDiplomesReponseWSDto consulterDiplomes) {
		this.consulterDiplomes = consulterDiplomes;
	}

	public CarriereDto_V2[] getConsulterCarriere() {
		ElementsCarriereReponseWSDto_V2 elementsCarriereReponseWSDto_V2;
		CarriereDto_V2[] lstCarriereDto_V2 = null;
		try {
			dossierRhAdministratifWebServiceServiceLocator = new DossierRhAdministratifWebServiceServiceLocator();
			dossierRhAdministratifWebServiceServiceLocator
					.setdossierRhAdministratifEndpointAddress(wsdl_url_dossier_rh_administratif);

			if (wsdl_anonymous) {
				dossierRhAdministratifWebService = dossierRhAdministratifWebServiceServiceLocator
						.getdossierRhAdministratif();

				elementsCarriereReponseWSDto_V2 = dossierRhAdministratifWebService
						.consultationElementsCarriere_V2(supannEmpId, null);
			} else {
				dossierRhAdministratifWebServiceStub = (DossierRhAdministratifSoapBindingStub) dossierRhAdministratifWebServiceServiceLocator
						.getdossierRhAdministratif();
				dossierRhAdministratifWebServiceStub.setUsername(wsdl_usr_name);
				dossierRhAdministratifWebServiceStub
						.setPassword(wsdl_usr_password);
				elementsCarriereReponseWSDto_V2 = dossierRhAdministratifWebServiceStub
						.consultationElementsCarriere_V2(supannEmpId, null);
			}

			if (elementsCarriereReponseWSDto_V2
					.getElementsCarriereFinalDto_V2() != null) {
				lstCarriereDto_V2 = elementsCarriereReponseWSDto_V2
						.getElementsCarriereFinalDto_V2()
						.getElementsCarriereDto();
				logger.debug(Integer.toString(lstCarriereDto_V2.length));
			} else {
				logger.debug(supannEmpId + " : aucun élément de carrière");
			}
			return lstCarriereDto_V2;
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HarpegeTechniqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HarpegeFonctionnelleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public InformationsContratsDto[] getConsulterContrats() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		InformationsContratsReponseWSDto informationsContratsReponseWSDto;
		InformationsContratsDto[] lstContrats = null;
		try {
			dossierRhAdministratifWebServiceServiceLocator = new DossierRhAdministratifWebServiceServiceLocator();
			dossierRhAdministratifWebServiceServiceLocator
					.setdossierRhAdministratifEndpointAddress(wsdl_url_dossier_rh_administratif);

			try {

				if (wsdl_anonymous) {
					dossierRhAdministratifWebService = dossierRhAdministratifWebServiceServiceLocator
							.getdossierRhAdministratif();
					informationsContratsReponseWSDto = dossierRhAdministratifWebService
							.consulterInformationsContrats(supannEmpId, null);

				} else {
					dossierRhAdministratifWebServiceStub = (DossierRhAdministratifSoapBindingStub) dossierRhAdministratifWebServiceServiceLocator
							.getdossierRhAdministratif();
					dossierRhAdministratifWebServiceStub
							.setUsername(wsdl_usr_name);
					dossierRhAdministratifWebServiceStub
							.setPassword(wsdl_usr_password);
					informationsContratsReponseWSDto = dossierRhAdministratifWebServiceStub
							.consulterInformationsContrats(supannEmpId, null);
				}

				lstContrats = informationsContratsReponseWSDto
						.getInformationsContratsDto();

				if (lstContrats != null) {
					Comparator<InformationsContratsDto> eltComparaison = new ContratSort();
					Arrays.sort(lstContrats, eltComparaison);
				}

				return lstContrats;
			} catch (HarpegeTechniqueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HarpegeFonctionnelleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lstContrats;
	}

	public void getAvenantsContrat() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Comparator<AvenantContratDto> eltComparaison = new AvenantContratSort();

		InformationsContratsReponseWSDto informationsContratsReponseWSDto;

		
		if (lstAvenantsContratDto == null) {
			lstAvenantsContratDto = new ArrayList<AvenantContratDto>();
		}

		try {
			dossierRhAdministratifWebServiceServiceLocator = new DossierRhAdministratifWebServiceServiceLocator();
			dossierRhAdministratifWebServiceServiceLocator
					.setdossierRhAdministratifEndpointAddress(wsdl_url_dossier_rh_administratif);
			dossierRhAdministratifWebService = dossierRhAdministratifWebServiceServiceLocator
					.getdossierRhAdministratif();
			try {

				if (wsdl_anonymous) {
					dossierRhAdministratifWebService = dossierRhAdministratifWebServiceServiceLocator
							.getdossierRhAdministratif();
					informationsContratsReponseWSDto = dossierRhAdministratifWebService
							.consulterInformationsContrats(supannEmpId, null);

				} else {
					dossierRhAdministratifWebServiceStub = (DossierRhAdministratifSoapBindingStub) dossierRhAdministratifWebServiceServiceLocator
							.getdossierRhAdministratif();
					dossierRhAdministratifWebServiceStub
							.setUsername(wsdl_usr_name);
					dossierRhAdministratifWebServiceStub
							.setPassword(wsdl_usr_password);
					informationsContratsReponseWSDto = dossierRhAdministratifWebServiceStub
							.consulterInformationsContrats(supannEmpId, null);
				}

				for (int i = 0; i < informationsContratsReponseWSDto
						.getInformationsContratsDto().length; i++) {
					AvenantContratDto[] avenantContratDto = informationsContratsReponseWSDto
							.getInformationsContratsDto()[i]
							.getAvenantContratDto();
					for (int j = 0; j < avenantContratDto.length; j++) {
						// lstAvenantsContratDto.add(avenantContratDto[j]);
						logger.debug(sdf.format(avenantContratDto[j]
								.getDateDebutContrat().getTime()));
					}
				}
				/*
				 * Collections.sort(lstAvenantsContratDto, eltComparaison);
				 * 
				 * for (int i = 0; i < lstAvenantsContratDto.size(); i++) {
				 * logger .info(lstAvenantsContratDto.get(i)
				 * .getDateDebutContrat() + " - " + lstAvenantsContratDto.get(i)
				 * .getDateFinContrat() + " " + lstAvenantsContratDto.get(i)
				 * .getNumeroAvenant()); }
				 */

			} catch (HarpegeTechniqueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HarpegeFonctionnelleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return the visualisationCompte
	 */
	public boolean getVisualisationCompte() {
		return visualisationCompte;
	}

	/**
	 * @param visualisationCompte
	 *            the visualisationCompte to set
	 */
	public void setVisualisationCompte(boolean visualisationCompte) {
		this.visualisationCompte = visualisationCompte;
	}



	public InformationsOccupationAffectationDto[] getOccupationAffectation(
			String numeroContrat, Calendar date) {
		try {

			InformationsOccupationAffectationReponseWSDto informationsOccupationAffectationReponseWSDto;

			if (wsdl_anonymous) {
				informationsOccupationAffectationReponseWSDto = dossierRhAdministratifWebService
						.consulterInformationsOccupationAffectation(
								supannEmpId, numeroContrat, date);

			} else {
				informationsOccupationAffectationReponseWSDto = dossierRhAdministratifWebServiceStub
						.consulterInformationsOccupationAffectation(
								supannEmpId, numeroContrat, date);
			}
			InformationOccupationAffectationGlobalDto informationOccupationAffectationGlobalDto = informationsOccupationAffectationReponseWSDto
					.getInformationsOccupationAffectationGlobalDto();
			if (informationOccupationAffectationGlobalDto != null) {
				// informationOccupationAffectationGlobalDto.getInformationsOccupationAffectationDto()[0].getAffectationDto()[0].getStructureAffectationDto().getQuotite()
				return informationOccupationAffectationGlobalDto
						.getInformationsOccupationAffectationDto();
			}
		} catch (HarpegeTechniqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HarpegeFonctionnelleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * 
	 */
	public Integer getIdentifiantAdresse() {
		return identifiantAdresse;
	}

	public void setIdentifiantAdresse(Integer identifiantAdresse) {
		this.identifiantAdresse = identifiantAdresse;
	}

	public String getNumeroVoie() {
		return numeroVoie;
	}

	public void setNumeroVoie(String numeroVoie) {
		this.numeroVoie = numeroVoie;
	}

	public String getBisTer() {
		return bisTer;
	}

	public void setBisTer(String bisTer) {
		this.bisTer = bisTer;
	}

	public String getCodeVoie() {
		return codeVoie;
	}

	public void setCodeVoie(String codeVoie) {
		this.codeVoie = codeVoie;
	}

	public String getLibelleVoie() {
		return libelleVoie;
	}

	public void setLibelleVoie(String libelleVoie) {
		this.libelleVoie = libelleVoie;
	}

	public String getNomVoie() {
		return nomVoie;
	}

	public void setNomVoie(String nomVoie) {
		this.nomVoie = nomVoie;
	}

	public String getHabitantChez() {
		return habitantChez;
	}

	public void setHabitantChez(String habitantChez) {
		this.habitantChez = habitantChez;
	}

	public String getLocalite() {
		return localite;
	}

	public void setLocalite(String localite) {
		this.localite = localite;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getCodePays() {
		return codePays;
	}

	public void setCodePays(String codePays) {
		this.codePays = codePays;
	}

	public String getLibellePays() {
		return libellePays;
	}

	public void setLibellePays(String libellePays) {
		this.libellePays = libellePays;
	}

	public String getCodePostalEtranger() {
		return codePostalEtranger;
	}

	public void setCodePostalEtranger(String codePostalEtranger) {
		this.codePostalEtranger = codePostalEtranger;
	}

	public String getTelephoneDomicile() {
		return telephoneDomicile;
	}

	public void setTelephoneDomicile(String telephoneDomicile) {
		this.telephoneDomicile = telephoneDomicile;
	}

	public String getNumeroFax() {
		return numeroFax;
	}

	public void setNumeroFax(String numeroFax) {
		this.numeroFax = numeroFax;
	}

	public String getTemoinAdressePrincipale() {
		return temoinAdressePrincipale;
	}

	public void setTemoinAdressePrincipale(String temoinAdressePrincipale) {
		this.temoinAdressePrincipale = temoinAdressePrincipale;
	}

	public String getTelephonePortable() {
		return telephonePortable;
	}

	public void setTelephonePortable(String telephonePortable) {
		this.telephonePortable = telephonePortable;
	}

	/**
	 * Recupere les donnes des differentes positions de l'agent avec une date de
	 * debut, de fin et un motif Activite, conge parental, detachement, etc...
	 * 
	 * @return the consulterDonneesPosition
	 */
	public DonneesPositionsDto_V3[] getConsulterDonneesPosition() {

		try {
			dossierRhAdministratifWebServiceServiceLocator = new DossierRhAdministratifWebServiceServiceLocator();
			dossierRhAdministratifWebServiceServiceLocator
					.setdossierRhAdministratifEndpointAddress(wsdl_url_dossier_rh_administratif);

			try {

				if (wsdl_anonymous) {
					dossierRhAdministratifWebService = dossierRhAdministratifWebServiceServiceLocator
							.getdossierRhAdministratif();
					consulterDonneesPosition = dossierRhAdministratifWebService
							.consulterDonneesPositions_V3(supannEmpId, null);
				} else {
					dossierRhAdministratifWebServiceStub = (DossierRhAdministratifSoapBindingStub) dossierRhAdministratifWebServiceServiceLocator
							.getdossierRhAdministratif();
					dossierRhAdministratifWebServiceStub
							.setUsername(wsdl_usr_name);
					dossierRhAdministratifWebServiceStub
							.setPassword(wsdl_usr_password);
					consulterDonneesPosition = dossierRhAdministratifWebServiceStub
							.consulterDonneesPositions_V3(supannEmpId, null);
					//logger.info(consulterDonneesPosition
					//		.getDonneesPositionsDto_V3()[0].getPositionDto()
					//		.getLibellePosition());
				}

				DonneesPositionsDto_V3[] donneesPositionsDto_V3 = consulterDonneesPosition
						.getDonneesPositionsDto_V3();

				return donneesPositionsDto_V3;
			} catch (HarpegeTechniqueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HarpegeFonctionnelleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	/**
	 * @param consulterDonneesPosition
	 *            the consulterDonneesPosition to set
	 */
	public void setConsulterDonneesPosition(
			DonneesPositionsReponseWSDto_V3 consulterDonneesPosition) {
		this.consulterDonneesPosition = consulterDonneesPosition;
	}


	public void modifierCoordonneesPersonnelles(String telephonePortable,String email) {		
		if (telephonePortable != null || email != null) {
			ModificationCoordonneesPersonnellesReponseWSDto modificationCoordonneesPersonnellesReponse = new ModificationCoordonneesPersonnellesReponseWSDto();
			DossierRhPersonnelWebServiceServiceLocator dossierRHPersonnelWSServiceLocator = new DossierRhPersonnelWebServiceServiceLocator();
			dossierRHPersonnelWSServiceLocator
					.setdossierRhPersonnelEndpointAddress(wsdl_url_dossier_rh_personnel);
			try {
				if (wsdl_anonymous) {

					dossierRhPersonnelWSStub = 
						(DossierRhPersonnelSoapBindingStub) dossierRHPersonnelWSServiceLocator.getdossierRhPersonnel();
					dossierRhPersonnelWSStub.setUsername("");
					dossierRhPersonnelWSStub.setPassword("");
					try {
						modificationCoordonneesPersonnellesReponse = dossierRhPersonnelWS
								.modiferCoordonneesPersonnelles(supannEmpId,
										email, telephonePortable);
					} catch (HarpegeTechniqueException e) {
						// TODO Auto-generated catch block
						logger.info("erreur technique");
						e.printStackTrace();
					} catch (HarpegeFonctionnelleException e) {
						logger.info("erreur fonctionnelle");
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						logger.info("erreur remote");
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {

					dossierRhPersonnelWSStub = (DossierRhPersonnelSoapBindingStub) dossierRhPersonnelWebServiceServiceLocator
							.getdossierRhPersonnel();
					dossierRhPersonnelWSStub.setUsername(wsdl_usr_name);
					dossierRhPersonnelWSStub.setPassword(wsdl_usr_password);
					logger.debug("supanneempid : " + supannEmpId);
					logger.debug("telephone : " + telephonePortable);
					try {
						modificationCoordonneesPersonnellesReponse = dossierRhPersonnelWSStub
								.modiferCoordonneesPersonnelles(supannEmpId,
										email, telephonePortable);
					} catch (HarpegeTechniqueException e) {
						// TODO Auto-generated catch block
						logger.info("erreur technique");
						e.printStackTrace();
					} catch (HarpegeFonctionnelleException e) {
						logger.info("erreur fonctionnelle");
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (RemoteException e) {
						logger.info("erreur remote");
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
	
	public void modifierAdressePersonnelle(AdressePersonnelleDto adressePersonnelleDto){
		if (adressePersonnelleDto!=null){
			DossierRhPersonnelWebServiceServiceLocator dossierRHPersonnelWSServiceLocator = new DossierRhPersonnelWebServiceServiceLocator();
			dossierRHPersonnelWSServiceLocator
					.setdossierRhPersonnelEndpointAddress(wsdl_url_dossier_rh_personnel);
			try {
				dossierRhPersonnelWSStub = 
					(DossierRhPersonnelSoapBindingStub) dossierRHPersonnelWSServiceLocator.getdossierRhPersonnel();
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (!wsdl_anonymous) {
				dossierRhPersonnelWSStub.setUsername(wsdl_usr_name);
				dossierRhPersonnelWSStub.setPassword(wsdl_usr_password);
			}
			ModificationAdressePersonnelleReponseWSDto adressePersonnelleReponse = new ModificationAdressePersonnelleReponseWSDto();
			
				try {
					adressePersonnelleReponse = dossierRhPersonnelWSStub.modifierAdressePersonnelle(adressePersonnelleDto);
				} catch (HarpegeTechniqueException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (HarpegeFonctionnelleException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
		}
		
	}
	
}
