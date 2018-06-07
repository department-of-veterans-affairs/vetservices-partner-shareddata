package gov.va.vetservices.partner.shareddata.ws.client.remote;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gov.va.vetservices.partner.shareddata.ws.client.AbstractSharedDataTest;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStationAddress;

public class RemoteServiceCallMockTest extends AbstractSharedDataTest {

	private final static String TEST_VALID_STN_NBR = "301";

	@Test
	public void testGetKeyForMockResponse() {
		SharedDataRemoteServiceCallMock mock = new SharedDataRemoteServiceCallMock();
		FindStationAddress request = super.makeFindStationAddressRequest(TEST_VALID_STN_NBR);
		String keyForMockResponse = mock.getKeyForMockResponse(request);

		assertNotNull(keyForMockResponse);
		assertTrue(keyForMockResponse.equals(SharedDataRemoteServiceCallMock.FIND_ADDRESS_PREFACE + TEST_VALID_STN_NBR));
	}

	@Test
	public void testGetKeyForMockResponse_NullRequest() {
		SharedDataRemoteServiceCallMock mock = new SharedDataRemoteServiceCallMock();
		FindStationAddress request = null;

		String keyForMockResponse = null;

		try {
			keyForMockResponse = mock.getKeyForMockResponse(request);
		} catch (Throwable e) {
			assertTrue("Invalid excepetion was thrown.", IllegalArgumentException.class.equals(e.getClass()));
			assertTrue("Exception message contains wrong string.",
					e.getMessage().equals(SharedDataRemoteServiceCallMock.ERROR_NULL_REQUEST));
		}

		assertNull("Null request should have thrown exception.", keyForMockResponse);
	}

}
