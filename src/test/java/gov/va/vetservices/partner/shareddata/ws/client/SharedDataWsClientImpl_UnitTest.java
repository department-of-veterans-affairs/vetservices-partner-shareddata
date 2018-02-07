package gov.va.vetservices.partner.shareddata.ws.client;

import static org.junit.Assert.assertNotNull;
import static org.springframework.ws.test.client.RequestMatchers.payload;
import static org.springframework.ws.test.client.ResponseCreators.withPayload;

import javax.xml.transform.Source;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.test.client.MockWebServiceServer;
import org.springframework.xml.transform.StringSource;

import gov.va.ascent.framework.config.AscentCommonSpringProfiles;
import gov.va.vetservices.partner.mock.framework.PartnerMockFrameworkTestConfig;
import gov.va.vetservices.partner.shareddata.ws.client.SharedDataWsClient;
import gov.va.vetservices.partner.shareddata.ws.client.SharedDataWsClientConfig;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindCountries;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindCountriesResponse;

/**
 * Unit test of PersonWsClientImpl.
 */
/**
 * Commenting everything to try an approach that will work on this
 * platform @RunWith(SpringJUnit4ClassRunner.class) @ActiveProfiles({
 * AscentCommonSpringProfiles.PROFILE_ENV_LOCAL_INT,
 * AscentCommonSpringProfiles.PROFILE_REMOTE_CLIENT_IMPLS })
 *
 * @ContextConfiguration(inheritLocations = false, classes = {
 *                                        SharedDataWsClientConfig.class,
 *                                        PartnerMockFrameworkTestConfig.class
 *                                        })
 */
@RunWith(SpringRunner.class)
@ActiveProfiles({ AscentCommonSpringProfiles.PROFILE_ENV_LOCAL_INT,
	AscentCommonSpringProfiles.PROFILE_REMOTE_CLIENT_IMPLS })
@ContextConfiguration(inheritLocations = false, classes = { SharedDataWsClientConfig.class,
		PartnerMockFrameworkTestConfig.class })
public class SharedDataWsClientImpl_UnitTest {

	// @Autowired
	// private ApplicationContext applicationContext;

	@Autowired
	SharedDataWsClient sharedDataWsClient;

	@Autowired
	@Qualifier("sharedDataWsClient.axiom")
	private WebServiceTemplate axiomWebServiceTemplate;

	private MockWebServiceServer mockSoapServer;

	@Before
	public void before() {
		// assertNotNull("FAIL applicationContext cannot be null.", applicationContext);
		assertNotNull("FAIL sharedDataWsClient cannot be null.", sharedDataWsClient);
		assertNotNull("FAIL axiomWebServiceTemplate cannot be null.", axiomWebServiceTemplate);

		mockSoapServer = MockWebServiceServer.createServer(axiomWebServiceTemplate);
	}

	@Test
	public void test() {
		//TODO fix requestPayload and responsePayload ... current strings are invalid
		final Source requestPayload = new StringSource("*** THIS STRING IS NOT VALID - FIX IT >>> "
				+ "<customerCountRequest xmlns='http://springframework.org/spring-ws'>"
				+ "<customerName>John Doe</customerName>"
				+ "</customerCountRequest>");
		final Source responsePayload = new StringSource("*** THIS STRING IS NOT VALID - FIX IT >>> "
				+ "<customerCountResponse xmlns='http://springframework.org/spring-ws'>"
				+ "<customerCount>10</customerCount>"
				+ "</customerCountResponse>");

		mockSoapServer.expect(payload(requestPayload)).andRespond(withPayload(responsePayload));

		final FindCountriesResponse result = sharedDataWsClient.findCountries(new FindCountries());
		assertNotNull(result);
		//		assertEquals(10, result);

		mockSoapServer.verify();
	}

	/**
	 * Commenting everything to try an approach that will work on this platform //
	 * private Validator validator;
	 *
	 * / ** The address validate ws client. * /
	 *
	 * @Autowired SharedDataWsClient sharedDataWsClient;
	 *
	 *            / ** The Constant SHAREDDATA_OBJECT_FACTORY. * / protected static
	 *            final ObjectFactory SHAREDDATA_OBJECT_FACTORY = new
	 *            ObjectFactory();
	 *
	 * @Before public void before() { assertNotNull(sharedDataWsClient); //
	 *         ValidatorFactory vf = Validation.buildDefaultValidatorFactory(); //
	 *         this.validator = vf.getValidator(); }
	 *
	 *         / ** Test find all stations. /
	 * @Test public void testFindAllStations() { assertTrue(true); // TODO test
	 *       call/response }
	 *
	 *       // TODO test remaining elements
	 */
}
