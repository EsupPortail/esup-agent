/**
 * ESUP-Portail ESUP Agent - Copyright (c) 2006 ESUP-Portail consortium
 * http://sourcesup.cru.fr/projects/esup-agent
 */
package org.esupportail.esupAgent.dao;

import java.util.List;

import org.esupportail.esupAgent.domain.beans.User;
import org.esupportail.esupAgent.domain.beans.VersionManager ;
import org.esupportail.commons.dao.AbstractJdbcJndiHibernateDaoService;
import org.esupportail.commons.dao.HibernateFixedQueryPaginator;
import org.esupportail.commons.dao.HqlUtils;
import org.esupportail.commons.services.application.UninitializedDatabaseException;
import org.esupportail.commons.services.application.VersionningUtils;
import org.esupportail.commons.services.logging.Logger;
import org.esupportail.commons.services.logging.LoggerImpl;
import org.esupportail.commons.web.beans.Paginator;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.BadSqlGrammarException;

/**
 * The Hiberate implementation of the DAO service. 
 * extends AbstractJdbcJndiHibernateDaoService
 */
public class AgentDaoServiceImpl 
implements DaoService, InitializingBean {

	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		
	}

	/**
	 * The serialization id.
	 */
	private static final long serialVersionUID = 3152554337896617315L;
	private final Logger logger = new LoggerImpl(getClass());
	/**
	 * The name of the 'id' attribute.
	 */
	private static final String ID_ATTRIBUTE = "id";

	/**
	 * The name of the 'admin' attribute.
	 */
	private static final String ADMIN_ATTRIBUTE = "admin";

	/**
	 * Bean constructor.
	 */
	public AgentDaoServiceImpl() {
		super();
	}

	//////////////////////////////////////////////////////////////
	// User
	//////////////////////////////////////////////////////////////

	/**
	 * @see org.esupportail.esupAgent.dao.DaoService#getUser(java.lang.String)
	 */
	/*public User getUser(final String id) {
		return (User) getHibernateTemplate().get(User.class, id);
	}*/

	/**
	 * @see org.esupportail.esupAgent.dao.DaoService#getUsers()
	 */
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return null;
	}

	/**
	 * @see org.esupportail.esupAgent.dao.DaoService#addUser(org.esupportail.esupAgent.domain.beans.User)
	 */
	public void addUser(final User user) {
	logger.info(user.getId());
	}

	/**
	 * @see org.esupportail.esupAgent.dao.DaoService#deleteUser(org.esupportail.esupAgent.domain.beans.User)
	 */
	public void deleteUser(final User user) {
	
	}

	/**
	 * @see org.esupportail.esupAgent.dao.DaoService#updateUser(org.esupportail.esupAgent.domain.beans.User)
	 */
	public void updateUser(final User user) {
		
	}

	/**
	 * @see org.esupportail.esupAgent.dao.DaoService#getAdminPaginator()
	 */
	public Paginator<User> getAdminPaginator() {
	
		return null;
	}

	//////////////////////////////////////////////////////////////
	// VersionManager
	//////////////////////////////////////////////////////////////

	/**
	 * @see org.esupportail.esupAgent.dao.DaoService#getVersionManager()
	 */
	@SuppressWarnings("unchecked")
	public VersionManager getVersionManager() {
		/*DetachedCriteria criteria = DetachedCriteria.forClass(VersionManager.class);
		criteria.addOrder(Order.asc(ID_ATTRIBUTE));
		List<VersionManager> versionManagers;
		try {
			versionManagers = getHibernateTemplate().findByCriteria(criteria);
		} catch (BadSqlGrammarException e) {
			throw new UninitializedDatabaseException(
					"your database is not initialized, please run 'ant init-data'", e);
		}
		if (versionManagers.isEmpty()) {
			VersionManager versionManager = new VersionManager();
			versionManager.setVersion(VersionningUtils.VERSION_0);
			addObject(versionManager);
			return versionManager;
		}
		return versionManagers.get(0);
		*/
		VersionManager versionManager=new VersionManager();
		versionManager.setVersion("0.0.9");
		return versionManager;
	}

	/**
	 * @see org.esupportail.esupAgent.dao.DaoService#updateVersionManager(
	 * org.esupportail.esupAgent.domain.beans.VersionManager)
	 */
	public void updateVersionManager(final VersionManager versionManager) {
		
	}

	//////////////////////////////////////////////////////////////
	// misc
	//////////////////////////////////////////////////////////////

}
