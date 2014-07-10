/**
 * 
 */
package org.esupportail.esupAgent.domain.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @author montel
 *
 */
public class ContactMail {
	private String libelle;
	private List addressList=new ArrayList();

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List getAddressList() {
		return addressList;
	}

	public void setAddressList(List addressList) {
		this.addressList = addressList;
	}

	
	

}
