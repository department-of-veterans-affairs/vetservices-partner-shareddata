package gov.va.vetservices.partner.shareddata.ws.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.fasterxml.jackson.databind.ObjectMapper;

import gov.va.ascent.framework.audit.RequestResponseLogSerializer;
import gov.va.ascent.framework.config.AscentCommonSpringProfiles;
import gov.va.vetservices.partner.shareddata.ws.client.remote.SharedDataRemoteServiceCallMock;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindCountries;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindCountriesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindIntakeSites;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindIntakeSitesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStates;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStatesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStationAddress;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStationAddressResponse;

/**
 * <p>
 * Tests the webservice implementation. Note specifically the @ActiveProfiles
 * and @ContextConfiguration.
 * </p>
 * <p>
 * To engage mocking capabilities, @ActiveProfiles must specify the simulator
 * profile. {@link SharedDataRemoteServiceCallMock} declares itself as the mocking
 * implementation for the simulator profile.
 * </p>
 * <p>
 * MockitoJUnitRunner class cannot be used to @RunWith because the application
 * context must Autowire the WebServiceTemplate from the client implementation.
 * </p>
 *
 * @author aburkholder
 */
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners(inheritListeners = false, listeners = { DependencyInjectionTestExecutionListener.class,
		DirtiesContextTestExecutionListener.class, TransactionalTestExecutionListener.class })
@ActiveProfiles({ AscentCommonSpringProfiles.PROFILE_REMOTE_CLIENT_SIMULATORS })
@ContextConfiguration(inheritLocations = false, classes = { PartnerMockFrameworkTestConfig.class, SharedDataWsClientConfig.class })
public class SharedDataWsClientImplTest extends AbstractSharedDataTest {

	private final static String TEST_VALID_STN_NBR = "301";
	private final static String TEST_BAD_STN_NBR = "000";
	
	@Spy
    RequestResponseLogSerializer requestResponseLogSerializer = new RequestResponseLogSerializer();
	
	@Autowired
	@Qualifier(SharedDataWsClientImpl.BEAN_NAME)
	SharedDataWsClient sharedDataWsClientImpl;


	@Before
	public void setUp() {
		assertNotNull("FAIL sharedDataWsClientImpl cannot be null.", sharedDataWsClientImpl);
	}

	@Test
	public void testFindStationAddress() {

		// call the impl declared by the current @ActiveProfiles
		FindStationAddress request = makeFindStationAddressRequest(TEST_VALID_STN_NBR);
		FindStationAddressResponse response = sharedDataWsClientImpl.findStationAddress(request);
		assertNotNull(response);
		assertNotNull(response.getReturn());
		assertNotNull(response.getReturn().getReturnCode());
	}

	@Test
	public void testFindStationAddress_badStateCode() {

		// call the impl declared by the current @ActiveProfiles
		FindStationAddress request = makeFindStationAddressRequest(TEST_BAD_STN_NBR);
		FindStationAddressResponse response = null;

		try {
			response = sharedDataWsClientImpl.findStationAddress(request);
		} catch (final Exception e) {
			e.printStackTrace();
		}

		assertNull("Bad state code should have thrown exception and not created a response.", response);
	}

	/**
	 * Test findCountries.
	 */
	@Test
	public void testCountries() {

		final FindCountriesResponse findCountriesResponse = sharedDataWsClientImpl.findCountries(new FindCountries());

		// Check the response for valid data.
		Assert.assertNotNull(" Response must not be null.", findCountriesResponse);

		Assert.assertNotNull("station should not be null", findCountriesResponse.getReturn());
		// If no DTO was returned, the participant Id did not match a case.
		Assert.assertNotNull("No data returned from ShareStandardData Web Service ", findCountriesResponse.getReturn().getTypes());

	}

	/**
	 * Test findStates.
	 */
	@Test
	public void testStates() {

		final FindStatesResponse findStatesResponse = sharedDataWsClientImpl.findStates(new FindStates());

		// Check the response for valid data.
		Assert.assertNotNull(" Response must not be null.", findStatesResponse);

		Assert.assertNotNull("station should not be null", findStatesResponse.getReturn());
		// If no DTO was returned, the participant Id did not match a case.
		Assert.assertNotNull("No data returned from ShareStandardData Web Service ", findStatesResponse.getReturn().getTypes());

	}

	/**
	 * Test findIntakeSites .
	 */
	@Test
	public void testIntakeSites() {

		final FindIntakeSitesResponse findIntakeSitesResponse = sharedDataWsClientImpl.findIntakeSites(new FindIntakeSites());

		// Check the response for valid data.
		Assert.assertNotNull(" Response must not be null.", findIntakeSitesResponse);

		Assert.assertNotNull("station should not be null", findIntakeSitesResponse.getReturn());
		// If no DTO was returned, the participant Id did not match a case.
		Assert.assertNotNull("No data returned from ShareStandardData Web Service ", findIntakeSitesResponse.getReturn().getTypes());
	}
}