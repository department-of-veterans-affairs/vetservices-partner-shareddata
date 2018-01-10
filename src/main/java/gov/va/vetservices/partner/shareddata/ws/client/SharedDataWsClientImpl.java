package gov.va.vetservices.partner.shareddata.ws.client;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBElement;

import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindCountries;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindCountriesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindIntakeSites;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindIntakeSitesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStationAddress;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStationAddressResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStates;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStatesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.ObjectFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

import gov.va.ascent.framework.config.AscentCommonSpringProfiles;
import gov.va.ascent.framework.util.Defense;
import gov.va.ascent.framework.ws.client.BaseWsClientImpl;

/**
 * This class provides an implementation of the SharedDataWSClient interface. It
 * encapsulates the details of interacting with the Person Web Service.
 */
@Component(SharedDataWsClientImpl.BEAN_NAME)
@Profile({ AscentCommonSpringProfiles.PROFILE_REMOTE_CLIENT_IMPLS,
		SharedDataWsClient.PROFILE_SHAREDDATAWSCLIENT_REMOTE_CLIENT_IMPL })
public class SharedDataWsClientImpl extends BaseWsClientImpl implements SharedDataWsClient {

	/**
	 * A constant representing the Spring Bean name.
	 */
	public static final String BEAN_NAME = "sharedDataWsClient";

	/**
	 * The Constant SHAREDDATA_OBJECT_FACTORY.
	 */
	protected static final ObjectFactory SHAREDDATA_OBJECT_FACTORY = new ObjectFactory();

	/**
	 * Spring axiom web service template.
	 */
	@Autowired
	@Qualifier("sharedDataWsClient.axiom")
	private WebServiceTemplate axiomWebServiceTemplate;

	/**
	 * The WebServiceTemplate can't be null.
	 */
	@PostConstruct
	public final void postConstruct() {
		Defense.notNull(axiomWebServiceTemplate, "axiomWebServiceTemplate cannot be null in order for "
				+ this.getClass().getSimpleName() + " to work properly.");
	}

	@SuppressWarnings("unchecked")
	@Override
	public final FindStationAddressResponse findStationAddress(final FindStationAddress findStationAddressRequest) {

		Defense.notNull(findStationAddressRequest, REQUEST_FOR_WEBSERVICE_CALL_NULL);
		FindStationAddressResponse stationAddressResponse;
		final JAXBElement<FindStationAddress> findStationAddressRequestElement = SHAREDDATA_OBJECT_FACTORY
				.createFindStationAddress(findStationAddressRequest);

		final Object webServiceResponse = axiomWebServiceTemplate
				.marshalSendAndReceive(findStationAddressRequestElement);
		Defense.notNull(webServiceResponse, RESPONSE_FROM_WEBSERVICE_CALL_NULL);
		final JAXBElement<FindStationAddressResponse> webServiceResponseElement = (JAXBElement<FindStationAddressResponse>) webServiceResponse;
		stationAddressResponse = webServiceResponseElement.getValue();

		return stationAddressResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public final FindCountriesResponse findCountries(final FindCountries findCountries) {

		Defense.notNull(findCountries, REQUEST_FOR_WEBSERVICE_CALL_NULL);
		FindCountriesResponse findCountriesResponse;
		final JAXBElement<FindCountries> findCountriesRequestElement = SHAREDDATA_OBJECT_FACTORY
				.createFindCountries(findCountries);

		final Object webServiceResponse = axiomWebServiceTemplate.marshalSendAndReceive(findCountriesRequestElement);
		Defense.notNull(webServiceResponse, RESPONSE_FROM_WEBSERVICE_CALL_NULL);
		final JAXBElement<FindCountriesResponse> webServiceResponseElement = (JAXBElement<FindCountriesResponse>) webServiceResponse;
		findCountriesResponse = webServiceResponseElement.getValue();

		return findCountriesResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public final FindStatesResponse findStates(final FindStates findStates) {

		Defense.notNull(findStates, REQUEST_FOR_WEBSERVICE_CALL_NULL);
		FindStatesResponse findStatesResponse;
		final JAXBElement<FindStates> findStatesRequestElement = SHAREDDATA_OBJECT_FACTORY.createFindStates(findStates);

		final Object webServiceResponse = axiomWebServiceTemplate.marshalSendAndReceive(findStatesRequestElement);
		Defense.notNull(webServiceResponse, RESPONSE_FROM_WEBSERVICE_CALL_NULL);
		final JAXBElement<FindStatesResponse> webServiceResponseElement = (JAXBElement<FindStatesResponse>) webServiceResponse;
		findStatesResponse = webServiceResponseElement.getValue();

		return findStatesResponse;
	}

	@SuppressWarnings("unchecked")
	@Override
	public final FindIntakeSitesResponse findIntakeSites(final FindIntakeSites findIntakeSites) {

		Defense.notNull(findIntakeSites, REQUEST_FOR_WEBSERVICE_CALL_NULL);
		FindIntakeSitesResponse findIntakeSitesResponse;
		final JAXBElement<FindIntakeSites> findIntakeSitesRequestElement = SHAREDDATA_OBJECT_FACTORY
				.createFindIntakeSites(findIntakeSites);

		final Object webServiceResponse = axiomWebServiceTemplate.marshalSendAndReceive(findIntakeSitesRequestElement);
		Defense.notNull(webServiceResponse, RESPONSE_FROM_WEBSERVICE_CALL_NULL);
		final JAXBElement<FindIntakeSitesResponse> webServiceResponseElement = (JAXBElement<FindIntakeSitesResponse>) webServiceResponse;
		findIntakeSitesResponse = webServiceResponseElement.getValue();

		return findIntakeSitesResponse;
	}
}
