package gov.va.vetservices.partner.shareddata.ws.client;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import gov.va.ascent.framework.util.Defense;
import gov.va.ascent.framework.ws.client.BaseWsClientImpl;
import gov.va.ascent.framework.ws.client.remote.RemoteServiceCall;
import gov.va.vetservices.partner.shareddata.ws.client.remote.SharedDataRemoteServiceCallImpl;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindCountries;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindCountriesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindIntakeSites;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindIntakeSitesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStates;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStatesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStationAddress;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStationAddressResponse;

/**
 * This class provides an implementation of the SharedDataWSClient interface. It
 * encapsulates the details of interacting with the Person Web Service.
 */
@Component(SharedDataWsClientImpl.BEAN_NAME)
public class SharedDataWsClientImpl extends BaseWsClientImpl implements SharedDataWsClient {

	/** A constant representing the Spring Bean name. */
	public static final String BEAN_NAME = "sharedDataWsClient";

	/** the switchable remote for service calls (impl or mock) */
	@Autowired
	@Qualifier(SharedDataRemoteServiceCallImpl.BEAN_NAME)
	private RemoteServiceCall remoteServiceCall;

	/** axiom web service template. */
	@Autowired
	@Qualifier("sharedDataWsClientAxiomTemplate")
	public WebServiceTemplate sharedDataWsTemplate;

	/**
	 * The WebServiceTemplate can't be null.
	 */
	@PostConstruct
	public final void postConstruct() {
		Defense.notNull(remoteServiceCall, "remoteServiceCall cannot be null.");
		Defense.notNull(sharedDataWsTemplate,
				"sharedDataWsTemplate cannot be null in order for " + this.getClass().getSimpleName() + " to work properly.");
	}

	@Override
	public final FindStationAddressResponse findStationAddress(final FindStationAddress request) {
		Defense.notNull(request, REQUEST_FOR_WEBSERVICE_CALL_NULL);

		final FindStationAddressResponse response =
				(FindStationAddressResponse) remoteServiceCall.callRemoteService(sharedDataWsTemplate, request, request.getClass());

		Defense.notNull(response, RESPONSE_FROM_WEBSERVICE_CALL_NULL);

		return response;
	}

	@Override
	public final FindCountriesResponse findCountries(final FindCountries request) {
		Defense.notNull(request, REQUEST_FOR_WEBSERVICE_CALL_NULL);

		final FindCountriesResponse response =
				(FindCountriesResponse) remoteServiceCall.callRemoteService(sharedDataWsTemplate, request, request.getClass());

		Defense.notNull(response, RESPONSE_FROM_WEBSERVICE_CALL_NULL);

		return response;
	}

	@Override
	public final FindStatesResponse findStates(final FindStates request) {
		Defense.notNull(request, REQUEST_FOR_WEBSERVICE_CALL_NULL);

		final FindStatesResponse response =
				(FindStatesResponse) remoteServiceCall.callRemoteService(sharedDataWsTemplate, request, request.getClass());

		Defense.notNull(response, RESPONSE_FROM_WEBSERVICE_CALL_NULL);

		return response;
	}

	@Override
	public final FindIntakeSitesResponse findIntakeSites(final FindIntakeSites request) {
		Defense.notNull(request, REQUEST_FOR_WEBSERVICE_CALL_NULL);

		final FindIntakeSitesResponse response =
				(FindIntakeSitesResponse) remoteServiceCall.callRemoteService(sharedDataWsTemplate, request, request.getClass());

		Defense.notNull(response, RESPONSE_FROM_WEBSERVICE_CALL_NULL);

		return response;
	}
}
