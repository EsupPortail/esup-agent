/**
 * 
 */
package org.esupportail.esupAgent.domain.beans.comparators;

import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationContrats.InformationsContratsDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationOccupationAffectation.AffectationDto;
import gouv.education.harpege.transverse.dto.DossierRhAdministratif.ConsultationInformationOccupationAffectation.InformationsOccupationAffectationDto;

import java.util.Comparator;

/**
 * @author montel
 * 
 */
public class AffectationSort implements Comparator<AffectationDto> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(AffectationDto o1, AffectationDto o2) {
		if (o1.getDateFinAffectation() != null
				&& o2.getDateFinAffectation() != null) {
			return (o1.getDateFinAffectation().compareTo(o2
					.getDateFinAffectation()));
		}
		if (o1.getDateFinAffectation() == null) {
			return 1;
		}
		if (o1.getDateFinAffectation() == null) {
			return -1;
		}
		return 0;

	}

	// public int compare(InformationsContratsDto o1, InformationsContratsDto
	// o2) {
	// if (o1.getDateDernierAvenant()!=null &&
	// o2.getDateDernierAvenant()!=null){
	// return
	// (o1.getDateDernierAvenant().compareTo(o2.getDateDernierAvenant()));
	// }
	// if (o1.getDateDernierAvenant()==null){
	// return 1;
	// }
	// if (o1.getDateDernierAvenant()==null){
	// return -1;
	// }
	// return 0;
	// }

}
