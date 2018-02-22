package gov.va.vetservices.partner.shareddata.ws.client.remote;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import gov.va.ascent.framework.config.AscentCommonSpringProfiles;
import gov.va.ascent.framework.transfer.AbstractTransferObject;
import gov.va.ascent.framework.util.Defense;
import gov.va.ascent.framework.ws.client.remote.AbstractRemoteServiceCallMock;
import gov.va.ascent.framework.ws.client.remote.RemoteServiceCall;
import gov.va.vetservices.partner.shareddata.ws.client.SharedDataWsClientException;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindCountries;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindIntakeSites;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStates;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStationAddress;

/**
 * Implements the {@link RemoteServiceCall} interface, and extends
 * {@link AbstractRemoteServiceCallMock} for mocking the remote client under the
 * simulators spring profile.
 *
 * @author aburkholder
 */
@Profile(AscentCommonSpringProfiles.PROFILE_REMOTE_CLIENT_SIMULATORS)
@Component(SharedDataRemoteServiceCallImpl.BEAN_NAME)
public class SharedDataRemoteServiceCallMock extends AbstractRemoteServiceCallMock {

	/** static string prepended to the station id to identify address mock response files */
	static final String FIND_ADDRESS_PREFACE = "stationAddress_";
	/** single filename for all countries requests */
	static final String FIND_COUNTRIES = "allCountries";
	/** single filename for all states requests */
	static final String FIND_STATES = "allStates";
	/** single filename for all intake sites requests */
	static final String FIND_INTAKE_SITES = "allIntakeSites";

	/** error message if request is null */
	static final String ERROR_NULL_REQUEST = "getKeyForMockResponse request parameter cannont be null.";
	/** error message prefix if request type is not handled in getKeyForMockResponse(..) */
	static final String ERROR_UNHANDLED_REQUEST_TYPE =
			".getKeyForMockResponse(..) does not have a file naming block for requests of type ";

	/*
	 * (non-Javadoc)
	 *
	 * @see gov.va.ascent.framework.ws.client.remote.RemoteServiceCall#callRemoteService(org.springframework.ws.client.core.
	 * WebServiceTemplate, gov.va.ascent.framework.transfer.AbstractTransferObject, java.lang.Class)
	 */
	@Override
	public AbstractTransferObject callRemoteService(final WebServiceTemplate webserviceTemplate, final AbstractTransferObject request,
			final Class<? extends AbstractTransferObject> requestClass) {

		return super.callMockService(webserviceTemplate, request, requestClass);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * gov.va.ascent.framework.ws.client.remote.AbstractRemoteServiceCallMock#getKeyForMockResponse(gov.va.ascent.framework.transfer.
	 * AbstractTransferObject)
	 */
	@Override
	protected String getKeyForMockResponse(final AbstractTransferObject request) {
		Defense.notNull(request, ERROR_NULL_REQUEST);

		String mockFilename = null;

		if (request.getClass().isAssignableFrom(FindStationAddress.class)) {

			Defense.hasText(((FindStationAddress) request).getStationNumber());

			// specify a mock filename that uses the station number
			mockFilename = FIND_ADDRESS_PREFACE + ((FindStationAddress) request).getStationNumber();

		} else if (request.getClass().isAssignableFrom(FindCountries.class)) {
			// specify a mock filename for all findCountries requests
			mockFilename = FIND_COUNTRIES;

		} else if (request.getClass().isAssignableFrom(FindStates.class)) {
			// specify a mock filename for all findStates requests
			mockFilename = FIND_STATES;

		} else if (request.getClass().isAssignableFrom(FindIntakeSites.class)) {
			// specify a mock filename for all findIntakeSites requests
			mockFilename = FIND_INTAKE_SITES;

		} else {
			throw new SharedDataWsClientException(
					this.getClass().getSimpleName() + ERROR_UNHANDLED_REQUEST_TYPE + request.getClass().getName());
		}

		// return value can never be null or empty, there is Defense against it
		return mockFilename;
	}

}
