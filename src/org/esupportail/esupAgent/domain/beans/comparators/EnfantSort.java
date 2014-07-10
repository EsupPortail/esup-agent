package org.esupportail.esupAgent.domain.beans.comparators;

import java.util.Comparator;

import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationContrats.AvenantContratDto;
import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationSituationFamiliale.EnfantDto_V2;

public class EnfantSort implements Comparator<EnfantDto_V2> {

	public int compare(EnfantDto_V2 o1, EnfantDto_V2 o2) {

		if (o1.getDateNaissance().getTime().equals(
				o2.getDateNaissance().getTime())) {
			return o1.getPrenom().compareTo(o2.getPrenom());

		} else {
			return o1.getDateNaissance().getTime().compareTo(o2.getDateNaissance().getTime());
		}

	}
}
