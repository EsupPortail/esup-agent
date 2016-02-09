package org.esupportail.esupAgent.domain.beans.comparators;

import gouv.education.harpege.webservice.client.dossierRhAdministratif.ElementCarriereDto_V3;

import java.util.Comparator;

public class ElementCarriereSort implements Comparator<ElementCarriereDto_V3> {

	public int compare(ElementCarriereDto_V3 o1, ElementCarriereDto_V3 o2) {
		if (o1.getDateEffetElementsCarriere().equals(o2.getDateEffetElementsCarriere())) {
			if (o1.getIndiceDto().getIndiceNouveauMajore() != null && o2.getIndiceDto().getIndiceNouveauMajore() != null) {
				return (new Integer(o1.getIndiceDto().getIndiceNouveauMajore())
						.compareTo(new Integer(o2.getIndiceDto()
								.getIndiceNouveauMajore())));
			} else {
				return 1;
			}
		} else {
			return o1.getDateEffetElementsCarriere().compareTo(
					o2.getDateEffetElementsCarriere());
		}

	}

}
