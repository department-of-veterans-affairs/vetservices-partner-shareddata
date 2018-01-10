package gov.va.vetservices.partner.shareddate.ws.client;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import gov.va.ascent.framework.config.AscentCommonSpringProfiles;
import gov.va.vetservices.partner.mock.framework.PartnerMockFrameworkTestConfig;
import gov.va.vetservices.partner.shareddata.ws.client.SharedDataWsClient;
import gov.va.vetservices.partner.shareddata.ws.client.SharedDataWsClientConfig;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.ObjectFactory;

/**
 * Unit test of PersonWsClientImpl.
 */
// ignored for now as its integration test and requires SOAP UI to be running
@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles({ AscentCommonSpringProfiles.PROFILE_ENV_LOCAL_INT,
	AscentCommonSpringProfiles.PROFILE_REMOTE_CLIENT_IMPLS })
@ContextConfiguration(inheritLocations = false, classes = { SharedDataWsClientConfig.class,
		PartnerMockFrameworkTestConfig.class })
public class SharedDataWsClientImpl_UnitTest {

	// private Validator validator;

	/** The address validate ws client. */
	@Autowired
	SharedDataWsClient sharedDataWsClient;

	/** The Constant SHAREDDATA_OBJECT_FACTORY. */
	protected static final ObjectFactory SHAREDDATA_OBJECT_FACTORY = new ObjectFactory();

	@Before
	public void before() {
		assertNotNull(sharedDataWsClient);
		// ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		// this.validator = vf.getValidator();
	}

	/**
	 * Test find all stations.
	 */
	@Test
	public void testFindAllStations() {
		assertTrue(true);
		// TODO test call/response
	}

	// TODO test remaining elements

}
