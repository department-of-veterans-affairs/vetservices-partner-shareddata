package gov.va.vetservices.partner.shareddata.ws.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class SharedDataWsClientExceptionTest {

	private SharedDataWsClientException testException;

	private static final String TEST_MESSAGE = "This is a test error message";
	private static NullPointerException TEST_CAUSE = new NullPointerException();

	@Test
	public void testSharedDataWsClientException() {
		testException = new SharedDataWsClientException();
		assertNotNull(testException);
	}

	@Test
	public void testSharedDataWsClientExceptionStringThrowable() {
		testException = new SharedDataWsClientException(TEST_MESSAGE, TEST_CAUSE);
		assertEquals(TEST_MESSAGE, testException.getMessage());
		assertEquals(TEST_CAUSE, testException.getCause());
	}

	@Test
	public void testSharedDataWsClientExceptionString() {
		testException = new SharedDataWsClientException(TEST_MESSAGE);
		assertEquals(TEST_MESSAGE, testException.getMessage());
	}

	@Test
	public void testSharedDataWsClientExceptionThrowable() {
		testException = new SharedDataWsClientException(TEST_CAUSE);
		assertEquals(TEST_CAUSE, testException.getCause());
	}

}
