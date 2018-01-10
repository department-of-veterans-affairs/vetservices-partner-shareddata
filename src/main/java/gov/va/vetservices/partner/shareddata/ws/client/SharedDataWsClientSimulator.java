package gov.va.vetservices.partner.shareddata.ws.client;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import gov.va.ascent.framework.config.AscentCommonSpringProfiles;
import gov.va.ascent.framework.ws.client.BaseWsClientSimulator;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindCountries;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindCountriesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindIntakeSites;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindIntakeSitesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStates;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStatesResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStationAddress;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.FindStationAddressResponse;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.ShrlistsRecord;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.Station;
import gov.va.vetservices.partner.shareddata.ws.client.transfer.Type;

/**
 * This class implements a Simulator for the SharedData WS Client.
 *
 * @author StuartT
 */
@Component(SharedDataWsClientSimulator.BEAN_NAME)
@Profile({ AscentCommonSpringProfiles.PROFILE_REMOTE_CLIENT_SIMULATORS,
	SharedDataWsClient.PROFILE_SHAREDDATAWSCLIENT_REMOTE_CLIENT_SIM })
public class SharedDataWsClientSimulator extends BaseWsClientSimulator implements SharedDataWsClient {

	/**
	 * The Constant BEAN_NAME.
	 */
	public static final String BEAN_NAME = "sharedDataWsClientSimulator";

	/**
	 * The Constant LOGGER.
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(SharedDataWsClientSimulator.class);

	/** number of intake sites */
	private static final int NUM_INTAKE_SITES = 21;

	/** The Constant INTAKE_SITE_CODE_PREFIX. */
	protected static final String INTAKE_SITE_CODE_PREFIX = "00";

	/** The Constant INTAKE_SITE_NAME_DESC_PREFIX. */
	protected static final String INTAKE_SITE_NAME_DESC_PREFIX = "Intake 00";

	/** The Constant INTAKE_SITE_DESC_POSTFIX */
	protected static final String INTAKE_SITE_DESC_POSTFIX = " - Desc";

	/** The Constant INTAKE_SITE_NAME_POSTFIX */
	protected static final String INTAKE_SITE_NAME_POSTFIX = " - Name";

	/**
	 * Post construct.
	 */
	@PostConstruct
	public final void postConstruct() {
		LOGGER.warn("Using SIMULATOR as implementation for SharedDataWsClient Interface.");
	}

	@Override
	public FindStationAddressResponse findStationAddress(
			final FindStationAddress findStationAddressRequest) {

		final FindStationAddressResponse response = new FindStationAddressResponse();
		final Station station = new Station();
		station.setAddressLine1("Regional Office");
		station.setAddressLine2("Chavez Fed. Bldg.& US Court House");
		station.setAddressLine3("500 Gold Avenue, S.W.");
		station.setCity("Albuquerque");
		station.setState("NM");
		station.setZipCode("87102");
		station.setReturnCode("SHAR00000");
		response.setReturn(station);
		return response;
	}

	@Override
	public FindCountriesResponse findCountries(
			final FindCountries request) {

		final FindCountriesResponse response = new FindCountriesResponse();
		final ShrlistsRecord shrlistsRecord = new ShrlistsRecord();
		addRecord(shrlistsRecord, "942", "Albania");
		addRecord(shrlistsRecord, "952", "Algeria");
		addRecord(shrlistsRecord, "893", "Angola");
		addRecord(shrlistsRecord, "816", "Anguilla");
		addRecord(shrlistsRecord, "816", "Antigua");
		addRecord(shrlistsRecord, "816", "Antigua and Barbuda");
		addRecord(shrlistsRecord, "858", "Argentina");
		addRecord(shrlistsRecord, "711", "Armenia");
		addRecord(shrlistsRecord, "708", "Australia");
		addRecord(shrlistsRecord, "972", "Austria");
		addRecord(shrlistsRecord, "716", "Azerbaijan");
		addRecord(shrlistsRecord, "715", "Azores");
		addRecord(shrlistsRecord, "808", "Bahamas");
		addRecord(shrlistsRecord, "832", "Bahrain");
		addRecord(shrlistsRecord, "865", "Bangladesh");
		addRecord(shrlistsRecord, "818", "Barbados");
		addRecord(shrlistsRecord, "816", "Barbuda");
		addRecord(shrlistsRecord, "727", "Belarus");
		addRecord(shrlistsRecord, "748", "Belgium");
		addRecord(shrlistsRecord, "992", "Belize");
		addRecord(shrlistsRecord, "692", "Benin");
		addRecord(shrlistsRecord, "828", "Bermuda");
		addRecord(shrlistsRecord, "862", "Bhutan");
		addRecord(shrlistsRecord, "913", "Bolivia");
		addRecord(shrlistsRecord, "817", "Bosnia-Herzegovina");
		addRecord(shrlistsRecord, "663", "Botswana");
		addRecord(shrlistsRecord, "706", "Brazil");
		addRecord(shrlistsRecord, "820", "Brunei");
		addRecord(shrlistsRecord, "903", "Bulgaria");
		addRecord(shrlistsRecord, "689", "Burkina Faso");
		addRecord(shrlistsRecord, "923", "Burma");
		addRecord(shrlistsRecord, "683", "Burundi");
		addRecord(shrlistsRecord, "981", "Cambodia");
		addRecord(shrlistsRecord, "943", "Cameroon");
		addRecord(shrlistsRecord, "953", "Canada");
		addRecord(shrlistsRecord, "710", "Cape Verde");
		addRecord(shrlistsRecord, "838", "Cayman Islands");
		addRecord(shrlistsRecord, "690", "Central African Republic");
		addRecord(shrlistsRecord, "691", "Chad");
		addRecord(shrlistsRecord, "768", "Chile");
		addRecord(shrlistsRecord, "973", "China");
		addRecord(shrlistsRecord, "757", "Colombia");
		addRecord(shrlistsRecord, "876", "Comoros");
		addRecord(shrlistsRecord, "719", "Congo, Democratic Republic of");
		addRecord(shrlistsRecord, "670", "Congo, People's Republic of");
		addRecord(shrlistsRecord, "983", "Costa Rica");
		addRecord(shrlistsRecord, "819", "Cote d'Ivoire");
		addRecord(shrlistsRecord, "651", "Croatia");
		addRecord(shrlistsRecord, "737", "Cuba");
		addRecord(shrlistsRecord, "904", "Cyprus");
		addRecord(shrlistsRecord, "914", "Czech Republic");
		addRecord(shrlistsRecord, "924", "Denmark");
		addRecord(shrlistsRecord, "799", "Djibouti");
		addRecord(shrlistsRecord, "811", "Dominica");
		addRecord(shrlistsRecord, "934", "Dominican Republic");
		addRecord(shrlistsRecord, "729", "Ecuador");
		addRecord(shrlistsRecord, "759", "Egypt");
		addRecord(shrlistsRecord, "958", "El Salvador");
		addRecord(shrlistsRecord, "800", "England");
		addRecord(shrlistsRecord, "898", "Equatorial Guinea");
		addRecord(shrlistsRecord, "760", "Eritrea");
		addRecord(shrlistsRecord, "995", "Estonia");
		addRecord(shrlistsRecord, "779", "Ethiopia");
		addRecord(shrlistsRecord, "809", "Fiji");
		addRecord(shrlistsRecord, "964", "Finland");
		addRecord(shrlistsRecord, "912", "France");
		addRecord(shrlistsRecord, "888", "French Guiana");
		addRecord(shrlistsRecord, "693", "Gabon");
		addRecord(shrlistsRecord, "698", "Gambia");
		addRecord(shrlistsRecord, "730", "Georgia");
		addRecord(shrlistsRecord, "732", "Germany");
		addRecord(shrlistsRecord, "984", "Ghana");
		addRecord(shrlistsRecord, "800", "Gibraltar");
		addRecord(shrlistsRecord, "800", "Great Britain");
		addRecord(shrlistsRecord, "800", "Great Britain and Gibraltar");
		addRecord(shrlistsRecord, "701", "Greece");
		addRecord(shrlistsRecord, "924", "Greenland");
		addRecord(shrlistsRecord, "813", "Grenada");
		addRecord(shrlistsRecord, "881", "Guadeloupe");
		addRecord(shrlistsRecord, "915", "Guatemala");
		addRecord(shrlistsRecord, "928", "Guinea");
		addRecord(shrlistsRecord, "928", "Guinea, Republic of Guinea");
		addRecord(shrlistsRecord, "910", "Guinea-Bissau");
		addRecord(shrlistsRecord, "894", "Guyana");
		addRecord(shrlistsRecord, "925", "Haiti");
		addRecord(shrlistsRecord, "822", "Honduras");
		addRecord(shrlistsRecord, "945", "Hong Kong");
		addRecord(shrlistsRecord, "955", "Hungary");
		addRecord(shrlistsRecord, "965", "Iceland");
		addRecord(shrlistsRecord, "862", "India");
		addRecord(shrlistsRecord, "975", "Indonesia");
		addRecord(shrlistsRecord, "833", "Iran");
		addRecord(shrlistsRecord, "803", "Iraq");
		addRecord(shrlistsRecord, "900", "Ireland");
		addRecord(shrlistsRecord, "977", "Israel (Jerusalem)");
		addRecord(shrlistsRecord, "873", "Israel (Tel Aviv)");
		addRecord(shrlistsRecord, "700", "Italy");
		addRecord(shrlistsRecord, "838", "Jamaica");
		addRecord(shrlistsRecord, "713", "Japan");
		addRecord(shrlistsRecord, "985", "Jordan");
		addRecord(shrlistsRecord, "740", "Kazakhstan");
		addRecord(shrlistsRecord, "869", "Kenya");
		addRecord(shrlistsRecord, "921", "Kosovo");
		addRecord(shrlistsRecord, "926", "Kuwait");
		addRecord(shrlistsRecord, "750", "Kyrgyzstan");
		addRecord(shrlistsRecord, "936", "Laos");
		addRecord(shrlistsRecord, "991", "Latvia");
		addRecord(shrlistsRecord, "956", "Lebanon");
		addRecord(shrlistsRecord, "816", "Leeward Islands");
		addRecord(shrlistsRecord, "866", "Lesotho");
		addRecord(shrlistsRecord, "966", "Liberia");
		addRecord(shrlistsRecord, "804", "Libya");
		addRecord(shrlistsRecord, "886", "Liechtenstein");
		addRecord(shrlistsRecord, "993", "Lithuania");
		addRecord(shrlistsRecord, "986", "Luxembourg");
		addRecord(shrlistsRecord, "945", "Macao");
		addRecord(shrlistsRecord, "856", "Macedonia");
		addRecord(shrlistsRecord, "892", "Madagascar");
		addRecord(shrlistsRecord, "650", "Malawi");
		addRecord(shrlistsRecord, "824", "Malaysia");
		addRecord(shrlistsRecord, "694", "Mali");
		addRecord(shrlistsRecord, "907", "Malta");
		addRecord(shrlistsRecord, "878", "Martinique");
		addRecord(shrlistsRecord, "666", "Mauritania");
		addRecord(shrlistsRecord, "897", "Mauritius");
		addRecord(shrlistsRecord, "773", "Mexico");
		addRecord(shrlistsRecord, "770", "Moldavia");
		addRecord(shrlistsRecord, "927", "Mongolia");
		addRecord(shrlistsRecord, "920", "Montenegro");
		addRecord(shrlistsRecord, "816", "Montserrat");
		addRecord(shrlistsRecord, "854", "Morocco");
		addRecord(shrlistsRecord, "882", "Mozambique");
		addRecord(shrlistsRecord, "880", "Namibia");
		addRecord(shrlistsRecord, "872", "Nepal");
		addRecord(shrlistsRecord, "874", "Netherlands");
		addRecord(shrlistsRecord, "825", "Netherlands Antilles");
		addRecord(shrlistsRecord, "816", "Nevis");
		addRecord(shrlistsRecord, "809", "New Caledonia");
		addRecord(shrlistsRecord, "875", "New Zealand");
		addRecord(shrlistsRecord, "957", "Nicaragua");
		addRecord(shrlistsRecord, "682", "Niger");
		addRecord(shrlistsRecord, "967", "Nigeria");
		addRecord(shrlistsRecord, "906", "North Korea");
		addRecord(shrlistsRecord, "800", "Northern Ireland");
		addRecord(shrlistsRecord, "703", "Norway");
		addRecord(shrlistsRecord, "834", "Oman");
		addRecord(shrlistsRecord, "835", "Pakistan");
		addRecord(shrlistsRecord, "806", "Panama");
		addRecord(shrlistsRecord, "947", "Papua New Guinea");
		addRecord(shrlistsRecord, "987", "Paraguay");
		addRecord(shrlistsRecord, "997", "Peru");
		addRecord(shrlistsRecord, "600", "Philippines");
		addRecord(shrlistsRecord, "601", "Philippines (restricted payments)");
		addRecord(shrlistsRecord, "908", "Poland");
		addRecord(shrlistsRecord, "705", "Portugal");
		addRecord(shrlistsRecord, "917", "Qatar");
		addRecord(shrlistsRecord, "849", "Republic of Yemen");
		addRecord(shrlistsRecord, "938", "Romania");
		addRecord(shrlistsRecord, "978", "Russia");
		addRecord(shrlistsRecord, "669", "Rwanda");
		addRecord(shrlistsRecord, "890", "Sao-Tome/Principe");
		addRecord(shrlistsRecord, "836", "Saudi Arabia");
		addRecord(shrlistsRecord, "800", "Scotland");
		addRecord(shrlistsRecord, "889", "Senegal");
		addRecord(shrlistsRecord, "902", "Serbia");
		addRecord(shrlistsRecord, "902", "Serbia/Montenegro");
		addRecord(shrlistsRecord, "870", "Seychelles");
		addRecord(shrlistsRecord, "695", "Sicily");
		addRecord(shrlistsRecord, "859", "Sierra Leone");
		addRecord(shrlistsRecord, "968", "Singapore");
		addRecord(shrlistsRecord, "720", "Slovakia");
		addRecord(shrlistsRecord, "840", "Slovenia");
		addRecord(shrlistsRecord, "998", "Somalia");
		addRecord(shrlistsRecord, "887", "South Africa");
		addRecord(shrlistsRecord, "916", "South Korea");
		addRecord(shrlistsRecord, "745", "Spain");
		addRecord(shrlistsRecord, "963", "Sri Lanka");
		addRecord(shrlistsRecord, "816", "St. Kitts");
		addRecord(shrlistsRecord, "810", "St. Lucia");
		addRecord(shrlistsRecord, "812", "St. Vincent");
		addRecord(shrlistsRecord, "988", "Sudan");
		addRecord(shrlistsRecord, "909", "Suriname");
		addRecord(shrlistsRecord, "660", "Swaziland");
		addRecord(shrlistsRecord, "782", "Sweden");
		addRecord(shrlistsRecord, "846", "Switzerland");
		addRecord(shrlistsRecord, "807", "Syria");
		addRecord(shrlistsRecord, "919", "Taiwan");
		addRecord(shrlistsRecord, "784", "Tajikistan");
		addRecord(shrlistsRecord, "697", "Tanzania");
		addRecord(shrlistsRecord, "929", "Thailand");
		addRecord(shrlistsRecord, "805", "Togo");
		addRecord(shrlistsRecord, "848", "Trinidad and Tobago");
		addRecord(shrlistsRecord, "949", "Tunisia");
		addRecord(shrlistsRecord, "857", "Turkey (Adana only)");
		addRecord(shrlistsRecord, "847", "Turkey (except Adana)");
		addRecord(shrlistsRecord, "790", "Turkmenistan");
		addRecord(shrlistsRecord, "000", "USA");
		addRecord(shrlistsRecord, "969", "Uganda");
		addRecord(shrlistsRecord, "801", "Ukraine");
		addRecord(shrlistsRecord, "837", "United Arab Emirates");
		addRecord(shrlistsRecord, "800", "United Kingdom");
		addRecord(shrlistsRecord, "979", "Uruguay");
		addRecord(shrlistsRecord, "731", "Uzbekistan");
		addRecord(shrlistsRecord, "809", "Vanuatu");
		addRecord(shrlistsRecord, "707", "Venezuela");
		addRecord(shrlistsRecord, "962", "Vietnam");
		addRecord(shrlistsRecord, "800", "Wales");
		addRecord(shrlistsRecord, "815", "Western Samoa");
		addRecord(shrlistsRecord, "849", "Yemen Arab Republic");
		addRecord(shrlistsRecord, "662", "Zambia");
		addRecord(shrlistsRecord, "918", "Zimbabwe");
		response.setReturn(shrlistsRecord);
		response.getReturn().setNumberOfRecords("211");
		return response;
	}

	@Override
	public FindIntakeSitesResponse findIntakeSites(
			final FindIntakeSites findIntakeSites) {

		final FindIntakeSitesResponse intakeSitesResponse = new FindIntakeSitesResponse();
		final ShrlistsRecord value = new ShrlistsRecord();
		intakeSitesResponse.setReturn(value);
		value.getTypes().addAll(createIntakeTypeList());
		value.setNumberOfRecords(String.valueOf(NUM_INTAKE_SITES));
		return intakeSitesResponse;
	}

	@Override
	public FindStatesResponse findStates(
			final FindStates request) {

		final FindStatesResponse response = new FindStatesResponse();
		final ShrlistsRecord shrlistsRecord = new ShrlistsRecord();
		addRecord(shrlistsRecord, "AL",	"Alabama");
		addRecord(shrlistsRecord, "AK",	"Alaska");
		addRecord(shrlistsRecord, "AB",	"Alberta");
		addRecord(shrlistsRecord, "AS",	"American Samoa");
		addRecord(shrlistsRecord, "AZ",	"Arizona");
		addRecord(shrlistsRecord, "AR",	"Arkansas");
		addRecord(shrlistsRecord, "AE",	"Armed Forces (AE)");
		addRecord(shrlistsRecord, "AA",	"Armed Forces Americas");
		addRecord(shrlistsRecord, "AP",	"Armed Forces Pacific");
		addRecord(shrlistsRecord, "BC",	"British Columbia");
		addRecord(shrlistsRecord, "CA",	"California");
		addRecord(shrlistsRecord, "CO",	"Colorado");
		addRecord(shrlistsRecord, "CT",	"Connecticut");
		addRecord(shrlistsRecord, "DE",	"Delaware");
		addRecord(shrlistsRecord, "DC",	"District Of Columbia");
		addRecord(shrlistsRecord, "FL",	"Florida");
		addRecord(shrlistsRecord, "GA",	"Georgia");
		addRecord(shrlistsRecord, "GU",	"Guam");
		addRecord(shrlistsRecord, "HI",	"Hawaii");
		addRecord(shrlistsRecord, "ID",	"Idaho");
		addRecord(shrlistsRecord, "IL",	"Illinois");
		addRecord(shrlistsRecord, "IA",	"Iowa");
		addRecord(shrlistsRecord, "KS",	"Kansas");
		addRecord(shrlistsRecord, "KY",	"Kentucky");
		addRecord(shrlistsRecord, "LA",	"Louisiana");
		addRecord(shrlistsRecord, "ME",	"Maine");
		addRecord(shrlistsRecord, "MB",	"Manitoba");
		addRecord(shrlistsRecord, "MD",	"Maryland");
		addRecord(shrlistsRecord, "MA",	"Massachusetts");
		addRecord(shrlistsRecord, "MI",	"Michigan");
		addRecord(shrlistsRecord, "MN",	"Minnesota");
		addRecord(shrlistsRecord, "MS",	"Mississippi");
		addRecord(shrlistsRecord, "MO",	"Missouri");
		addRecord(shrlistsRecord, "MT",	"Montana");
		addRecord(shrlistsRecord, "NE",	"Nebraska");
		addRecord(shrlistsRecord, "NV",	"Nevada");
		addRecord(shrlistsRecord, "NB",	"New Brunswick");
		addRecord(shrlistsRecord, "NH",	"New Hampshire");
		addRecord(shrlistsRecord, "NJ",	"New Jersey");
		addRecord(shrlistsRecord, "NM",	"New Mexico");
		addRecord(shrlistsRecord, "NY",	"New York");
		addRecord(shrlistsRecord, "NF",	"Newfoundland");
		addRecord(shrlistsRecord, "NC",	"North Carolina");
		addRecord(shrlistsRecord, "ND",	"North Dakota");
		addRecord(shrlistsRecord, "NT",	"Northwest Territories");
		addRecord(shrlistsRecord, "NS",	"Nova Scotia");
		addRecord(shrlistsRecord, "NU",	"Nunavut");
		addRecord(shrlistsRecord, "OH",	"Ohio");
		addRecord(shrlistsRecord, "OK",	"Oklahoma");
		addRecord(shrlistsRecord, "ON",	"Ontario");
		addRecord(shrlistsRecord, "OR",	"Oregon");
		addRecord(shrlistsRecord, "PA",	"Pennsylvania");
		addRecord(shrlistsRecord, "PE",	"Prince Edward Island");
		addRecord(shrlistsRecord, "PR",	"Puerto Rico");
		addRecord(shrlistsRecord, "QC",	"Quebec");
		addRecord(shrlistsRecord, "RI",	"Rhode Island");
		addRecord(shrlistsRecord, "SK",	"Saskatchewan");
		addRecord(shrlistsRecord, "SC",	"South Carolina");
		addRecord(shrlistsRecord, "SD",	"South Dakota");
		addRecord(shrlistsRecord, "TN",	"Tennessee");
		addRecord(shrlistsRecord, "TX",	"Texas");
		addRecord(shrlistsRecord, "UT",	"Utah");
		addRecord(shrlistsRecord, "VT",	"Vermont");
		addRecord(shrlistsRecord, "VI",	"Virgin Islands");
		addRecord(shrlistsRecord, "VA",	"Virginia");
		addRecord(shrlistsRecord, "WA",	"Washington");
		addRecord(shrlistsRecord, "WV",	"West Virginia");
		addRecord(shrlistsRecord, "WI",	"Wisconsin");
		addRecord(shrlistsRecord, "WY",	"Wyoming");
		addRecord(shrlistsRecord, "YT",	"Yukon Territory");

		response.setReturn(shrlistsRecord);
		response.getReturn().setNumberOfRecords("70");
		return response;
	}

	private void addRecord(final ShrlistsRecord shrlistsRecord, final String code, final String name) {
		final Type type = new Type();
		type.setCode(code);
		type.setName(name);
		shrlistsRecord.getTypes().add(type);
	}

	/**
	 * Creates the list of Intake Sites
	 *
	 * @return List of Intake Types
	 */
	protected final List<Type> createIntakeTypeList() {
		final List<Type> types = new ArrayList<Type>();
		Type lookupType;
		for (int i = 1; i < (NUM_INTAKE_SITES + 1); i++) {
			lookupType = new Type();
			lookupType.setCode(INTAKE_SITE_CODE_PREFIX + i);
			lookupType.setDescription(INTAKE_SITE_NAME_DESC_PREFIX + i + INTAKE_SITE_DESC_POSTFIX);
			lookupType.setName(INTAKE_SITE_NAME_DESC_PREFIX + i + INTAKE_SITE_NAME_POSTFIX);
			types.add(lookupType);
		}
		return types;
	}

}
