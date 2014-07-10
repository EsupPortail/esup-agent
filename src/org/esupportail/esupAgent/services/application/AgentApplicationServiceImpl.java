package org.esupportail.esupAgent.services.application;

import org.esupportail.commons.services.application.SimpleApplicationServiceImpl;
import org.esupportail.esupAgent.domain.DomainService;
import org.esupportail.esupAgent.domain.beans.config.ConfigAgent;

/**
 * @author Sebastien Montel
 *
 */
public class AgentApplicationServiceImpl extends SimpleApplicationServiceImpl {
	
	ConfigAgent configAgent;
	DomainService domainService;
	
	public AgentApplicationServiceImpl() {
		super();
	}

	public void afterPropertiesSet() {
		super.afterPropertiesSet();
	}

	public ConfigAgent getConfigAgent() {
		return configAgent;
	}

	public void setConfigAgent(ConfigAgent configAgent) {
		this.configAgent = configAgent;
	}

	/**
	 * @return the domainService
	 */
	public DomainService getDomainService() {
		return domainService;
	}

	/**
	 * @param domainService the domainService to set
	 */
	public void setDomainService(DomainService domainService) {
		this.domainService = domainService;
	}
	
	
}
