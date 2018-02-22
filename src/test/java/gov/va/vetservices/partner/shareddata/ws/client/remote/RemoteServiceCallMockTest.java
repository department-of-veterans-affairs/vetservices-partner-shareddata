package gov.va.vetservices.partner.shareddata.ws.client.remote;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gov.va.vetservices.partner.shareddata.ws.client.AbstractSharedDataTest;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStationAddress;

public class RemoteServiceCallMockTest extends AbstractSharedDataTest {

	private final static String TEST_VALID_STN_NBR = "301";

	private SharedDataRemoteServiceCallMock mock;

	@Test
	public void testGetKeyForMockResponse() {
		mock = new SharedDataRemoteServiceCallMock();
		FindStationAddress request = super.makeFindStationAddressRequest(TEST_VALID_STN_NBR);
		String keyForMockResponse = mock.getKeyForMockResponse(request);

		assertNotNull(keyForMockResponse);
		assertTrue(keyForMockResponse.equals(SharedDataRemoteServiceCallMock.FIND_ADDRESS_PREFACE + TEST_VALID_STN_NBR));
	}

	@Test
	public void testGetKeyForMockResponse_NullRequest() {
		mock = new SharedDataRemoteServiceCallMock();
		FindStationAddress request = super.makeFindStationAddressRequest(null);

		String keyForMockResponse = null;

		try {
			keyForMockResponse = mock.getKeyForMockResponse(request);
		} catch (Throwable e) {
			e.printStackTrace();
			assertTrue("Correct excepetion was thrown.", IllegalArgumentException.class.equals(e.getClass()));
			assertTrue("Exception message contains correct string.", e.getMessage()
					.equals("[Assertion failed] - this String argument must have text; it must not be null, empty, or blank"));
		}

		assertNull("Null request should have thrown exception.", keyForMockResponse);
	}

}
