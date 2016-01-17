/**
 * 
 */
package com.vm.mha.rk.service;

import java.io.IOException;
import java.net.HttpURLConnection;

import com.vm.mha.rk.ContentType;
import com.vm.mha.rk.domain.User;

/**
 * @author BharatRaju
 *
 */
public class UserService extends AbstractService {

	public User getUser(String accessToken) throws IOException {
		HttpURLConnection conn = createConnection(BASE_URL + "/user", "GET", accessToken);
		return read(conn, ContentType.USER, User.class);
	}
}
