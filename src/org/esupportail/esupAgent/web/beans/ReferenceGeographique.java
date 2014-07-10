/**
 * 
 */
package org.esupportail.esupAgent.web.beans;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;

import gouv.education.harpege.transverse.dto.refGeo.VoirieReponseWSDto;
import gouv.education.harpege.transverse.exception.HarpegeFonctionnelleException;
import gouv.education.harpege.transverse.exception.HarpegeTechniqueException;
import gouv.education.harpege.webservice.client.referentielGeographique.ReferentielGeographiqueSoapBindingStub;
import gouv.education.harpege.webservice.client.referentielGeographique.ReferentielGeographiqueWebServiceServiceLocator;

/**
 * @author montel
 *
 */
public class ReferenceGeographique {
	
	private ReferentielGeographiqueWebServiceServiceLocator refGeoWSServiceLocator;
	private boolean wsdl_anonymous;
	private String wsdl_usr_name="";
	private String wsdl_usr_password="";
	private String url_referentiel_geographique;
	
	private VoirieReponseWSDto voirieReponseWSDto;

	private final Logger logger = new LoggerImpl(getClass());
	
	
	
	/**
	 * @param wsdlAnonymous
	 * @param wsdlUsrName
	 * @param wsdlUsrPassword
	 * @param urlReferentielGeographique
	 */
	public ReferenceGeographique(boolean wsdlAnonymous, String wsdlUsrName,
			String wsdlUsrPassword, String urlReferentielGeographique) {
		super();
		wsdl_anonymous = wsdlAnonymous;
		wsdl_usr_name = wsdlUsrName;
		wsdl_usr_password = wsdlUsrPassword;
		url_referentiel_geographique = urlReferentielGeographique;
	}

	public VoirieReponseWSDto getVoirieReponseWSDto() {
		
		refGeoWSServiceLocator = new ReferentielGeographiqueWebServiceServiceLocator();
		refGeoWSServiceLocator.setreferentielGeographiqueEndpointAddress(url_referentiel_geographique);
		voirieReponseWSDto = new VoirieReponseWSDto();
		
		ReferentielGeographiqueSoapBindingStub refGeoWS;
		try {
			refGeoWS = (ReferentielGeographiqueSoapBindingStub) refGeoWSServiceLocator.getreferentielGeographique();
			if (! wsdl_anonymous){
				refGeoWS.setUsername(wsdl_usr_name);
				refGeoWS.setPassword(wsdl_usr_password);
				}
			
			try {
				voirieReponseWSDto = refGeoWS.recupererTypeVoie(null);
				
			} catch (HarpegeTechniqueException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HarpegeFonctionnelleException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return voirieReponseWSDto;
	}

	public void setVoirieReponseWSDto(VoirieReponseWSDto voirieReponseWSDto) {
		this.voirieReponseWSDto = voirieReponseWSDto;
	}

	public boolean isWsdl_anonymous() {
		return wsdl_anonymous;
	}

	public void setWsdl_anonymous(boolean wsdlAnonymous) {
		wsdl_anonymous = wsdlAnonymous;
	}

	public String getWsdl_usr_name() {
		return wsdl_usr_name;
	}

	public void setWsdl_usr_name(String wsdlUsrName) {
		wsdl_usr_name = wsdlUsrName;
	}

	public String getWsdl_usr_password() {
		return wsdl_usr_password;
	}

	public void setWsdl_usr_password(String wsdlUsrPassword) {
		wsdl_usr_password = wsdlUsrPassword;
	}
	
	

}
