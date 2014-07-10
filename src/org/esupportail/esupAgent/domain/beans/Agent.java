package org.esupportail.esupAgent.domain.beans;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;

import javax.xml.rpc.ServiceException;

import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.esupAgent.domain.beans.comparators.AvenantContratSort;
import org.esupportail.esupAgent.domain.beans.comparators.ContratSort;
import org.esupportail.esupAgent.domain.beans.comparators.DiplomeSort;

import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationElementsCarriere.CarriereDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationElementsCarriere.ElementCarriereFinalDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationElementsCarriere.ElementsCarriereReponseWSDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationContrats.AvenantContratDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationContrats.InformationsContratsDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationContrats.InformationsContratsReponseWSDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationOccupationAffectation.InformationOccupationAffectationGlobalDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationOccupationAffectation.InformationsOccupationAffectationDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationOccupationAffectation.InformationsOccupationAffectationReponseWSDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationCoordonneesPersonnelles.ConsultationCoordonneesPersonnellesDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationCoordonneesPersonnelles.ConsultationCoordonneesPersonnellesReponseWSDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationDiplomes.ConsultationDiplomesReponseWSDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationInformationsEtatCivil.ConsultationEtatCivilResponseWSDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationSituationFamiliale.ConsultationSituationFamilialeDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationSituationFamiliale.ConsultationSituationFamilialeReponseWSDto_V2;
import gouv.education.harpege.transverse.exception.HarpegeFonctionnelleException;
import gouv.education.harpege.transverse.exception.HarpegeTechniqueException;
import gouv.education.harpege.webservice.client.dossierRhAdministratif.DossierRhAdministratifWebService;
import gouv.education.harpege.webservice.client.dossierRhAdministratif.DossierRhAdministratifWebServiceServiceLocator;
import gouv.education.harpege.webservice.client.dossierRhPersonnel.DossierRhPersonnelWebService;
import gouv.education.harpege.webservice.client.dossierRhPersonnel.DossierRhPersonnelWebServiceServiceLocator;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationDiplomes.ConsultationDiplomesDto;

/**
 * @author uhp
 * 
 */
public class Agent {
	private Integer supannEmpId;
	private DossierRHAdministratif dossierRHAdministratif;
	private DossierRhPersonnelWebServiceServiceLocator dossierRhPersonnelWebServiceServiceLocator;
	private DossierRhAdministratifWebServiceServiceLocator dossierRhAdministratifWebServiceServiceLocator;
	private String wsdl_url_dossier_rh_administratif;
	private String wsdl_url_dossier_rh_personnel;
	private DossierRhPersonnelWebService dossierRhPersonnelWS;
	private ConsultationEtatCivilResponseWSDto_V2 consulterEtatCivil;
	private ConsultationSituationFamilialeReponseWSDto_V2 consulterSituationFamiliale;

	/**
	 * A logger.
	 */
	private final Logger logger = new LoggerImpl(getClass());
	private ConsultationSituationFamilialeDto_V2 consulterSituationFamilleDto;
	private ConsultationCoordonneesPersonnellesDto[] consulterCoordonneesPersonnellesDto;
	private ConsultationDiplomesReponseWSDto consulterDiplomes;
	private DossierRhAdministratifWebService dossierRhAdministratifWebSerice;
	private ArrayList<AvenantContratDto> lstAvenantsContratDto;

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
				dossierRhPersonnelWS = dossierRhPersonnelWebServiceServiceLocator
						.getdossierRhPersonnel();

				consulterEtatCivil = dossierRhPersonnelWS
						.consulterEtatCivil_V2(supannEmpId);
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
					+ consulterEtatCivil.getIndividuReponseEtatCivil()
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

	/**
	 * @return the consulterSituationFamiliale
	 */
	public ConsultationSituationFamilialeDto_V2 getConsulterSituationFamiliale() {
		try {
			ConsultationSituationFamilialeReponseWSDto_V2 consulterSituationFamilialeWSDto_V2 = dossierRhPersonnelWS
					.consulterSituationFamiliale_V2(supannEmpId);
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
			ConsultationCoordonneesPersonnellesReponseWSDto consulterCoordonneesPersonnelles = dossierRhPersonnelWS
					.consulterCoordonneesPersonnelles(supannEmpId, "O");
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

	/**
	 * @return the consulterDiplomes
	 */
	public ConsultationDiplomesReponseWSDto getConsulterDiplomes() {
		try {

			consulterDiplomes = dossierRhPersonnelWS
					.consulterDiplomes(supannEmpId);
			Comparator<ConsultationDiplomesDto> eltComparaison = new DiplomeSort();
			Arrays.sort(consulterDiplomes.getConsultationDiplomesDto(),
					eltComparaison);

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

			dossierRhAdministratifWebSerice = dossierRhAdministratifWebServiceServiceLocator
					.getdossierRhAdministratif();

			elementsCarriereReponseWSDto_V2 = dossierRhAdministratifWebSerice
					.consultationElementsCarriere_V2(supannEmpId, null);

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
		InformationsContratsDto[] lstContrats=null;
		try {
			dossierRhAdministratifWebServiceServiceLocator = new DossierRhAdministratifWebServiceServiceLocator();
			dossierRhAdministratifWebServiceServiceLocator
					.setdossierRhAdministratifEndpointAddress(wsdl_url_dossier_rh_administratif);
			dossierRhAdministratifWebSerice = dossierRhAdministratifWebServiceServiceLocator
					.getdossierRhAdministratif();
			try {
				informationsContratsReponseWSDto = dossierRhAdministratifWebSerice
						.consulterInformationsContrats(supannEmpId, null);
				
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

		logger.info(wsdl_url_dossier_rh_administratif);
		if (lstAvenantsContratDto == null) {
			lstAvenantsContratDto = new ArrayList<AvenantContratDto>();
		}

		try {
			dossierRhAdministratifWebServiceServiceLocator = new DossierRhAdministratifWebServiceServiceLocator();
			dossierRhAdministratifWebServiceServiceLocator
					.setdossierRhAdministratifEndpointAddress(wsdl_url_dossier_rh_administratif);
			dossierRhAdministratifWebSerice = dossierRhAdministratifWebServiceServiceLocator
					.getdossierRhAdministratif();
			logger.info(dossierRhAdministratifWebSerice.toString());
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Comparator<AvenantContratDto> eltComparaison = new AvenantContratSort();

		InformationsContratsReponseWSDto informationsContratsReponseWSDto;
		try {
			informationsContratsReponseWSDto = dossierRhAdministratifWebSerice
					.consulterInformationsContrats(supannEmpId, null);

			for (int i = 0; i < informationsContratsReponseWSDto
					.getInformationsContratsDto().length; i++) {
				AvenantContratDto[] avenantContratDto = informationsContratsReponseWSDto
						.getInformationsContratsDto()[i].getAvenantContratDto();
				for (int j = 0; j < avenantContratDto.length; j++) {
					// lstAvenantsContratDto.add(avenantContratDto[j]);
					logger.info(sdf.format(avenantContratDto[j]
							.getDateDebutContrat().getTime()));
				}
			}
			/*
			 * Collections.sort(lstAvenantsContratDto, eltComparaison);
			 * 
			 * for (int i = 0; i < lstAvenantsContratDto.size(); i++) { logger
			 * .info(lstAvenantsContratDto.get(i) .getDateDebutContrat() + " - "
			 * + lstAvenantsContratDto.get(i) .getDateFinContrat() + " " +
			 * lstAvenantsContratDto.get(i) .getNumeroAvenant()); }
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

	}

	public InformationsOccupationAffectationDto[] getOccupationAffectation(
			String numeroContrat, Calendar date) {
		try {
			InformationsOccupationAffectationReponseWSDto informationsOccupationAffectationReponseWSDto = dossierRhAdministratifWebSerice
					.consulterInformationsOccupationAffectation(supannEmpId,
							numeroContrat, date);
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
