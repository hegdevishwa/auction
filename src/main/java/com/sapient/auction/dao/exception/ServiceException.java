/**
 * 
 */
package com.sapient.auction.dao.exception;

/**
 * @author vhegd1
 *
 */
public class ServiceException extends Exception {

	public ServiceException() {
	}

	/**
	 * Service exception which takes message as arguments.
	 * 
	 * @param throwable
	 */
	public ServiceException(String msg) {
		super(msg);
	}

	/**
	 * Service exception which takes throwable as arguments.
	 * 
	 * @param throwable
	 */
	public ServiceException(Throwable throwable) {
		super(throwable);
	}

	/**
	 * Service exception which takes string and throwable as arguments.
	 * 
	 * @param msg
	 * @param throwable
	 */
	public ServiceException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

}
