/**
 * ESUP-Portail ESUP Agent - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-agent
 */
package org.esupportail.esupAgent.domain.beans;


import java.io.Serializable;

import org.esupportail.commons.utils.strings.StringUtils;

/**
 * The class that represent users.
 */
public class User implements Serializable {
	
	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = 9108580316214008120L;

	/**
	 * Id of the user.
	 */
	private String id;
	
    /**
	 * Display Name of the user.
	 */
    private String displayName;
    
    /**
	 * Mail of the user.
	 */
    private String mail;
    
    /**
	 * True for administrators.
	 */
    private boolean admin;
	
    /**
     * The prefered language.
     */
    private String language;
    
    private Agent agent;
    
	/**
	 * Bean constructor.
	 */
	public User() {
		super();
	}
	public User(String login) {
		super();
		this.id=login;
	}
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(final Object obj) {
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		return id.equals(((User) obj).getId());
	}

	/**
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return super.hashCode();
	}

	/**
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User#" + hashCode() + "[id=[" + id + "], displayName=[" + displayName 
		+ "], admin=[" + admin + "], language=[" + language + "]]";
	}

	/**
	 * @return  the id of the user.
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(final String id) {
		this.id = StringUtils.nullIfEmpty(id);
	}

    /**
	 * @return  Returns the displayName.
	 */
    public String getDisplayName() {
        return this.displayName;
    }

    /**
	 * @param displayName  The displayName to set.
	 */
    public void setDisplayName(final String displayName) {
        this.displayName = StringUtils.nullIfEmpty(displayName);
    }
    
    /**
	 * @param admin  The admin to set.
	 */
    public void setAdmin(final boolean admin) {
        this.admin = admin;
    }
    /**
	 * @return  Returns the admin.
	 */
    public boolean getAdmin() {
        return this.admin;
    }

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(final String language) {
		this.language = StringUtils.nullIfEmpty(language);
	}

	/**
	 * @return the agent
	 */
	public Agent getAgent() {
		return agent;
	}

	/**
	 * @param agent the agent to set
	 */
	public void setAgent(Agent agent) {
		this.agent = agent;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
    
	

}
