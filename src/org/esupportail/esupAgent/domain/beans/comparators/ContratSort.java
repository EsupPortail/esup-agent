package org.esupportail.esupAgent.domain.beans.comparators;

import gouv.education.harpege.webservice.client.dossierRhAdministratif.InformationsContratsDto;

import java.util.Comparator;

public class ContratSort implements Comparator<InformationsContratsDto>{

	public int compare(InformationsContratsDto o1, InformationsContratsDto o2) {
		if (o1.getDateDernierAvenant()!=null && o2.getDateDernierAvenant()!=null){
		return  (o1.getDateDernierAvenant().compareTo(o2.getDateDernierAvenant()));
		}
		if (o1.getDateDernierAvenant()==null){
			return 1;
		}
		if (o1.getDateDernierAvenant()==null){
			return -1;
		}
		return 0;
	}

}
