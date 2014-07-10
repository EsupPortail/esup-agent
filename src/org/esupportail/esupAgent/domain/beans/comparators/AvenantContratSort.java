package org.esupportail.esupAgent.domain.beans.comparators;

import java.util.Comparator;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationContrats.AvenantContratDto;

public class AvenantContratSort implements Comparator<AvenantContratDto> {

	public int compare(AvenantContratDto o1, AvenantContratDto o2) {
		if (o1.getDateDebutContrat().equals(o2.getDateDebutContrat())){
			if (o1.getCodeEchelon()!=null){
				return Integer.valueOf(o1.getCodeEchelon()).compareTo(Integer.valueOf(o2.getCodeEchelon()));
			}
		} else {
			return o1.getDateDebutContrat().compareTo(o2.getDateDebutContrat());
		}
		return 1;
	}

}
