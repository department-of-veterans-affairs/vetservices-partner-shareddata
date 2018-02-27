package gov.va.vetservices.partner.shareddata.ws.client;

import gov.va.ascent.framework.exception.AscentRuntimeException;

/**
 * Root exceptions which indicates an exception/error in the
 * SharedDataWsClient web service
 */
public class SharedDataWsClientException extends AscentRuntimeException {

	/** Generated serialVersionUID. */
	private static final long serialVersionUID = -8751235554954215227L;

	/**
	 * Instantiates a new exception.
	 */
	public SharedDataWsClientException() {
		super();
	}

	/**
	 * Instantiates a new exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public SharedDataWsClientException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Instantiates a new exception.
	 *
	 * @param message the message
	 */
	public SharedDataWsClientException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new exception.
	 *
	 * @param cause the cause
	 */
	public SharedDataWsClientException(final Throwable cause) {
		super(cause);
	}
}
