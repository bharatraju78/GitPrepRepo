package com.vam.hdad.fitbit.api;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.fitbit.api.client.Configuration;
import com.fitbit.api.client.http.HttpClient;

public class FitbitAPIClientSupport {

	protected Log log = LogFactory.getLog(getClass());

	protected HttpClient http = new HttpClient();
	protected String source = Configuration.getSource();
	protected final boolean USE_SSL;

	public FitbitAPIClientSupport() {
		this(null, null);
	}

	FitbitAPIClientSupport(String userId, String password) {
		USE_SSL = Configuration.useSSL();
		setClientVersion(null);
		setClientURL(null);
		setUserId(userId);
		setPassword(password);
	}

	/**
	 * Sets the User-Agent header. System property -Dfitbit4j.http.userAgent
	 * overrides this attribute.
	 * 
	 * @param userAgent
	 *            new UserAgent
	 */
	public void setUserAgent(String userAgent) {
		http.setUserAgent(userAgent);
	}

	/**
	 *
	 * @return UserAgent
	 */
	public String getUserAgent() {
		return http.getUserAgent();
	}

	/**
	 * Sets the X-Fitbit-Client-Version header. System property
	 * -Dfitbit4j.clientVersion overrides this attribute.
	 * 
	 * @param version
	 *            client version
	 */
	public void setClientVersion(String version) {
		setRequestHeader("X-Fitbit-Client-Version", Configuration.getClientVersion(version));
	}

	/**
	 * Fetches the X-Fitbit-Client-Version header. Client version
	 *
	 * @return client version
	 */
	public String getClientVersion() {
		return http.getRequestHeader("X-Fitbit-Client-Version");
	}

	/**
	 * Sets the X-Fitbit-Client-URL header. System property -DFitbit4j.clientURL
	 * overrides this attribute.
	 * 
	 * @param clientURL
	 *            client URL
	 */
	public void setClientURL(String clientURL) {
		setRequestHeader("X-Fitbit-Client-URL", Configuration.getClientURL(clientURL));
	}

	/**
	 *
	 * @return client URL
	 */
	public String getClientURL() {
		return http.getRequestHeader("X-Fitbit-Client-URL");
	}

	/**
	 * Sets the userid
	 *
	 * @param userId
	 *            new userid
	 */
	public synchronized void setUserId(String userId) {
		http.setUserId(Configuration.getUser(userId));
	}

	/**
	 * Returns authenticating userid
	 *
	 * @return userid
	 */
	public String getUserId() {
		return http.getUserId();
	}

	/**
	 * Sets the password
	 *
	 * @param password
	 *            new password
	 */
	public synchronized void setPassword(String password) {
		http.setPassword(Configuration.getPassword(password));
	}

	/**
	 * Returns authenticating password
	 *
	 * @return password
	 */
	public String getPassword() {
		return http.getPassword();
	}

	/**
	 * Enables use of HTTP proxy
	 *
	 * @param proxyHost
	 *            proxy host, can be overridden system property
	 *            -DFitbit4j.http.proxyHost , -Dhttp.proxyHost
	 * @param proxyPort
	 *            proxy port, can be overridden system property
	 *            -DFitbit4j.http.proxyPort , -Dhttp.proxyPort
	 */
	public void setHttpProxy(String proxyHost, int proxyPort) {
		http.setProxyHost(proxyHost);
		http.setProxyPort(proxyPort);
	}

	/**
	 * Adds authentication on HTTP proxy
	 *
	 * @param proxyUser
	 *            proxy user, can be overridden system property
	 *            -DFitbit4j.http.proxyUser
	 * @param proxyPass
	 *            proxy password, can be overridden system property
	 *            -DFitbit4j.http.proxyPassword
	 */
	public void setHttpProxyAuth(String proxyUser, String proxyPass) {
		http.setProxyAuthUser(proxyUser);
		http.setProxyAuthPassword(proxyPass);
	}

	/**
	 * Sets a specified timeout value, in milliseconds, to be used when opening
	 * a communications link to the Fitbit API. System property
	 * -DFitbit4j.http.connectionTimeout overrides this attribute.
	 *
	 * @param connectionTimeout
	 *            an int that specifies the connect timeout value in
	 *            milliseconds
	 */
	public void setHttpConnectionTimeout(int connectionTimeout) {
		http.setConnectionTimeout(connectionTimeout);
	}

	/**
	 * Sets the read timeout to a specified timeout, in milliseconds.
	 *
	 * @param readTimeoutMilliSecs
	 *            an int that specifies the timeout value to be used in
	 *            milliseconds
	 */
	public void setHttpReadTimeout(int readTimeoutMilliSecs) {
		http.setReadTimeout(readTimeoutMilliSecs);
	}

	/**
	 * Sets X-Fitbit-Client http header and the source parameter that will be
	 * passed by updating methods. System property -DFitbit4j.source overrides
	 * this attribute. System property -DFitbit4j.source overrides this
	 * attribute.
	 *
	 * @param source
	 *            the new source
	 */
	public void setSource(String source) {
		this.source = Configuration.getSource(source);
		setRequestHeader("X-Fitbit-Client", this.source);
	}

	/**
	 * Returns the source
	 *
	 * @return source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Sets the request header name/value combination
	 *
	 * @param name
	 *            the name of the request header
	 * @param value
	 *            the value of the request header
	 */
	public void setRequestHeader(String name, String value) {
		http.setRequestHeader(name, value);
	}

	/**
	 * Set true to force using POST method communicating to the server.<br>
	 * This method doesn't take effect anymore
	 *
	 * @param forceUsePost
	 *            if true POST method will be used forcibly
	 * @deprecated some methods don't accept POST method anymore
	 */
	public void forceUsePost(boolean forceUsePost) {
		// this method doesn't take effect anymore
	}

	/**
	 * @return true if POST is used forcibly
	 */
	public boolean isUsePostForced() {
		return false;
	}

	public void setRetryCount(int retryCount) {
		http.setRetryCount(retryCount);
	}

	public void setRetryIntervalSecs(int retryIntervalSecs) {
		http.setRetryIntervalSecs(retryIntervalSecs);
	}
}
