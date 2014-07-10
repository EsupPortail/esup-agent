package org.esupportail.commons.aop.cache;


/**
 * Caching utilities.
 */
public abstract class CacheUtils {

	/**
	 * Constructor.
	 */
	private CacheUtils() {
		super();
	}

	/**
	 * Clear.
	 */
	public static void clearRequest() {
		(new RequestCachingMethodInterceptor()).clear();
	}
	
	/**
	 * Clear.
	 */
	public static void clearSession() {
		(new SessionCachingMethodInterceptor()).clear();
	}
	
}