package gov.va.vetservices.partner.shareddata.ws.client;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStationAddress;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.ObjectFactory;

public class AbstractSharedDataTest {

	/**
	 * Make a station address request object with the specified station number.
	 *
	 * @param stationNbr the station number
	 * @return FindStationAddress
	 */
	protected FindStationAddress makeFindStationAddressRequest(final String stationNbr) {
		ObjectFactory of = new ObjectFactory();
		final FindStationAddress request = of.createFindStationAddress(); // new FindStationAddress();
		request.setStationNumber(stationNbr);
		return request;
	}

	@Test
	public void testInterface() {
		assertTrue(SharedDataWsClient.class.isInterface());
	}

}
