package org.esupportail.esupAgent.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationElementsCarriere.BapReferensDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationElementsCarriere.BapReferensDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationElementsCarriere.CarriereDto_V2;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationElementsCarriere.ElementCarriereDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationContrats.AvenantContratDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationOccupationAffectation.AffectationRechercheDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationOccupationAffectation.InformationsOccupationAffectationDto;

import org.apache.myfaces.custom.tree2.TreeModelBase;
import org.apache.myfaces.custom.tree2.TreeNode;
import org.apache.myfaces.custom.tree2.TreeNodeBase;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.esupAgent.domain.beans.User;
import org.esupportail.esupAgent.domain.beans.comparators.ElementCarriereSort;
import org.esupportail.esupAgent.web.beans.CarriereDtoNode;
import org.esupportail.esupAgent.web.beans.ElementCarriereDtoNode;

public class CarriereController extends AbstractContextAwareController {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8115242148322528188L;

	private final Logger logger = new LoggerImpl(getClass());

	private TreeModelBase carriereTree;

	private CarriereDto_V2 currentCarriereDto;

	private ElementCarriereDto currentElementCarriereDto;

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	private InformationsOccupationAffectationDto[] currentInformationsOccupationAffectationDto=null;

	public CarriereController() {
		super();
		carriereTree = null;
		currentCarriereDto = null;
		currentElementCarriereDto = null;
		currentInformationsOccupationAffectationDto = null;
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getClass().getSimpleName() + "#" + hashCode();
	}

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
		currentElementCarriereDto = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		TreeNode rootNode = new TreeNodeBase("root", "", "root", false);
		TreeNodeBase treeNodeBase;
		ElementCarriereDto[] lstElementCarriereDto;
		Comparator<ElementCarriereDto> eltComparaison = new ElementCarriereSort();

		if (!isPageAuthorized()) {
			addUnauthorizedActionMessage();
			return null;
		}

		if (getDisplayUser().getAgent().getConsulterCarriere() != null) {

			logger
					.info("Nombre de séquence carrière : "
							+ getDisplayUser().getAgent()
									.getConsulterCarriere().length);
			if (getDisplayUser().getAgent().getConsulterCarriere().length == 1) {
				currentCarriereDto = getDisplayUser().getAgent()
						.getConsulterCarriere()[0];
			}

			for (CarriereDto_V2 carriereDto : getDisplayUser().getAgent()
					.getConsulterCarriere()) {
				treeNodeBase = new CarriereDtoNode(carriereDto);
				lstElementCarriereDto = carriereDto.getElementCarriereDto();
				Arrays.sort(lstElementCarriereDto, eltComparaison);

				for (ElementCarriereDto elementCarriereDto : lstElementCarriereDto) {
					treeNodeBase.getChildren().add(
							new ElementCarriereDtoNode(elementCarriereDto,
									carriereDto));
					logger.info("numéro séquence "
							+ carriereDto.getNumeroSeqCarriere().toString());
					logger.info(elementCarriereDto.getNumeroSequenceElement()
							.toString());
					logger.info("Date effet "
							+ sdf.format(carriereDto.getDateDebutCarriere()
									.getTime()));

				}
				rootNode.getChildren().add(treeNodeBase);

			}

			this.carriereTree = new TreeModelBase(rootNode);
			String[] expandPaths = this.carriereTree.getPathInformation("0:0");
			this.carriereTree.getTreeState().expandPath(expandPaths);
			
		} else {
			this.carriereTree = null;
		}
		
		
		return "navigationCarriere";
	}

	/**
	 * @return the carriereTree
	 */
	public TreeModelBase getCarriereTree() {
		return carriereTree;
	}

	/**
	 * @param carriereTree
	 *            the carriereTree to set
	 */
	public void setCarriereTree(TreeModelBase carriereTree) {
		this.carriereTree = carriereTree;
	}

	/**
	 * @return the currentCarriereDto
	 */
	public CarriereDto_V2 getCurrentCarriereDto() {
		return currentCarriereDto;
	}

	/**
	 * @param currentCarriereDto
	 *            the currentCarriereDto to set
	 */
	public void setCurrentCarriereDto(CarriereDto_V2 currentCarriereDto) {
		this.currentCarriereDto = currentCarriereDto;
	}

	/**
	 * @return the currentElementCarriereDto
	 */
	public ElementCarriereDto getCurrentElementCarriereDto() {
		//logger.info(currentElementCarriereDto.getCorpsDto().getCodeCorps());
		//logger.info(currentCarriereDto.getTypePopulationDto().getLibelleLongTypePopulation());
		return currentElementCarriereDto;
	}

	/**
	 * @param currentElementCarriereDto
	 *            the currentElementCarriereDto to set
	 */
	public void setCurrentElementCarriereDto(
			ElementCarriereDto currentElementCarriereDto) {
		this.currentElementCarriereDto = currentElementCarriereDto;
	}

	/**
	 * @return the currentInformationsOccupationAffectationDto
	 */
	public InformationsOccupationAffectationDto[] getCurrentInformationsOccupationAffectationDto() {
/*		if (currentInformationsOccupationAffectationDto!=null){
			for (int i=0;i<currentInformationsOccupationAffectationDto.length;i++){
				InformationsOccupationAffectationDto info=currentInformationsOccupationAffectationDto[i];
				AffectationRechercheDto[]  affectationRechercheDto=info.getAffectationRechercheDto();
				if (affectationRechercheDto!=null){
					for (int k=0;k<affectationRechercheDto.length;k++){
						System.out.println("affectation : " + affectationRechercheDto[k].getNumeroSequenceAffectationRecherche() + " - " + affectationRechercheDto[k].getStructureAffectationRechercheDto().getCodeStructureAffectationRecherche()+"-" +affectationRechercheDto[k].getStructureAffectationRechercheDto().getLibelleCourtStructureAffectationRecherche()+"-" + affectationRechercheDto[k].getStructureAffectationRechercheDto().getLibelleLongStructureAffectationRecherche());
					}
				} else{
					System.out.println("Pas d'affectation recherche");
				}
			}
		}*/
		return currentInformationsOccupationAffectationDto;
	}

	/**
	 * @param currentInformationsOccupationAffectationDto
	 *            the currentInformationsOccupationAffectationDto to set
	 */
	public void setCurrentInformationsOccupationAffectationDto(
			InformationsOccupationAffectationDto[] currentInformationsOccupationAffectationDto) {		
		this.currentInformationsOccupationAffectationDto = currentInformationsOccupationAffectationDto;
	}

	public User getDisplayUser() {

		if (getSessionController().getUserLoginUnder() != null) {

			return getSessionController().getUserLoginUnder();
		} else {

			return getSessionController().getCurrentUser();

		}

	}

	public String updateCurrentElementCarriereDto() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		/*
		 * for (BapReferensDto_V2 lst:currentCarriereDto.getBapReferensDto()){
		 * logger.info(sdf.format(lst.getDateDebut().getTime())+" : "+lst.
		 * getCodeBAPReferens()); }
		 */
		// logger.info(currentCarriereDto.get.getBapReferensDto()[0].getCodeBAPReferens());
		// logger.info(currentCarriereDto.getBapReferensDto()[0].getLibelleLongBAPReferens());
		// logger.info(currentCarriereDto.getCategorieFonctionPubliqueDto().getCodeCategorieFonctionPublique());
		currentInformationsOccupationAffectationDto = getDisplayUser()
				.getAgent().getOccupationAffectation(
						String.valueOf(currentCarriereDto
								.getNumeroSeqCarriere()),
						currentElementCarriereDto
								.getDateEffetElementsCarriere());

		return "navigationCarriere";
	}

	public void deleteInfo() {
		currentCarriereDto = null;
		currentElementCarriereDto = null;
		currentInformationsOccupationAffectationDto = null;
	}
}
