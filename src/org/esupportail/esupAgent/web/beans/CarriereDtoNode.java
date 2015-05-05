package org.esupportail.esupAgent.web.beans;

import gouv.education.harpege.webservice.client.dossierRhAdministratif.CarriereDto_V2;

import org.apache.myfaces.custom.tree2.TreeNodeBase;

public class CarriereDtoNode extends TreeNodeBase {

	private static final String NODE_TYPE = "carriereDto";
	
	private CarriereDto_V2 carriereDto;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4283600481443073346L;

	public CarriereDtoNode(CarriereDto_V2 carriereDto) {
		super(NODE_TYPE, "carri\u00E8re " + carriereDto.getNumeroSeqCarriere() + " : " + carriereDto.getTypePopulationDto().getLibelleCourtTypePopulation(),false);		
		this.carriereDto = carriereDto;
	}

	/**
	 * @return the carriereDto
	 */
	public CarriereDto_V2 getCarriereDto() {
		return carriereDto;
	}

	/**
	 * @param carriereDto the carriereDto to set
	 */
	public void setCarriereDto(CarriereDto_V2 carriereDto) {
		this.carriereDto = carriereDto;
	}
	
	

}
