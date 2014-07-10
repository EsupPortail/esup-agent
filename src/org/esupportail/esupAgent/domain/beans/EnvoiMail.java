/**
 * 
 */
package org.esupportail.esupAgent.domain.beans;

import java.util.Arrays;
import java.util.Map;



/**
 * @author montel
 *
 */
public class EnvoiMail {
	Map <String,ContactMail> contactList;
	

	public Map<String, ContactMail> getContactList() {
		return contactList;
	}

	public void setContactList(Map<String, ContactMail> contactList) {
		this.contactList = contactList;
	}
	
	
	
}
