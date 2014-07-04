/* Copyright (C) 2012 Viafirma - Viavansi Servicios Avanzados para las Instituciones S.L. (VIAVANSI)
   For any commercial use of this software contact info@viafirma.com.
   Encoding: UTF-8
 */
package com.viafirma.mobile.services.sdk.java.test;

import java.io.IOException;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.viafirma.mobile.services.sdk.java.api.V1Api;
import com.viafirma.mobile.services.sdk.java.model.Token;
import com.viafirma.mobile.services.sdk.java.model.User;

/**
 * JUnit Test 
 */
public class ApiTest  extends TestCase {

	private V1Api api;
	private String template;
	private String userCode = "inyenia";
	private String userPass = "12345";
	private String urlApi = "http://127.0.0.1:8080/mobile-services/api";
	private String consumerKey = "com.viafirma.mobile.ios.documents";
	private String consumerSecret = "5816437553";
	
	@Override
	public void setUp() throws Exception {

		api = new V1Api();
		api.setBasePath(urlApi);		
		api.setConsumerKey(consumerKey);		
		api.setConsumerSecret(consumerSecret);
		
		Token token = api.postRequestToken(null);
		api.setToken(token.getOauth_token());
		api.setTokenSecret(token.getOauth_token_secret());
		
		token = api.postAccessToken(userCode, userPass, "client_auth");
		api.setToken(token.getOauth_token());
		api.setTokenSecret(token.getOauth_token_secret());
	}

	@org.junit.Test
	public void testFindUserByCode() throws IOException, Exception {
		User user = api.findUserByCode(userCode);
		Assert.assertNotNull(user);
	}

	@Override
	public void tearDown() throws Exception {

	}

}

