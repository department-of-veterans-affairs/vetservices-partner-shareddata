package gov.va.vetservices.partner.shareddata.ws.client;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;

import gov.va.ascent.framework.exception.InterceptingExceptionTranslator;
import gov.va.ascent.framework.log.PerformanceLogMethodInterceptor;
import gov.va.ascent.framework.ws.client.BaseWsClientConfig;
import gov.va.ascent.framework.ws.client.WsClientSimulatorMarshallingInterceptor;

/**
 * This class represents the Spring configuration for the SharedData Web Service
 * Client.
 */
@Configuration
@ComponentScan(basePackages = { "gov.va.vetservices.partner.shareddata.ws.client" }, excludeFilters = @Filter(Configuration.class))
@SuppressWarnings("PMD.ExcessiveImports")
public class SharedDataWsClientConfig extends BaseWsClientConfig {

	/** The Constant TRANSFER_PACKAGE. */
	private static final String TRANSFER_PACKAGE = "gov.va.vetservices.partner.shareddata.ws.client.transfer";

	/** the XSD for this web service */
	private static final String XSD = "xsd/ShareStandardDataWebService.xsd";

	// ####### values are from /resource/config/*.properties ######
	/** The username. */
	@Value("${vetservices-partner-shareddata.ws.client.username}")
	private String bgsUsername;

	/** The password. */
	@Value("${vetservices-partner-shareddata.ws.client.password}")
	private String bgsPassword;

	/** The va application name. */
	@Value("${vetservices-partner-shareddata.ws.client.vaApplicationName}")
	private String bgsVaApplicationName;

	/** VA STN_ID value */
	@Value("${vetservices-partner-shareddata.ws.client.stationId}")
	private String bgsStationId;

	/**
	 * decides if jaxb validation logs errors.
	 */
	// annotation causes failure because apparently true is not a boolean value:
	private final boolean logValidation = true;

	/**
	 * WS Client object marshaller
	 *
	 * @return object marshaller
	 */
	// Ignoring DesignForExtension check, we cannot make this spring bean method
	// private or final
	// CHECKSTYLE:OFF
	@Bean
	Jaxb2Marshaller sharedDataMarshaller() {
		// CHECKSTYLE:ON
		final Resource[] schemas = new Resource[] { new ClassPathResource(XSD) };
		return getMarshaller(TRANSFER_PACKAGE, schemas, logValidation);
	}

	/**
	 * Axiom based WebServiceTemplate for the Chapter 31 Case Web Service Client.
	 *
	 * @param endpoint
	 *            the endpoint
	 * @param readTimeout
	 *            the read timeout
	 * @param connectionTimeout
	 *            the connection timeout
	 * @return the web service template
	 * @throws KeyManagementException
	 *             the key management exception
	 * @throws UnrecoverableKeyException
	 *             the unrecoverable key exception
	 * @throws NoSuchAlgorithmException
	 *             the no such algorithm exception
	 * @throws KeyStoreException
	 *             the key store exception
	 * @throws CertificateException
	 *             the certificate exception
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	// Ignoring DesignForExtension check, we cannot make this spring bean method
	// private or final
	// CHECKSTYLE:OFF
	@Bean
	@Qualifier("sharedDataWsClient.axiom")
	WebServiceTemplate sharedDataWsClientAxiomTemplate(
			// CHECKSTYLE:ON
			@Value("${vetservices-partner-shareddata.ws.client.endpoint}") final String endpoint,
			@Value("${vetservices-partner-shareddata.ws.client.readTimeout:60000}") final int readTimeout,
			@Value("${vetservices-partner-shareddata.ws.client.connectionTimeout:60000}") final int connectionTimeout)
			throws KeyManagementException, UnrecoverableKeyException, NoSuchAlgorithmException, KeyStoreException,
			CertificateException, IOException {

		return createDefaultWebServiceTemplate(endpoint, readTimeout, connectionTimeout, sharedDataMarshaller(),
				sharedDataMarshaller(), new ClientInterceptor[] { sharedDataSecurityInterceptor() });
	}

	/**
	 * Security interceptor to apply wss4j security to Chapter31 Case WS calls.
	 *
	 * @return security interceptor
	 */
	// jluck - ignoring DesignForExtension check, we cannot make this spring
	// bean method private or final
	// CHECKSTYLE:OFF
	@Bean
	Wss4jSecurityInterceptor sharedDataSecurityInterceptor() {
		// CHECKSTYLE:ON
		return getVAServiceWss4jSecurityInterceptor(bgsUsername, bgsPassword, bgsVaApplicationName, bgsStationId);
	}

	/**
	 * PerformanceLogMethodInterceptor for the Chapter31 Case Web Service Client
	 *
	 * Handles performance related logging of the web service client response times.
	 *
	 * @param methodWarningThreshhold
	 *            the method warning threshold
	 * @return the performance log method interceptor
	 */
	// Ignoring DesignForExtension check, we cannot make this spring bean method
	// private or final
	// CHECKSTYLE:OFF
	@Bean
	PerformanceLogMethodInterceptor sharedDataWsClientPerformanceLogMethodInterceptor(
			@Value("${vetservices-partner-shareddata.ws.client.methodWarningThreshhold:2500}") final Integer methodWarningThreshhold) {
		// CHECKSTYLE:ON
		return getPerformanceLogMethodInterceptor(methodWarningThreshhold);
	}

	/**
	 * InterceptingExceptionTranslator for the Chapter 31 Case Web Service Client
	 *
	 * Handles runtime exceptions raised by the web service client through runtime
	 * operation and communication with the remote service.
	 *
	 * @return the intercepting exception translator
	 * @throws ClassNotFoundException
	 *             the class not found exception
	 */
	// Ignoring DesignForExtension check, we cannot make this spring bean method
	// private or final
	// CHECKSTYLE:OFF
	@Bean
	InterceptingExceptionTranslator sharedDataWsClientExceptionInterceptor() throws ClassNotFoundException {
		// CHECKSTYLE:ON
		return getInterceptingExceptionTranslator("gov.va.vetservices.partner.shareddata.ws.client.SharedDataWsClientException",
				PACKAGE_WSS_FOUNDATION_EXCEPTION);
	}

	/**
	 * A standard bean proxy to apply interceptors to the web service client.
	 *
	 * @return the bean name auto proxy creator
	 */
	// Ignoring DesignForExtension check, we cannot make this spring bean method
	// private or final
	// CHECKSTYLE:OFF
	@Bean
	BeanNameAutoProxyCreator sharedDataWsClientBeanProxy() {
		// CHECKSTYLE:ON
		return getBeanNameAutoProxyCreator(new String[] { SharedDataWsClientImpl.BEAN_NAME, SharedDataWsClientSimulator.BEAN_NAME },
				new String[] { "sharedDataWsClientExceptionInterceptor", "sharedDataWsClientPerformanceLogMethodInterceptor" });
	}

	/**
	 * Ws client simulator marshalling interceptor, so that requests and responses
	 * to the simulator are passed through the marshaller to ensure we don't have
	 * any Java-to-XML conversion surprises if we leverage simulators heavily in
	 * development and then start using real web services later on.
	 *
	 * @return the ws client simulator marshalling interceptor
	 */
	// Ignoring DesignForExtension check, we cannot make this spring bean method
	// private or final
	// CHECKSTYLE:OFF
	@Bean
	WsClientSimulatorMarshallingInterceptor sharedDataWsClientSimulatorMarshallingInterceptor() {
		// CHECKSTYLE:ON
		final Map<String, Jaxb2Marshaller> marshallerForPackageMap = new HashMap<>();
		marshallerForPackageMap.put(TRANSFER_PACKAGE, sharedDataMarshaller());
		return new WsClientSimulatorMarshallingInterceptor(marshallerForPackageMap);
	}

	/**
	 * A standard bean proxy to apply interceptors to the web service client
	 * simulations that we don't need/want to apply to real web service client
	 * impls.
	 *
	 * @return the bean name auto proxy creator
	 */
	// Ignoring DesignForExtension check, we cannot make this spring bean method
	// private or final
	// CHECKSTYLE:OFF
	@Bean
	BeanNameAutoProxyCreator sharedDataWsClientSimulatorProxy() {
		// CHECKSTYLE:ON
		return getBeanNameAutoProxyCreator(new String[] { SharedDataWsClientSimulator.BEAN_NAME },
				new String[] { "sharedDataWsClientSimulatorMarshallingInterceptor" });
	}

}
