/* Copyright (C) 2012 Viafirma - Viavansi Servicios Avanzados para las Instituciones S.L. (VIAVANSI)
   For any commercial use of this software contact info@viafirma.com.
   Encoding: UTF-8
 */
package com.viafirma.mobile.services.sdk.java.test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viafirma.mobile.services.sdk.java.ApiException;
import com.viafirma.mobile.services.sdk.java.api.V1Api;
import com.viafirma.mobile.services.sdk.java.model.Device;
import com.viafirma.mobile.services.sdk.java.model.Document;
import com.viafirma.mobile.services.sdk.java.model.ErrorResponse;
import com.viafirma.mobile.services.sdk.java.model.Evidence;
import com.viafirma.mobile.services.sdk.java.model.Form;
import com.viafirma.mobile.services.sdk.java.model.Item;
import com.viafirma.mobile.services.sdk.java.model.Message;
import com.viafirma.mobile.services.sdk.java.model.Notification;
import com.viafirma.mobile.services.sdk.java.model.Param;
import com.viafirma.mobile.services.sdk.java.model.Policy;
import com.viafirma.mobile.services.sdk.java.model.Token;
import com.viafirma.mobile.services.sdk.java.model.User;

/**
 * JUnit Test 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ApiTest {

	private static V1Api api;
	private static String template;
	private static String userCode = "inyenia";
	private static String userPass = "12345";
	private static String urlApi = "http://127.0.0.1:8080/mobile-services/api";
	private static String consumerKey = "com.viafirma.mobile.ios.documents";
	private static String consumerSecret = "5816437553";

	private static String deviceIdentifier = "D28A352B-6FA6-4A8B-A3FB-82171821300C";
	private static String messageCode = "1404745416603R698";
	private static String documentCode = "1404745416603R698D905";
	private static String policyCode = "";
	private static String evidenceCode = "";
	private static String filePath = "";

	private static Device device;
	
	@BeforeClass
	public static void setupOnce() {
		try {
			api = new V1Api();
			api.setBasePath(urlApi);		
			api.setConsumerKey(consumerKey);		
			api.setConsumerSecret(consumerSecret);

			Token token = api.postRequestToken();
			api.setToken(token.getOauth_token());
			api.setTokenSecret(token.getOauth_token_secret());

			token = api.postAccessToken(userCode, userPass, "client_auth");
			api.setToken(token.getOauth_token());
			api.setTokenSecret(token.getOauth_token_secret());
		} catch (ApiException e) {
			Assert.assertEquals(e.getCode(), 401);
		}
	}

	@Test
	public void t01RegisterDevice() {
		try {
			Device device = new Device();
			device.setAppCode(consumerKey);
			device.setCode("iphone_test");
			device.setDescription("Device for JUnit test");
			device.setLocale("es_ES");
			device.setType("IOS");
			device = api.registerDevice(device);
			Assert.assertNotNull(device);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t02FindDeviceByIdentifier() {
		try {
			device = api.findDeviceByIdentifier(deviceIdentifier);
			Assert.assertNotNull(device);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t03FindDeviceByUser() {
		try {
			List<Device> devices = api.findDeviceByUser(userCode);
			Assert.assertNotNull(devices);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t04SendMessage() {
		try {
			Message message = new Message();
			
			Document document = new Document();
			document.setTemplateCode("test_docx");
			document.setTemplateType("docx");
			document.setItems(new ArrayList<Item>());
			
			Item item01 = new Item();
			item01.setKey("KEY_01");
			item01.setValue("Jhon");
			document.getItems().add(item01);
			
			Item item02 = new Item();
			item02.setKey("KEY_02");
			item02.setValue("Doe");
			document.getItems().add(item02);
			
			Item item03 = new Item();
			item03.setKey("KEY_03");
			item03.setValue("11111111T");
			document.getItems().add(item03);
			
			message.setDocument(document);
			
			Notification notification = new Notification();
			notification.setText("Example Notification");
			notification.setDevices(new ArrayList<Device>());
			notification.getDevices().add(device);
			
			message.setNotification(notification);
			
			message.setPolicies(new ArrayList<Policy>());
			Policy policy = new Policy();
			policy.setTypeSign("ATTACHED");
			policy.setTypeFormatSign("DIGITALIZED_SIGN");
			policy.setParamList(new ArrayList<Param>());
			
			Param param01 = new Param();
			param01.setKey("digitalizedSignHelpText");
			param01.setValue("Firme Aquí");
			policy.getParamList().add(param01);
			
			Param param02 = new Param();
			param02.setKey("fileName");
			param02.setValue("example.pdf");
			policy.getParamList().add(param02);
			
			Param param03 = new Param();
			param03.setKey("biometricAlias");
			param03.setValue("viafirmaDocuments");
			policy.getParamList().add(param03);
			
			Param param04 = new Param();
			param04.setKey("biometricPass");
			param04.setValue("12345");
			policy.getParamList().add(param04);
			
			Param param05 = new Param();
			param05.setKey("op");
			param05.setValue("pen");
			policy.getParamList().add(param05);
			
			Param param06 = new Param();
			param06.setKey("signPositionEnable");
			param06.setValue("true");
			policy.getParamList().add(param06);
			
			message.getPolicies().add(policy);
			
			String messageCode = api.sendMessage(message);
			Assert.assertNotNull(messageCode);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t05GetMessageByCode() {
		try {
			Message message = api.getMessageByCode(messageCode);
			Assert.assertNotNull(message);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t06GetDocument() {
		try {
			byte[] result = api.getDocument("PREVIEW", messageCode, documentCode);
			Assert.assertNotNull(result);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t07SendEvidence() {
		try {
			Evidence evidence = api.sendEvidence(messageCode, policyCode, evidenceCode, new File(filePath), "test", null, null);
			Assert.assertNotNull(evidence);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t08FindFormsByUser() {
		try {
			List<Form> forms = api.findFormsByUser(userCode);
			Assert.assertNotNull(forms);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t09() {

	}

	@Test
	public void t10() {

	}

	@Test
	public void t11() {

	}

	@Test
	public void t12() {

	}

	@Test
	public void t13() {

	}

	@Test
	public void t14() {

	}

	@Test
	public void t15() {

	}

	@Test
	public void t16() {

	}

	@Test
	public void t17() {

	}

	@Test
	public void t18FindUserByCode() {
		User user;
		try {
			user = api.findUserByCode(userCode);
			Assert.assertEquals(userCode, user.getCode());
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}

	}

	@Test
	public void t19PostRequestToken() {
		try {
			V1Api api = new V1Api();
			api.setBasePath(urlApi);		
			api.setConsumerKey(consumerKey);		
			api.setConsumerSecret(consumerSecret);
			Token token = api.postRequestToken();
			Assert.assertNotNull(token.getOauth_token());
			Assert.assertNotNull(token.getOauth_token_secret());
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void test19() {

	}
	
	public ErrorResponse testApiException(ApiException e) {
		try {
			Assert.assertFalse(e.getMessage().contains("<"));
			ObjectMapper mapper = new ObjectMapper();
			ErrorResponse error = mapper.readValue(e.getMessage(), ErrorResponse.class);
			Assert.assertNotNull(error);
			Assert.assertTrue(String.valueOf(e.getMessage()), false);
			return error;
		} catch (Exception e1) {
			return null;
		}
		
	}

}

