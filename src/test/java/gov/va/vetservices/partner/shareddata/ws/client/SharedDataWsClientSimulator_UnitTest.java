/*
 *
 */
package gov.va.vetservices.partner.shareddata.ws.client;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gov.va.ascent.framework.config.AscentCommonSpringProfiles;
import gov.va.vetservices.partner.shareddata.ws.client.SharedDataWsClient;
import gov.va.vetservices.partner.shareddata.ws.client.SharedDataWsClientConfig;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindCountries;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindCountriesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindIntakeSites;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindIntakeSitesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStates;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStatesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStationAddress;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStationAddressResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.ObjectFactory;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.Station;
import junit.framework.TestCase;

/**
 * The Class PersonWsClientSimulator_UnitTest.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({ AscentCommonSpringProfiles.PROFILE_ENV_LOCAL_INT,
	AscentCommonSpringProfiles.PROFILE_REMOTE_CLIENT_SIMULATORS })

/** ISSUE
 * This was removed from @ContextConfiguration:   , PartnerMockFrameworkTestConfig.class })
 * otherwise the properties fail to load
 */
@ContextConfiguration(inheritLocations = false, classes = { SharedDataWsClientConfig.class })
public class SharedDataWsClientSimulator_UnitTest extends TestCase {

	/** The SharedData WS client. */
	@Autowired
	SharedDataWsClient sharedDataWsClient;

	/** The Constant SHAREDDATA_OBJECT_FACTORY. */
	protected static final ObjectFactory SHAREDDATA_OBJECT_FACTORY = new ObjectFactory();

	@Before
	public void before() throws Exception {
		assertNotNull(sharedDataWsClient);
	}

	@Test
	public void testFindStationAddress() {
		final String stationNumber = "373";
		final FindStationAddress findStationAddressRequest = new FindStationAddress();
		findStationAddressRequest.setStationNumber(stationNumber);
		assertNotNull(findStationAddressRequest);
		final FindStationAddressResponse findStationAddressResponse =
				sharedDataWsClient.findStationAddress(findStationAddressRequest);
		assertNotNull(findStationAddressResponse);
		final Station station = findStationAddressResponse.getReturn();
		assertNotNull(station);
		assertNotNull(station.getCity());
	}

	/**
	 * Test findCountries.
	 */
	@Test
	public void testCountries() {


		final FindCountriesResponse findCountriesResponse =
				sharedDataWsClient.findCountries(new FindCountries());

		// Check the response for valid data.
		Assert.assertNotNull(" Response must not be null.", findCountriesResponse);

		Assert.assertNotNull("station should not be null", findCountriesResponse.getReturn());
		// If no DTO was returned, the participant Id did not match a case.
		Assert.assertNotNull(
				"No data returned from ShareStandardData Web Service "
				, findCountriesResponse.getReturn().getTypes());

	}

	/**
	 * Test findStates.
	 */
	@Test
	public void testStates() {


		final FindStatesResponse findStatesResponse =
				sharedDataWsClient.findStates(new FindStates());

		// Check the response for valid data.
		Assert.assertNotNull(" Response must not be null.", findStatesResponse);

		Assert.assertNotNull("station should not be null", findStatesResponse.getReturn());
		// If no DTO was returned, the participant Id did not match a case.
		Assert.assertNotNull(
				"No data returned from ShareStandardData Web Service "
				, findStatesResponse.getReturn().getTypes());

	}

	/**
	 * Test findIntakeSites .
	 */
	@Test
	public void testIntakeSites() {


		final FindIntakeSitesResponse findIntakeSitesResponse =
				sharedDataWsClient.findIntakeSites(new FindIntakeSites());

		// Check the response for valid data.
		Assert.assertNotNull(" Response must not be null.", findIntakeSitesResponse);

		Assert.assertNotNull("station should not be null", findIntakeSitesResponse.getReturn());
		// If no DTO was returned, the participant Id did not match a case.
		Assert.assertNotNull(
				"No data returned from ShareStandardData Web Service "
				, findIntakeSitesResponse.getReturn().getTypes());
	}
}
