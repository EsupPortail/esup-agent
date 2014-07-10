package org.esupportail.esupAgent.domain.beans.comparators;

import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationContrats.InformationsContratsDto;

import java.util.Comparator;

public class ContratSort implements Comparator<InformationsContratsDto>{

	public int compare(InformationsContratsDto o1, InformationsContratsDto o2) {
		if (o1.getDateDernierAvenant()!=null && o2.getDateDernierAvenant()!=null){
		return  (o1.getDateDernierAvenant().compareTo(o2.getDateDernierAvenant()));
		}
		return 1;
	}

}
