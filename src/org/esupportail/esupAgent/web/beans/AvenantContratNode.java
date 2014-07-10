package org.esupportail.esupAgent.web.beans;

import java.text.SimpleDateFormat;

import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationContrats.AvenantContratDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationContrats.InformationsContratsDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationOccupationAffectation.InformationsOccupationAffectationDto;

import org.apache.myfaces.custom.tree2.TreeNodeBase;

public class AvenantContratNode extends TreeNodeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6717649541266855165L;

	/**
	 * 
	 */

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	/**
	 * the type of the node.
	 */
	private static final String NODE_TYPE = "avenantContrat";

	/**
	 * the avenantContratDto
	 */
	private AvenantContratDto avenantContratDto;

	private InformationsContratsDto informationsContratsDto;

	public AvenantContratNode(AvenantContratDto avenantContratDto,
			InformationsContratsDto informationsContratsDto) {
		super();
		super.setType(NODE_TYPE);
		if (avenantContratDto.getDateFinExecutionContrat() != null) {
			super.setDescription("du "
					+ sdf.format(avenantContratDto.getDateDebutContrat()
							.getTime())
					+ " au "
					+ sdf.format(avenantContratDto.getDateFinExecutionContrat()
							.getTime())
					);
		} else if (avenantContratDto.getDateFinContrat() != null) {
			super.setDescription("du "
					+ sdf.format(avenantContratDto.getDateDebutContrat()
							.getTime())
					+ " au "
					+ sdf.format(avenantContratDto.getDateFinContrat()
							.getTime())
					);
		} else {
			super.setDescription("depuis le "
					+ sdf.format(avenantContratDto.getDateDebutContrat()
							.getTime())
					);
		}
		super.setLeaf(false);

		this.avenantContratDto = avenantContratDto;
		this.informationsContratsDto = informationsContratsDto;

	}

	/**
	 * @return the avenanContratDto
	 */
	public AvenantContratDto getAvenantContratDto() {
		return avenantContratDto;
	}

	/**
	 * @param avenanContratDto
	 *            the avenanContratDto to set
	 */
	public void setAvenantContratDto(AvenantContratDto avenantContratDto) {
		this.avenantContratDto = avenantContratDto;
	}

	/**
	 * @return the informationsContratsDto
	 */
	public InformationsContratsDto getInformationsContratsDto() {
		return informationsContratsDto;
	}

	/**
	 * @param informationsContratsDto
	 *            the informationsContratsDto to set
	 */
	public void setInformationsContratsDto(
			InformationsContratsDto informationsContratsDto) {
		this.informationsContratsDto = informationsContratsDto;
	}

}
