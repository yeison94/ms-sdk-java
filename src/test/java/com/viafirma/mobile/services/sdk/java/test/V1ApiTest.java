/* Copyright (C) 2012 Viafirma - Viavansi Servicios Avanzados para las Instituciones S.L. (VIAVANSI)
   For any commercial use of this software contact info@viafirma.com.
   Encoding: UTF-8
 */
package com.viafirma.mobile.services.sdk.java.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.IOUtils;
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
import com.viafirma.mobile.services.sdk.java.model.Container;
import com.viafirma.mobile.services.sdk.java.model.Device;
import com.viafirma.mobile.services.sdk.java.model.Document;
import com.viafirma.mobile.services.sdk.java.model.Document.TemplateTypeEnum;
import com.viafirma.mobile.services.sdk.java.model.Download;
import com.viafirma.mobile.services.sdk.java.model.ErrorResponse;
import com.viafirma.mobile.services.sdk.java.model.Form;
import com.viafirma.mobile.services.sdk.java.model.Item;
import com.viafirma.mobile.services.sdk.java.model.Message;
import com.viafirma.mobile.services.sdk.java.model.Notification;
import com.viafirma.mobile.services.sdk.java.model.Param;
import com.viafirma.mobile.services.sdk.java.model.Policy;
import com.viafirma.mobile.services.sdk.java.model.Policy.TypeFormatSignEnum;
import com.viafirma.mobile.services.sdk.java.model.Policy.TypeSignEnum;
import com.viafirma.mobile.services.sdk.java.model.Row;
import com.viafirma.mobile.services.sdk.java.model.Template;
import com.viafirma.mobile.services.sdk.java.model.TemplateList;
import com.viafirma.mobile.services.sdk.java.model.User;
import com.viafirma.mobile.services.sdk.java.model.Workflow;

/**
 * JUnit Test
 */
public class V1ApiTest {

    private static final String TEMPLATE_CODE = "001_example";
    private static final TemplateTypeEnum TEMPLATE_TYPE = TemplateTypeEnum.docx;

    private static final String USER_CODE = "XXXXXXX";
    private static final String USER_PASSWORD = "XXXXXXX";
    private static final String DEVICE_CODE = "XXXXXX";

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
            //BEGIN-SNIPPET: api_v1_find_template
            Template template = V1templateApi.getInstance().findTemplateByCode(TEMPLATE_CODE);
            //END-SNIPPET

            //BEGIN-SNIPPET: api_v1_find_template_items
            //Find items in template form
            Form form = template.getForm();
            for(Container container: form.getContainers()){
                for(Row row: container.getRows()){
                    for(Item item: row.getItems()){
                        if (item.getKey().equals("KEY_01")) {
                            item.setValue("Jhon");
                        } else if (item.getKey().equals("KEY_02")) {
                            item.setValue("Doe");
                        } else if (item.getKey().equals("KEY_03")) {
                            item.setValue("11111111T");
                        }
                    }
                }
            }
            //END-SNIPPET

            Message message = new Message();
            //BEGIN-SNIPPET: api_v1_find_template_policies
            // Copy policies form template
            message.setPolicies(template.getForm().getSettings().getPolicies());
            //END-SNIPPET

            Assert.assertNotNull(template);
        } catch (ApiException e) {
            Assert.assertNotNull(testApiException(e));
        }
    }

    @Test
    public void t04SendMessage() {
        try {

            //BEGIN-SNIPPET: api_v1_send_message
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

            //Find device in user device list
            Device device = null;
            List<Device> devices = V1devicesApi.getInstance().findDeviceByUser(USER_CODE);
            for (Device d: devices) {
                if (DEVICE_CODE.equals(d.getCode())) {
                    device = d;
                    break;
                }
            }

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

            //java example in https://github.com/viavansi/ms-callback
            message.setCallbackURL("https://localhost:8080/ms-callback/response");

            //send document by email (optional)
            message.setCallbackMails("user1@mail.com,user2@mail.com");

            String messageCode = V1messagesApi.getInstance().sendMessage(message);
            //END-SNIPPET

            Assert.assertNotNull(messageCode);

            //BEGIN-SNIPPET: api_v1_send_messages_poll
            int count = 100;
            String status = null;
            while (count > 0) {
                count--;
                Message msg = V1messagesApi.getInstance().getMessageByCode(messageCode);
                status = msg.getWorkflow().getCurrent();

                if ("RESPONSED".equals(status)) {
                    Download download = V1documentsApi.getInstance().downloadSigned(messageCode);
                    byte[] pdf = IOUtils.toByteArray((new URL(download.getLink())).openStream());
                    Assert.assertNotNull(pdf);
                } else {
                    Thread.sleep(1000);
                }
            }
            //END-SNIPPET
        } catch (ApiException e) {
            Assert.assertNotNull(testApiException(e));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void t05GetMessageByCode() {
        try {
            //BEGIN-SNIPPET: api_v1_get_message
            Message message = V1messagesApi.getInstance().getMessageByCode(MESSAGE_CODE);
            //END-SNIPPET
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

    @Test
    public void t08CreateDocument() throws Exception {

        // Build a new document (PDF) from a template. This user case implements EX005 workflow code, usseful to print 
        // your document when iOS/Android devices are not availables.

        String messageCode = null;
        try {

            //BEGIN-SNIPPET: api_v1_create_document
            Message message = new Message();

            // Create notification info
            Notification notification = new Notification();
            notification.setText("Title");
            notification.setDetail("Detail");
            message.setNotification(notification);

            Workflow workflow = new Workflow();
            // only generate PDF from template. It´s not sent to mobile devices.
            workflow.setCode("EX005"); 
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

            //java example in https://github.com/viavansi/ms-callback
            message.setCallbackURL("https://localhost:8080/ms-callback/response");

            //send document by email (optional)
            message.setCallbackMails("user1@mail.com,user2@mail.com");

            messageCode = V1messagesApi.getInstance().sendMessage(message);
            //END-SNIPPET
            Assert.assertNotNull(messageCode);

        } catch (ApiException e) {
            Assert.assertNotNull(testApiException(e));
        }

        try{
            //BEGIN-SNIPPET: api_v1_create_document_poll
            int count = 100;
            String status = null;
            while (count > 0) {
                count--;
                Message msg = V1messagesApi.getInstance().getMessageByCode(messageCode);
                status = msg.getWorkflow().getCurrent();

                if ("RESPONSED".equals(status)) {
                    Download download = V1documentsApi.getInstance().downloadTemporal(messageCode);
                    byte[] pdf = IOUtils.toByteArray((new URL(download.getLink())).openStream());
                    Assert.assertNotNull(pdf);
                } else {
                    Thread.sleep(1000);
                }
            }
            //END-SNIPPET
        } catch (ApiException e) {
            Assert.assertNotNull(testApiException(e));
        }
    }

    public void t09CreateMessageWithTemplate() throws Exception {

        try {
            //BEGIN-SNIPPET: api_v1_send_message_template
            Message message = new Message();

            // Create notification info
            Notification notification = new Notification();
            notification.setText("Title");
            notification.setDetail("Detail");

            // Find user device
            Device device = V1devicesApi.getInstance().findDeviceByUser(USER_CODE).get(0);
            notification.setDevices(new ArrayList<Device>());
            notification.getDevices().add(device);
            message.setNotification(notification);

            Document document = new Document();
            document.setTemplateCode(TEMPLATE_CODE);
            document.setTemplateType(TEMPLATE_TYPE);
            document.setItems(new ArrayList<Item>());

            //GET Template info
            Template template = V1templateApi.getInstance().findTemplateByCode(TEMPLATE_CODE);

            //Find items in template form
            Form form = template.getForm();
            for(Container container: form.getContainers()){
                for(Row row: container.getRows()){
                    for(Item item: row.getItems()){
                        if (item.getKey().equals("KEY_01")) {
                            item.setValue("Jhon");
                        } else if (item.getKey().equals("KEY_02")) {
                            item.setValue("Doe");
                        } else if (item.getKey().equals("KEY_03")) {
                            item.setValue("11111111T");
                        }
                        //Add item to document
                        document.getItems().add(item);
                    }
                }
            }

            message.setDocument(document);

            // Copy policies form template
            message.setPolicies(template.getForm().getSettings().getPolicies());

            //java example in https://github.com/viavansi/ms-callback
            message.setCallbackURL("https://localhost:8080/ms-callback/response");

            //send document by email (optional)
            message.setCallbackMails("user1@mail.com,user2@mail.com");

            String messageCode = V1messagesApi.getInstance().sendMessage(message);
            //END-SNIPPET
            System.out.println(messageCode);
            Assert.assertNotNull(messageCode);
            
            int count = 100;
            String status = null;
            while (count > 0) {
                count--;
                Message msg = V1messagesApi.getInstance().getMessageByCode(messageCode);
                status = msg.getWorkflow().getCurrent();

                if ("RESPONSED".equals(status)) {
                    //BEGIN-SNIPPET: api_v1_download_document
                    Download download = V1documentsApi.getInstance().downloadSigned(messageCode);
                    byte[] pdf = IOUtils.toByteArray((new URL(download.getLink())).openStream());
                    //END-SNIPPET
                    Assert.assertNotNull(pdf);
                } else {
                    Thread.sleep(10000);
                }
            }
            //END-SNIPPET

        } catch (ApiException e) {
            Assert.assertNotNull(testApiException(e));
        }
    }
    
    public void t10SignExternalDocument() throws Exception {

        try {
            //BEGIN-SNIPPET: api_v1_send_external_doc
            Message message = new Message();
            
            //Find device in user device list
            Device device = null;
            List<Device> devices = V1devicesApi.getInstance().findDeviceByUser(USER_CODE);
            for (Device d: devices) {
                if (DEVICE_CODE.equals(d.getCode())) {
                    device = d;
                    break;
                }
            }
            
            // Create notification info
            Notification notification = new Notification();
            notification.setText("External document demo");
            notification.setDetail("Sign a document available at URL");
            notification.setDevices(new ArrayList<Device>());
            notification.getDevices().add(device);
            message.setNotification(notification);

            // Create a template document
            Document document = new Document();
            document.setTemplateReference("http://descargas.viavansi.com/mobile-services/example-sign.pdf");
            document.setTemplateType(TemplateTypeEnum.url);
            message.setDocument(document);
            
            Policy policy = new Policy();
            policy.setTypeFormatSign(TypeFormatSignEnum.DIGITALIZED_SIGN);
            policy.setTypeSign(TypeSignEnum.ATTACHED);
            
            List<Param> paramList = new ArrayList<Param>();
            
            Param p1 = new Param();
            p1.setKey("digitalizedSignHelpText");
            p1.setValue("Firme aquí");
            paramList.add(p1);
            
            Param p2 = new Param();
            p2.setKey("signPositionEnable");
            p2.setValue("true");
            paramList.add(p2);
            
            Param p3 = new Param();
            p3.setKey("fileName");
            p3.setValue("demo_001.pdf");
            paramList.add(p3);
            
            Param p4 = new Param();
            p4.setKey("op");
            p4.setValue("pen");
            paramList.add(p4);
            
            policy.setParamList(paramList);
            
            List<Policy> policies = new ArrayList<Policy>();
            policies.add(policy);
            message.setPolicies(policies);
            
            //java example in https://github.com/viavansi/ms-callback
            message.setCallbackURL("https://localhost:8080/ms-callback/response");

            //send document by email (optional)
            message.setCallbackMails("user1@mail.com,user2@mail.com");

            String messageCode = V1messagesApi.getInstance().sendMessage(message);
            //END-SNIPPET
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
