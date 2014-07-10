package org.esupportail.commons.aop.monitor;


/**
 * Monitoring utilities.
 */
public abstract class MonitorUtils {

	/**
	 * Constructor.
	 */
	private MonitorUtils() {
		super();
	}

	/**
	 * Log the method calls.
	 * @param startTime
	 * @param message 
	 */
	public static void log(
			final long startTime,
			final String message) {
		(new MonitoringMethodInterceptor()).log(startTime, message);
	}
	
	/**
	 * Clear.
	 */
	public static void clear() {
		(new MonitoringMethodInterceptor()).clear();
	}
	
}