/* Copyright (C) 2012 Viafirma - Viavansi Servicios Avanzados para las Instituciones S.L. (VIAVANSI)
   For any commercial use of this software contact info@viafirma.com.
   Encoding: UTF-8
 */
package com.viafirma.mobile.services.sdk.java.test;

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
	private static String template = "test_docx";
	private static String userCode = "XXXXXX";
	private static String userPass = "XXXXXX";
	private static String deviceCode = "iphoneblanco";
	private static String urlApi = "http://127.0.0.1:8080/mobile-services/api";
	private static String consumerKey = "XXXXXXXXXXXXXXXXXXX";
	private static String consumerSecret = "XXXXXXXXXXXXX";

	private static String deviceIdentifier = "XXXXXXXXXXXXXXXXXXXXXXXXX";
	private static String messageCode = "1405599049913R461";
	private static String documentCode = "1404802809751R929D603";
	private static String policyCode = "1405599049913R461P127";
	private static String evidenceCode = "1404802809751R929E675";
	private static String filePath = "/tmp/test.jpg";
	private static String notificationCode = "1405588327409";
	private static String signatureCode = "XXXXXXXXX";

	private static Device device;

	private static String newUserText = "testJunit1";

	@BeforeClass
	public static void setupOnce() {
		try {
			api = new V1Api();
			api.setBasePath(urlApi);
			api.setConsumerKey(consumerKey);
			api.setConsumerSecret(consumerSecret);

			Token token = api.requestToken();
			api.setToken(token.getOauth_token());
			api.setTokenSecret(token.getOauth_token_secret());

			token = api.accessToken(userCode, userPass, "client_auth");
			api.setToken(token.getOauth_token());
			api.setTokenSecret(token.getOauth_token_secret());
		} catch (ApiException e) {
			Assert.assertEquals(e.getCode(), 401);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void t01RegisterDevice() {
		try {
			device = new Device();
			device.setAppCode(consumerKey);
			device.setUserCode(userCode);
			device.setCode(deviceCode);
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
			if (device == null) {
				t02FindDeviceByIdentifier();
			}
			Message message = new Message();

			Document document = new Document();
			document.setTemplateCode(template);
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
			param03.setValue("viafirmadocuments");
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
		//		try {
		//			Evidence evidence = api.sendEvidence(messageCode, policyCode, evidenceCode, new File(filePath), "test", null, null);
		//			Assert.assertNotNull(evidence);
		//		} catch (ApiException e) {
		//			Assert.assertNotNull(testApiException(e));
		//		}
	}

	@Test
	public void t08FindFormsByUser() {
		try {
			List<Form> forms = api.findFormsByUser(userCode);
			Assert.assertNotNull(forms);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void t09SendNotification() {
		try {
			device = api.findDeviceByIdentifier(deviceIdentifier);
			Notification notification = new Notification();
			notification.setText("Example Notification");
			notification.setDevices(new ArrayList<Device>());
			notification.getDevices().add(device);
			String code = api.sendNotification(notification);
			Assert.assertNotNull(code);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t10FindNotificationsByTokenStatus() {
		try {
			device = api.findDeviceByIdentifier(deviceIdentifier);
			List<Notification> notifications = api.findNotificationsByTokenStatus(device.getToken(), "DISPATCHED");
			Assert.assertNotNull(notifications);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t11FindNotificationsByToken() {
		try {
			List<Notification> notifications = api.findNotificationsByToken(deviceIdentifier);
			Assert.assertNotNull(notifications);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t12FindNotificationsByCode() {
		try {
			Notification notification = api.findNotificationsByCode(notificationCode);
			Assert.assertNotNull(notification);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t13ChangeNotificationStatus() {
		try {
			api.changeNotificationStatus(notificationCode, "READ");
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t14PrepareSignature() {
		try {
			api.prepareSignature(messageCode, policyCode, userCode);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t15RegisterSignature() {
		try {
			api.registerSignature(messageCode, policyCode, signatureCode);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t16RegisterUser() {
		User user = new User();

		user.setCode(newUserText);
		user.setDescription(newUserText);
		user.setEmail(newUserText+"@temp.com");
		user.setName(newUserText);
		user.setNationalId(newUserText);
		user.setPassword(newUserText);
		user.setPos(newUserText);
		user.setRegion(newUserText);
		user.setRol(newUserText);
		user.setSurname(newUserText);
		user.setViafirmaCertificate(newUserText);
		user.setViafirmaKey(newUserText);
		user.setViafirmaPassword(newUserText);

		try {
			api.registerUser(user);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t17FindUserByCode() {
		try {
			api.findUserByCode(newUserText);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
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
			Token token = api.requestToken();
			Assert.assertNotNull(token.getOauth_token());
			Assert.assertNotNull(token.getOauth_token_secret());
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
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

