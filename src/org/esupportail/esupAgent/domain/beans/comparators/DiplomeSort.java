package org.esupportail.esupAgent.domain.beans.comparators;

import gouv.education.harpege.transverse.dto.DossierRhPerso.ConsultationDiplomes.ConsultationDiplomesDto;
import java.util.Comparator;

/**
 *
 * @author uhp
 */
public class DiplomeSort implements Comparator<ConsultationDiplomesDto> {


    public int compare(ConsultationDiplomesDto o1, ConsultationDiplomesDto o2) {
        return -1 * o1.getAnneeDiplome().compareTo(o2.getAnneeDiplome());
    }

}