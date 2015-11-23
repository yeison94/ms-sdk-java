/* Copyright (C) 2012 Viafirma - Viavansi Servicios Avanzados para las Instituciones S.L. (VIAVANSI)
   For any commercial use of this software contact info@viafirma.com.
   Encoding: UTF-8
 */
package com.viafirma.mobile.services.sdk.java.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viafirma.mobile.services.sdk.java.ApiException;
import com.viafirma.mobile.services.sdk.java.api.V1Api;
import com.viafirma.mobile.services.sdk.java.model.Device;
import com.viafirma.mobile.services.sdk.java.model.Device.TypeEnum;
import com.viafirma.mobile.services.sdk.java.model.Document;
import com.viafirma.mobile.services.sdk.java.model.Document.TemplateTypeEnum;
import com.viafirma.mobile.services.sdk.java.model.ErrorResponse;
import com.viafirma.mobile.services.sdk.java.model.Item;
import com.viafirma.mobile.services.sdk.java.model.Message;
import com.viafirma.mobile.services.sdk.java.model.Notification;
import com.viafirma.mobile.services.sdk.java.model.Param;
import com.viafirma.mobile.services.sdk.java.model.Policy;
import com.viafirma.mobile.services.sdk.java.model.Policy.TypeFormatSignEnum;
import com.viafirma.mobile.services.sdk.java.model.Policy.TypeSignEnum;
import com.viafirma.mobile.services.sdk.java.model.Template;
import com.viafirma.mobile.services.sdk.java.model.TemplateList;
import com.viafirma.mobile.services.sdk.java.model.User;
import com.viafirma.mobile.services.sdk.java.model.Workflow;

enum OAuthType{
    OAUTH_APPLICATION,
    OAUTH_USER
}
/**
 * JUnit Test
 */
public class ApiTest {

	private static V1Api api;
	private static final String TEMPLATE_CODE = "001_example";
	private static final TemplateTypeEnum TEMPLATE_TYPE = TemplateTypeEnum.docx;
	
	private static final String USER_CODE = "XXXXXX";
	private static final String USER_PASSWORD = "XXXXXX";
	
	private static final String DEVICE_CODE = "XXXXXX";
	private static final String DEVICE_DESCRIPTION = "Device for JUnit test";
	private static final String DEVICE_LOCALE = "es_ES";
	private static final TypeEnum DEVICE_TYPE = TypeEnum.IOS;
	private static final String DEVICE_IDENTIFIER = "DDC0EB02-77D6-469F-91C6-1C0E09185C13";
	private static final String DEVICE_APP_CODE = "com.viafirma.mobile.ios.XXXX";
	
	private static final OAuthType oauthType = OAuthType.OAUTH_APPLICATION;
	private static final String API_URL = "http://localhost/mobile-services/api";
	private static final String CONSUMER_KEY = "com.viafirma.mobile.services.crm";
	private static final String CONSUMER_SECRET = "XXXXXXXXXX";
	private static final String AUTH_MODE = "client_auth";
	
	private static final String MESSAGE_CODE = "XXXXXXXXXX";
	private static final String DOCUMENT_CODE = "XXXXXXXXXX";
	private static final String NOTIFICATION_CODE = "XXXXXXXXX";
	
	private static final String newUserText = "XXXXXXXXX";
	
	@BeforeClass
	public static void setupOnce() {
		try {
			api = new V1Api();
			api.setBasePath(API_URL);
			api.setConsumerKey(CONSUMER_KEY);
			api.setConsumerSecret(CONSUMER_SECRET);
			
			if (oauthType == OAuthType.OAUTH_USER) {
			    api.setUser(USER_CODE);
	            api.setPassword(USER_PASSWORD);
	            api.setAuth_mode(AUTH_MODE);
	            api.generateNewToken();
            }
		} catch (ApiException e) {
			Assert.assertEquals(e.getCode(), 401);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void t01RegisterDevice() {
	    //BEGIN-SNIPPET: api_register_device
	    try {
			Device device = new Device();
			device.setAppCode(DEVICE_APP_CODE);
			device.setUserCode(USER_CODE);
			device.setCode(DEVICE_CODE);
			device.setDescription(DEVICE_DESCRIPTION);
			device.setLocale(DEVICE_LOCALE);
			device.setType(DEVICE_TYPE);
			device.setUniqueIdentifier(DEVICE_IDENTIFIER);
			device = api.registerDevice(device);
			Assert.assertNotNull(device);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	    //END-SNIPPET
	}

	@Test
	public void t02FindDeviceByUser() {
		try {
			List<Device> devices = api.findDeviceByUser(USER_CODE);
			Assert.assertNotNull(devices);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t03SendMessage() {
		try {
			List<Device> devices = api.findDeviceByUser(USER_CODE);
		    
			Device device = null;
			for(Device cd: devices){
		        if (cd.getCode().equals(DEVICE_CODE)) {
                    device = cd;
                }
		    }
			Assert.assertNotNull(devices);
			
			Message message = new Message();

			Document document = new Document();
			document.setTemplateCode(TEMPLATE_CODE);
			document.setTemplateType(TEMPLATE_TYPE);
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
			notification.setText("Notification Example");
			notification.setDevices(new ArrayList<Device>());
			notification.getDevices().add(device);

			message.setNotification(notification);

			message.setPolicies(new ArrayList<Policy>());
			Policy policy = new Policy();
			policy.setTypeSign(TypeSignEnum.ATTACHED);
			policy.setTypeFormatSign(TypeFormatSignEnum.DIGITALIZED_SIGN);
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
	public void t04GetMessageByCode() {
		try {
			Message message = api.getMessageByCode(MESSAGE_CODE);
			Assert.assertNotNull(message);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t05GetDocument() {
		try {
			byte[] result = api.getDocument("SIGNED", MESSAGE_CODE, DOCUMENT_CODE);
			Assert.assertNotNull(result);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}
	
	@Test
    public void t06FindTemplatesByUser() {
        try {
            List<TemplateList> templates = api.findTemplatesByUser(USER_CODE);
            Assert.assertNotNull(templates);
        } catch (ApiException e) {
            Assert.assertNotNull(testApiException(e));
        }
    }
	
	@Test
    public void t07FindTemplateByCode() {
        try {
            Template template = api.findTemplateByCode(TEMPLATE_CODE);
            Assert.assertNotNull(template);
        } catch (ApiException e) {
            Assert.assertNotNull(testApiException(e));
        }
    }

//	@Test
//	public void t07FindFormsByUser() {
//		try {
//			List<Form> forms = api.findFormsByUser(USER_CODE);
//			Assert.assertNotNull(forms);
//			Assert.assertFalse(forms.isEmpty());
//		} catch (ApiException e) {
//			Assert.assertNotNull(testApiException(e));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	@Test
	public void t08SendNotification() {
		try {
			Device device = api.findDeviceByIdentifier(DEVICE_IDENTIFIER);
			Notification notification = new Notification();
			notification.setText("Notification Example");
			notification.setDevices(new ArrayList<Device>());
			notification.getDevices().add(device);
			String code = api.sendNotification(notification);
			Assert.assertNotNull(code);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t09FindNotificationsByCode() {
		try {
			Notification notification = api.findNotificationsByCode(NOTIFICATION_CODE);
			Assert.assertNotNull(notification);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t10ChangeNotificationStatus() {
		try {
			api.changeNotificationStatus(NOTIFICATION_CODE, "READ");
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t13RegisterUser() {
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
	public void t14FindUserByCode() {
		try {
			api.findUserByCode(newUserText);
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}
	}

	@Test
	public void t15FindUserByCode() {
		User user;
		try {
			user = api.findUserByCode(USER_CODE);
			Assert.assertEquals(USER_CODE, user.getCode());
		} catch (ApiException e) {
			Assert.assertNotNull(testApiException(e));
		}

	}
	
	@Test
    public void t16CreateDocument() throws Exception {
	    
	    // Build a new document (PDF) from a template. This user case implements EX005 workflow code, usseful to print 
	    // your document when iOS/Android devices are not availables.
	    try {
            
            Message message = new Message();
            
            // Create notification info
            Notification notification = new Notification();
            notification.setText("Title");
            notification.setDetail("Detail");
            message.setNotification(notification);
           
            Workflow workflow = new Workflow();
            workflow.setCode("EX005"); // only generate PDF from template. It´s not sent to mobile devices.
            message.setWorkflow(workflow);
            
            Document document = new Document();
            document.setTemplateCode(TEMPLATE_CODE);
            document.setTemplateType(TEMPLATE_TYPE);
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

            String messageCode = api.sendMessage(message);
            System.out.println(messageCode);
            Assert.assertNotNull(messageCode);
            
            int count = 100;
            String status = null;
            while (count > 0) {
                count--;
                Message msg = api.getMessageByCode(messageCode);
                status = msg.getWorkflow().getCurrent();

                if ("RESPONSED".equals(status)) {
                    String documentCode = msg.getDocument().getDraftedCode();
                    byte[] pdf = api.getDocument("temporal", messageCode, documentCode);
                    Assert.assertNotNull(pdf);
                } else {
                    Thread.sleep(1000);
                }
            }
        } catch (ApiException e) {
            Assert.assertNotNull(testApiException(e));
        }
    }
	
	public void t17CreateMessageWithTemplate() throws Exception {
        
        try {
            
            Message message = new Message();
            
            // Create notification info
            Notification notification = new Notification();
            notification.setText("Title");
            notification.setDetail("Detail");
            
            // Find user device
            Device device = api.findDeviceByUser(USER_CODE).get(0);
            notification.setDevices(new ArrayList<Device>());
            notification.getDevices().add(device);
            message.setNotification(notification);
           
            Document document = new Document();
            document.setTemplateCode(TEMPLATE_CODE);
            document.setTemplateType(TEMPLATE_TYPE);
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
            
            // Copy policies form template
            Template template = api.findTemplateByCode(TEMPLATE_CODE);
            message.setPolicies(template.getForm().getSettings().getPolicies());

            String messageCode = api.sendMessage(message);
            System.out.println(messageCode);
            Assert.assertNotNull(messageCode);
            
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

