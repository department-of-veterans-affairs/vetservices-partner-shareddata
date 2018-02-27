package gov.va.vetservices.partner.shareddata.ws.client;

import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindCountries;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindCountriesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindIntakeSites;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindIntakeSitesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStates;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStatesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStationAddress;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStationAddressResponse;

/**
 * The interface for the SharedData Web Service Client.
 *
 */
public interface SharedDataWsClient {

	/**
	 * @param findStationAddressRequest
	 *            The SharedData Web Service FindStationAddress request entity
	 * @return findStationAddressResponse The SharedData Web Service
	 *         FindStationAddressResponse response entity
	 */
	FindStationAddressResponse findStationAddress(FindStationAddress findStationAddressRequest);

	/**
	 * @param request
	 *            The SharedData Web Service FindCountries request entity
	 * @return request The SharedData Web Service FindCountriesResponse response
	 *         entity
	 */
	FindCountriesResponse findCountries(final FindCountries request);

	/**
	 * Finds the list of Intake Sites
	 *
	 * @param findIntakeSites
	 *            request
	 * @return FindIntakeSitesResponse
	 */
	FindIntakeSitesResponse findIntakeSites(final FindIntakeSites findIntakeSites);

	/**
	 * Finds the list of States
	 *
	 * @param request
	 *            The SharedData Web Service FindStates request entity
	 * @return FindStatesResponse The SharedData Web Service FindStatesResponse
	 *         response entity
	 */
	FindStatesResponse findStates(final FindStates request);
}
