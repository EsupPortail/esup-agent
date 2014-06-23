package org.esupportail.esupAgent.domain.beans;

import gouv.education.harpege.webservice.client.dossierRhAdministratif.DonneesAvancementDto;

import java.util.Calendar;
import java.util.Date;

public class Avancement {

	/* derniere date certaine mise dans harpege
	 * Elle peut etre dans le futur si la RH a fait du travail en avance
	 */
	private Date dateDernierChangement;	

	private Integer echelonDernierChangement; 
	
	/*
	 * La date previsionnelle donnee par le WS est incertaine, notamment si bonificationEchelon, car la reduction de temps de passage peut s'appliquer arriver a un certaine echelon mais pas avant.
	 */
	private Integer moisAvantProchainChangementPrevisionnelMin;
	private Integer moisAvantProchainChangementPrevisionnelMax;
	
	/* vrai si dateDernierChangementEchelon est dans le futur */
	private boolean dateDernierChangementEstFuture;
	
	private boolean bonificationEchelon;
	private boolean reliquatAnciennete;
	
	public Avancement(DonneesAvancementDto da) {
		// pas assez d'info
		if (da.getDatePrevisionnelle() == null) return;

		bonificationEchelon = "O".equals(da.getBonificationEchelon());
		reliquatAnciennete = "O".equals(da.getReliquatAnciennete());
		
		try {
			float temps1 = da.getTempsPassageRecalculeDto().getDureeAncienneteJours() * 12 + // !! le WS inverse jours et annees !!
					da.getTempsPassageRecalculeDto().getDureeAncienneteMois() +
					(float) da.getTempsPassageRecalculeDto().getDureeAncienneteAnnee() / 31; // !! le WS inverse jours et annees !!
			float temps2 = da.getTempsPassageMoyenDto().getDureeAncienneteAnnee() * 12 +
					da.getTempsPassageMoyenDto().getDureeAncienneteMois();
			moisAvantProchainChangementPrevisionnelMin = Math.round(Math.min(temps1, temps2));
			moisAvantProchainChangementPrevisionnelMax = Math.round(Math.max(temps1, temps2));
		} catch (NullPointerException e) {}
		
		{
			Calendar d = da.getDatePrevisionnelle();
			d.clone();
			d.add(Calendar.YEAR, -da.getTempsPassageRecalculeDto().getDureeAncienneteJours()); // !! le WS inverse jours et annees !!
			d.add(Calendar.MONTH, -da.getTempsPassageRecalculeDto().getDureeAncienneteMois());
			d.add(Calendar.DAY_OF_MONTH, -da.getTempsPassageRecalculeDto().getDureeAncienneteAnnee()); // !! le WS inverse jours et annees !!
			dateDernierChangement = d.getTime();
			dateDernierChangementEstFuture = !d.before(Calendar.getInstance());		
		}
		try {
			echelonDernierChangement = Integer.parseInt(da.getEchelonFuturDto().getCodeEchelonFutur()) - 1;
		} catch (NumberFormatException e) {			
		}	
	}

	public Date getDateDernierChangement() {
		return dateDernierChangement;
	}

	public void setDateDernierChangement(Date dateDernierChangement) {
		this.dateDernierChangement = dateDernierChangement;
	}

	public Integer getEchelonDernierChangement() {
		return echelonDernierChangement;
	}

	public void setEchelonDernierChangement(Integer echelonDernierChangement) {
		this.echelonDernierChangement = echelonDernierChangement;
	}

	public Integer getMoisAvantProchainChangementPrevisionnelMin() {
		return moisAvantProchainChangementPrevisionnelMin;
	}

	public void setMoisAvantProchainChangementPrevisionnelMin(
			Integer moisAvantProchainChangementPrevisionnelMin) {
		this.moisAvantProchainChangementPrevisionnelMin = moisAvantProchainChangementPrevisionnelMin;
	}

	public Integer getMoisAvantProchainChangementPrevisionnelMax() {
		return moisAvantProchainChangementPrevisionnelMax;
	}

	public void setMoisAvantProchainChangementPrevisionnelMax(
			Integer moisAvantProchainChangementPrevisionnelMax) {
		this.moisAvantProchainChangementPrevisionnelMax = moisAvantProchainChangementPrevisionnelMax;
	}

	public boolean isDateDernierChangementEstFuture() {
		return dateDernierChangementEstFuture;
	}

	public void setDateDernierChangementEstFuture(
			boolean dateDernierChangementEstFuture) {
		this.dateDernierChangementEstFuture = dateDernierChangementEstFuture;
	}

	public boolean isBonificationEchelon() {
		return bonificationEchelon;
	}

	public void setBonificationEchelon(boolean bonificationEchelon) {
		this.bonificationEchelon = bonificationEchelon;
	}

	public boolean isReliquatAnciennete() {
		return reliquatAnciennete;
	}

	public void setReliquatAnciennete(boolean reliquatAnciennete) {
		this.reliquatAnciennete = reliquatAnciennete;
	}
	
}
