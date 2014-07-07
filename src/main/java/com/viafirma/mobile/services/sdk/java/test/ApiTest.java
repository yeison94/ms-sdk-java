/* Copyright (C) 2012 Viafirma - Viavansi Servicios Avanzados para las Instituciones S.L. (VIAVANSI)
   For any commercial use of this software contact info@viafirma.com.
   Encoding: UTF-8
 */
package com.viafirma.mobile.services.sdk.java.test;

import junit.framework.Assert;
import junit.framework.TestCase;

import com.viafirma.mobile.services.sdk.java.ApiException;
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
	private String userPass = "123456";
	private String urlApi = "http://127.0.0.1:8080/mobile-services/api";
	private String consumerKey = "com.viafirma.mobile.ios.documents";
	private String consumerSecret = "5816437553";

	@Override
	public void setUp() {

		try {
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
		} catch (ApiException e) {
			Assert.assertEquals(e.getCode(), 401);
		}
	}
	
	@org.junit.Test
	public void test01() {
		
	}
	
	@org.junit.Test
	public void test02() {
		
	}
	
	@org.junit.Test
	public void test03() {
		
	}
	
	@org.junit.Test
	public void test04() {
		
	}
	
	@org.junit.Test
	public void test05() {
		
	}
	
	@org.junit.Test
	public void test06() {
		
	}
	
	@org.junit.Test
	public void test07() {
		
	}
	
	@org.junit.Test
	public void test08() {
		
	}
	
	@org.junit.Test
	public void test09() {
		
	}
	
	@org.junit.Test
	public void test10() {
		
	}
	
	@org.junit.Test
	public void test11() {
		
	}
	
	@org.junit.Test
	public void test12() {
		
	}
	
	@org.junit.Test
	public void test13() {
		
	}
	
	@org.junit.Test
	public void test14() {
		
	}
	
	@org.junit.Test
	public void test15() {
		
	}
	
	@org.junit.Test
	public void test16() {
		
	}
	
	@org.junit.Test
	public void test17() {
		
	}
	
	@org.junit.Test
	public void testFindUserByCode() {
		User user;
		try {
			user = api.findUserByCode(userCode);
			Assert.assertEquals(userCode, user.getCode());
		} catch (ApiException e) {
			Assert.assertEquals(e.getCode(), 401);
		}

	}

	@org.junit.Test
	public void postRequestToken() {
		try {
			Token token = api.postRequestToken(null);
			Assert.assertNotNull(token.getOauth_token());
			Assert.assertNotNull(token.getOauth_token_secret());
		} catch (ApiException e) {
			Assert.assertFalse(e.getMessage().contains("<"));
			Assert.assertEquals(e.getCode(), 401);
		}
	}
	
	@org.junit.Test
	public void test19() {
		
	}

	@Override
	public void tearDown() throws Exception {

	}

}

