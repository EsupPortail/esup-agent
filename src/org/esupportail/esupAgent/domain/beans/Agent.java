package org.esupportail.esupAgent.domain.beans;

import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationDonneesAvancement.DonneesAvancementDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationDonneesAvancement.DonneesAvancementReponseWSDto;
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
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationCoordonnneesBancaires.ConsultationCoordonneesBancairesReponseWSDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationDiplomes.ConsultationDiplomesDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationDiplomes.ConsultationDiplomesReponseWSDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationInformationsEtatCivil.ConsultationEtatCivilResponseWSDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationSituationFamiliale.ConsultationSituationFamilialeDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationSituationFamiliale.ConsultationSituationFamilialeReponseWSDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationSituationFamiliale.EnfantDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationSituationFamiliale.EnfantDto_V2;
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
import org.esupportail.esupAgent.domain.beans.comparators.EnfantSort;

/**
 * @author uhp
 * 
 */
public class Agent {
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
	private DossierRhPersonnelWebService dossierRhPersonnelWS;
	private DossierRhPersonnelSoapBindingStub dossierRhPersonnelWSStub;
	private ConsultationEtatCivilResponseWSDto_V2 consulterEtatCivil;
	private ConsultationSituationFamilialeReponseWSDto_V2 consulterSituationFamiliale;

	/**
	 * A logger.
	 */
	private final Logger logger = new LoggerImpl(getClass());
	private ConsultationSituationFamilialeDto_V2 consulterSituationFamilleDto;
	private ConsultationCoordonneesPersonnellesDto[] consulterCoordonneesPersonnellesDto;
	private ConsultationDiplomesReponseWSDto consulterDiplomes;
	private DossierRhAdministratifWebService dossierRhAdministratifWebService;
	private DossierRhAdministratifSoapBindingStub dossierRhAdministratifWebServiceStub;
	private ArrayList<AvenantContratDto> lstAvenantsContratDto;

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
					dossierRhPersonnelWS = dossierRhPersonnelWebServiceServiceLocator
							.getdossierRhPersonnel();
					consulterEtatCivil = dossierRhPersonnelWS
							.consulterEtatCivil_V2(supannEmpId);
				} else {					
					dossierRhPersonnelWSStub = (DossierRhPersonnelSoapBindingStub) dossierRhPersonnelWebServiceServiceLocator
							.getdossierRhPersonnel();
					dossierRhPersonnelWSStub.setUsername(wsdl_usr_name);
					dossierRhPersonnelWSStub.setPassword(wsdl_usr_password);
					consulterEtatCivil = dossierRhPersonnelWSStub
							.consulterEtatCivil_V2(supannEmpId);
				}

			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				logger.info("erreur" + e.getMessage());
			} catch (HarpegeTechniqueException e) {
				// TODO Auto-generated catch block
				logger.info("erreur" + e.getMessage());
			} catch (HarpegeFonctionnelleException e) {
				// TODO Auto-generated catch block
				logger.info("erreur" + e.getMessage());
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				logger.info("erreur" + e.getMessage());
			}
			logger.info("Agent :: nom "
					+ consulterEtatCivil.getIndividuReponseEtatCivil_V2()
							.getNomPatronymique());
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

	public ConsultationCoordonneesBancairesDto[] getConsultationCoordonneesBancaires() {
		ConsultationCoordonneesBancairesDto[] consultationCoordonneesBancairesDto = null;
		try {
			ConsultationCoordonneesBancairesReponseWSDto consulterCoordonneesBancaires;
			if (wsdl_anonymous) {
				consulterCoordonneesBancaires = dossierRhPersonnelWS
						.consulterCoordonneesBancaires(supannEmpId, "P");
			} else {
				consulterCoordonneesBancaires = dossierRhPersonnelWSStub
						.consulterCoordonneesBancaires(supannEmpId, "P");
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

/*			CarriereDto_V2[] carriereDto_V2 = elementsCarriereReponseWSDto_V2
					.getElementsCarriereFinalDto_V2().getElementsCarriereDto();
			return (carriereDto_V2[0].getElementCarriereDto())[0]
					.getIndiceDto().getIndiceNouveauMajore();*/
			ElementCarriereFinalDto_V2 elementsCarriereFinalDto_V2 = elementsCarriereReponseWSDto_V2.getElementsCarriereFinalDto_V2();
			if (elementsCarriereFinalDto_V2!=null){
				CarriereDto_V2[] carriereDto_V2 = elementsCarriereFinalDto_V2.getElementsCarriereDto();
				return (carriereDto_V2[carriereDto_V2.length-1].getElementCarriereDto())[carriereDto_V2[carriereDto_V2.length-1].getElementCarriereDto().length-1].getIndiceDto().getIndiceNouveauMajore();
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
				logger.info("Bonification échelon : "
						+ da.getBonificationEchelon());
				logger.info("Echelon : "
						+ da.getEchelonFuturDto().getCodeEchelonFutur());
				logger.info("Libellé échelon"
						+ da.getEchelonFuturDto().getLibelleEchelonFutur());
				logger.info("INM : " + da.getIndiceMajoreFutur());

				logger.info("Indice brut : " + da.getIndiceBrutFutur());
				if (da.getDatePrevisionnelle() != null) {
					logger.info("Date prévisionnelle : "
							+ sdf.format(da.getDatePrevisionnelle().getTime()));
				}
				logger.info(da.getBonificationEchelon());

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

			logger.info("consulterDiplomes " + consulterDiplomes.toString());
			logger.info("consulterDiplomes " + consulterDiplomes.getTaille());
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
				logger.info(Integer.toString(lstCarriereDto_V2.length));
			} else {
				logger.info(supannEmpId + " : aucun élément de carrière");
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

		logger.info(wsdl_url_dossier_rh_administratif);
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
						logger.info(sdf.format(avenantContratDto[j]
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

}
