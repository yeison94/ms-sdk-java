/* Copyright (C) 2012 Viafirma - Viavansi Servicios Avanzados para las Instituciones S.L. (VIAVANSI)
   For any commercial use of this software contact info@viafirma.com.
   Encoding: UTF-8
 */
package com.viafirma.mobile.services.sdk.java.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viafirma.mobile.services.sdk.java.ApiException;
import com.viafirma.mobile.services.sdk.java.api.V1Api;
import com.viafirma.mobile.services.sdk.java.api.V1devicesApi;
import com.viafirma.mobile.services.sdk.java.api.V1documentsApi;
import com.viafirma.mobile.services.sdk.java.api.V1messagesApi;
import com.viafirma.mobile.services.sdk.java.api.V1templateApi;
import com.viafirma.mobile.services.sdk.java.api.V1usersApi;
import com.viafirma.mobile.services.sdk.java.model.Device;
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

/**
 * JUnit Test
 */
public class V1ApiTest {

    private static final String TEMPLATE_CODE = "001_example";
    private static final TemplateTypeEnum TEMPLATE_TYPE = TemplateTypeEnum.docx;

    private static final String USER_CODE = "XXXXXXX";
    private static final String USER_PASSWORD = "XXXXXXX";
    private static final String DEVICE_IDENTIFIER = "DDC0EB02-88D6-402F-91C6-1C0E09185C13";

    private static final OAuthType OAUTH_TYPE = OAuthType.OAUTH_APPLICATION;
    private static final String API_URL = "http://localhost/mobile-services/api";
    private static final String CONSUMER_KEY = "com.viafirma.mobile.services.crm";
    private static final String CONSUMER_SECRET = "XXXXXXXX";
    private static final String AUTH_MODE = "client_auth";

    private static final String MESSAGE_CODE = "XXXXXXXXXX";

    @BeforeClass
    public static void setupOnce() {
        try {
            //BEGIN-SNIPPET: api_initialize
            V1Api api = new V1Api();
            api.setBasePath(API_URL);
            api.setConsumerKey(CONSUMER_KEY);
            api.setConsumerSecret(CONSUMER_SECRET);

            if (OAUTH_TYPE == OAuthType.OAUTH_USER) {
                api.setUser(USER_CODE);
                api.setPassword(USER_PASSWORD);
                api.setAuth_mode(AUTH_MODE);
                api.generateNewToken();
            }
            //END-SNIPPET
        } catch (ApiException e) {
            Assert.assertEquals(e.getCode(), 401);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t01FindDeviceByUser() {
        try {
            //BEGIN-SNIPPET: api_v1_user_devices
            List<Device> devices = V1devicesApi.getInstance().findDeviceByUser(USER_CODE);
            //END-SNIPPET
            Assert.assertNotNull(devices);
        } catch (ApiException e) {
            Assert.assertNotNull(testApiException(e));
        }
    }

    @Test
    public void t02FindTemplatesByUser() {
        try {
            //BEGIN-SNIPPET: api_v1_find_user_templates
            List<TemplateList> templates = V1templateApi.getInstance().findTemplatesByUser(USER_CODE);
            //END-SNIPPET
            Assert.assertNotNull(templates);
        } catch (ApiException e) {
            Assert.assertNotNull(testApiException(e));
        }
    }
    
    @Test
    public void t03FindTemplateByCode() {
        try {
            Template template = V1templateApi.getInstance().findTemplateByCode(TEMPLATE_CODE);
            Assert.assertNotNull(template);
        } catch (ApiException e) {
            Assert.assertNotNull(testApiException(e));
        }
    }

    @Test
    public void t04SendMessage() {
        try {
            Device device = V1devicesApi.getInstance().findDeviceByIdentifier(DEVICE_IDENTIFIER);

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

            String messageCode = V1messagesApi.getInstance().sendMessage(message);
            Assert.assertNotNull(messageCode);
        } catch (ApiException e) {
            Assert.assertNotNull(testApiException(e));
        }
    }

    @Test
    public void t05GetMessageByCode() {
        try {
            Message message = V1messagesApi.getInstance().getMessageByCode(MESSAGE_CODE);
            Assert.assertNotNull(message);
        } catch (ApiException e) {
            Assert.assertNotNull(testApiException(e));
        }
    }

    @Test
    public void t06GetDocument() {
        
        InputStream in = null;
        try {
            String url = V1documentsApi.getInstance().downloadSigned(MESSAGE_CODE).getLink();
            int size = 1024;
            byte[] bytes;
           
            final URL u = new URL(url);
            URLConnection connection = u.openConnection();
            in = connection.getInputStream();
            if (in instanceof ByteArrayInputStream) {
                size = in.available();
                bytes = new byte[size];
                in.read(bytes, 0, size);
            } else {
                ByteArrayOutputStream bos = new ByteArrayOutputStream();
                bytes = new byte[size];
                int len;
                while ((len = in.read(bytes, 0, size)) != -1) {
                    bos.write(bytes, 0, len);
                }
                bytes = bos.toByteArray();
            }
            Assert.assertNotNull(bytes);
        } catch (IOException e) {
            Assert.assertNotNull(testApiException(new ApiException()));
        } catch (ApiException e) {
            Assert.assertNotNull(testApiException(e));
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    Assert.assertNotNull(testApiException(new ApiException()));
                }
            }
        }
    }
    
    @Test
    public void t07FindUserByCode() {
        try {
            //BEGIN-SNIPPET: api_v1_find_user
            User user = V1usersApi.getInstance().findUserByCode(USER_CODE);
            //END-SNIPPET
            Assert.assertNotNull(user);
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
