/**
 * ESUP-Portail ESUP Agent - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-agent
 */
package org.esupportail.esupAgent.web.controllers;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;

import javax.faces.component.UIComponent;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;

import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationContrats.AvenantContratDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationContrats.InformationsContratsDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationOccupationAffectation.AffectationDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationOccupationAffectation.InformationsOccupationAffectationDto;

import org.apache.myfaces.custom.tree2.HtmlTree;
import org.apache.myfaces.custom.tree2.TreeModelBase;
import org.apache.myfaces.custom.tree2.TreeNode;
import org.apache.myfaces.custom.tree2.TreeNodeBase;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.esupAgent.domain.beans.User;
import org.esupportail.esupAgent.domain.beans.comparators.AffectationSort;
import org.esupportail.esupAgent.domain.beans.comparators.AvenantContratSort;
import org.esupportail.esupAgent.web.beans.AvenantContratNode;
import org.esupportail.esupAgent.web.beans.InformationsContratsNode;

/**
 * A bean to manage files.
 */
public class ContratController extends AbstractContextAwareController {

	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = -522191275533736924L;

	private TreeModelBase contratTree;

	private AvenantContratDto currentAvenantContratDto;

	private InformationsContratsDto currentContratDto;

	private InformationsOccupationAffectationDto[] currentInformationsOccupationAffectationDto;

	private final Logger logger = new LoggerImpl(getClass());

	/**
	 * @return the currentAvenantContratDto
	 */
	public AvenantContratDto getCurrentAvenantContratDto() {
		return currentAvenantContratDto;
	}

	/**
	 * @param currentAvenantContratDto
	 *            the currentAvenantContratDto to set
	 */
	public void setCurrentAvenantContratDto(
			AvenantContratDto currentAvenantContratDto) {
		this.currentAvenantContratDto = currentAvenantContratDto;
	}

	/**
	 * Bean constructor.
	 */
	public ContratController() {
		super();
		currentAvenantContratDto = null;
		currentContratDto = null;
		currentInformationsOccupationAffectationDto = null;
		contratTree = null;
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
	 * @return A String.
	 */
	public String enter() {
		if (!isPageAuthorized()) {
			addUnauthorizedActionMessage();
			return null;
		}
		currentAvenantContratDto = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		TreeNode rootNode = new TreeNodeBase("root", "", "root", false);
		TreeNodeBase treeNodeBase;
		AvenantContratDto[] lstAvenantContratDto;
		Comparator<AvenantContratDto> eltComparaison = new AvenantContratSort();
		InformationsContratsDto[] contrats = getDisplayUser().getAgent().getConsulterContrats();
		if (contrats != null) {
			for (InformationsContratsDto informationsContratsDto : contrats) {
				treeNodeBase = new InformationsContratsNode(
						informationsContratsDto);
				lstAvenantContratDto = informationsContratsDto
						.getAvenantContratDto();
				Arrays.sort(lstAvenantContratDto, eltComparaison);
				for (AvenantContratDto avenantContratDto : lstAvenantContratDto) {

					treeNodeBase.getChildren().add(
							new AvenantContratNode(avenantContratDto,
									informationsContratsDto));
				}
				rootNode.getChildren().add(treeNodeBase);
			}
			this.contratTree = new TreeModelBase(rootNode);

			for (int i = 0; i < contrats.length; i++) {
			    this.contratTree.getTreeState().expandPath(this.contratTree.getPathInformation("0:" + i));
			}
		} else {
			this.contratTree = null;
		}
		return "navigationContrat";

	}

	/**
	 * @return the contratTree
	 */
	public TreeModelBase getContratTree() {
		return contratTree;
	}

	/**
	 * @param contratTree
	 *            the contratTree to set
	 */
	public void setContratTree(TreeModelBase contratTree) {
		this.contratTree = contratTree;
	}

	public String updateCurrentAvenantContratDto() {
		Comparator<AffectationDto> eltComparaison = new AffectationSort();
		currentInformationsOccupationAffectationDto = getDisplayUser()
				.getAgent().getOccupationAffectation(
						currentContratDto.getNumeroContrat(), null);

		if (currentInformationsOccupationAffectationDto != null) {
			for (InformationsOccupationAffectationDto occ : currentInformationsOccupationAffectationDto) {
				Arrays.sort(occ.getAffectationDto(), eltComparaison);
			}
		}
		return "navigationContrat";
	}

	/**
	 * @return the currentContratDto
	 */
	public InformationsContratsDto getCurrentContratDto() {
		return currentContratDto;
	}

	/**
	 * @param currentContratDto
	 *            the currentContratDto to set
	 */
	public void setCurrentContratDto(InformationsContratsDto currentContratDto) {
		this.currentContratDto = currentContratDto;
	}

	/**
	 * @return the currentInformationsOccupationAffectationDto
	 */
	public InformationsOccupationAffectationDto[] getCurrentInformationsOccupationAffectationDto() {
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

	public void deleteInfo() {
		currentAvenantContratDto = null;
		currentContratDto = null;
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
