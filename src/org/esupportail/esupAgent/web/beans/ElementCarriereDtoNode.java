package org.esupportail.esupAgent.web.beans;

import java.text.SimpleDateFormat;

import gouv.education.harpege.webservice.client.dossierRhAdministratif.CarriereDto_V4;
import gouv.education.harpege.webservice.client.dossierRhAdministratif.ElementCarriereDto_V3;

import org.apache.myfaces.custom.tree2.TreeNodeBase;

public class ElementCarriereDtoNode extends TreeNodeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2520377753916193818L;

	private CarriereDto_V4 carriereDto;

	private ElementCarriereDto_V3 elementCarriereDto;

	private static final String NODE_TYPE = "elementCarriereDto";

	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public ElementCarriereDtoNode(ElementCarriereDto_V3 elementCarriereDto,
			CarriereDto_V4 carriereDto_V2) {
		super();
		super.setType(NODE_TYPE);
		//super.setDescription("El\u00E9ment n\u00B0" + elementCarriereDto.getNumeroSequenceElement() + " ("+sdf.format(elementCarriereDto.getDateEffetElementsCarriere().getTime())+")" + " : " + elementCarriereDto.getCorpsDto().getLibelleCorps());
		super.setDescription(elementCarriereDto.getCorpsDto().getLibelleCorps() + " ("+sdf.format(elementCarriereDto.getDateEffetElementsCarriere().getTime())+")");
		super.setLeaf(false);
		this.elementCarriereDto = elementCarriereDto;
		this.carriereDto = carriereDto_V2;
	}

	/**
	 * @return the carriereDto
	 */
	public CarriereDto_V4 getCarriereDto() {
		return carriereDto;
	}

	/**
	 * @param carriereDto
	 *            the carriereDto to set
	 */
	public void setCarriereDto(CarriereDto_V4 carriereDto) {
		this.carriereDto = carriereDto;
	}

	/**
	 * @return the elementCarriereDto
	 */
	public ElementCarriereDto_V3 getElementCarriereDto() {
		return elementCarriereDto;
	}

	/**
	 * @param elementCarriereDto
	 *            the elementCarriereDto to set
	 */
	public void setElementCarriereDto(ElementCarriereDto_V3 elementCarriereDto) {
		this.elementCarriereDto = elementCarriereDto;
	}

}
