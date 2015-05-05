package org.esupportail.esupAgent.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;

import javax.faces.component.UIComponent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;


import gouv.education.harpege.webservice.client.dossierRhAdministratif.CarriereDto_V2;
import gouv.education.harpege.webservice.client.dossierRhAdministratif.ElementCarriereDto;
import gouv.education.harpege.webservice.client.dossierRhAdministratif.AvenantContratDto;
import gouv.education.harpege.webservice.client.dossierRhAdministratif.AffectationRechercheDto;
import gouv.education.harpege.webservice.client.dossierRhAdministratif.InformationsOccupationAffectationDto;

import org.apache.myfaces.custom.tree2.HtmlTree;
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

	private InformationsOccupationAffectationDto[] currentInformationsOccupationAffectationDto = null;

	private String selectedNodeId;

	public String getSelectedNodeId() {
		return selectedNodeId;
	}

	public void setSelectedNodeId(String selectedNodeId) {
		this.selectedNodeId = selectedNodeId;
	}

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

		CarriereDto_V2[] carriere = getDisplayUser().getAgent().getConsulterCarriere();
		if (carriere != null) {

			logger
					.debug("Nombre de séquence carrière : "
							+ carriere.length);
			if (carriere.length == 1) {
				currentCarriereDto = carriere[0];
			}

			for (CarriereDto_V2 carriereDto : carriere) {
				logger.debug("TYPE POPULATION "
						+ carriereDto.getTypePopulationDto()
								.getTemoinEnseignant());
				treeNodeBase = new CarriereDtoNode(carriereDto);
				lstElementCarriereDto = carriereDto.getElementCarriereDto();
				Arrays.sort(lstElementCarriereDto, eltComparaison);

				for (ElementCarriereDto elementCarriereDto : lstElementCarriereDto) {
					if (elementCarriereDto.getDateEffetElementsCarriere()
							.before(Calendar.getInstance())) {
						treeNodeBase.getChildren().add(
								new ElementCarriereDtoNode(elementCarriereDto,
										carriereDto));
						logger
								.debug("numéro séquence "
										+ carriereDto.getNumeroSeqCarriere()
												.toString());
						logger.debug(elementCarriereDto
								.getNumeroSequenceElement().toString());
						logger.debug("Date effet "
								+ sdf.format(carriereDto.getDateDebutCarriere()
										.getTime()));
					}

				}
				rootNode.getChildren().add(treeNodeBase);

			}

			this.carriereTree = new TreeModelBase(rootNode);

			for (int i = 0; i < carriere.length; i++) {
			    this.carriereTree.getTreeState().expandPath(this.carriereTree.getPathInformation("0:" + i));
			}
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
		// logger.info(currentElementCarriereDto.getCorpsDto().getCodeCorps());
		// logger.info(currentCarriereDto.getTypePopulationDto().getLibelleLongTypePopulation());
		
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
		/*
		 * if (currentInformationsOccupationAffectationDto!=null){ for (int
		 * i=0;i<currentInformationsOccupationAffectationDto.length;i++){
		 * InformationsOccupationAffectationDto
		 * info=currentInformationsOccupationAffectationDto[i];
		 * AffectationRechercheDto[]
		 * affectationRechercheDto=info.getAffectationRechercheDto(); if
		 * (affectationRechercheDto!=null){ for (int
		 * k=0;k<affectationRechercheDto.length;k++){
		 * System.out.println("affectation : " +
		 * affectationRechercheDto[k].getNumeroSequenceAffectationRecherche() +
		 * " - " +
		 * affectationRechercheDto[k].getStructureAffectationRechercheDto
		 * ().getCodeStructureAffectationRecherche()+"-"
		 * +affectationRechercheDto[k].getStructureAffectationRechercheDto().
		 * getLibelleCourtStructureAffectationRecherche()+"-" +
		 * affectationRechercheDto[k].getStructureAffectationRechercheDto().
		 * getLibelleLongStructureAffectationRecherche()); } } else{
		 * System.out.println("Pas d'affectation recherche"); } } }
		 */
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

	public void processAction(ActionEvent event)
			throws AbortProcessingException {
		UIComponent component = (UIComponent) event.getSource();
		while (!(component != null && component instanceof HtmlTree)) {
			component = component.getParent();
		}
		if (component != null) {
			HtmlTree tree = (HtmlTree) component;
			TreeNodeBase node = (TreeNodeBase) tree.getNode();
			tree.setNodeSelected(event);
		}
	}

}
