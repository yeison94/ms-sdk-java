package com.viafirma.mobile.services.sdk.java.api;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import com.viafirma.mobile.services.sdk.java.ApiException;
import com.viafirma.mobile.services.sdk.java.ApiInvoker;
import com.viafirma.mobile.services.sdk.java.model.Device;
import com.viafirma.mobile.services.sdk.java.model.Message;
import com.viafirma.mobile.services.sdk.java.model.Notification;
import com.viafirma.mobile.services.sdk.java.model.Policy;
import com.viafirma.mobile.services.sdk.java.model.Template;
import com.viafirma.mobile.services.sdk.java.model.TemplateList;
import com.viafirma.mobile.services.sdk.java.model.Token;
import com.viafirma.mobile.services.sdk.java.model.User;

public class V1Api {

    Boolean firstAttempt = true;
    String user = null;
    String password = null;
    String auth_mode = null;
    Boolean validateResponse = false;
    
    ApiInvoker apiInvoker = ApiInvoker.getInstance();

    public ApiInvoker getInvoker() {
        return apiInvoker;
    }

    public void setBasePath(String basePath) {
        apiInvoker.setBasePath(basePath);
    }

    public String getBasePath() {
        return apiInvoker.getBasePath();
    }

    public void setConsumerKey(String consumerKey) {
       apiInvoker.setConsumerKey(consumerKey);
    }

    public String getConsumerKey() {
        return apiInvoker.getConsumerKey();
    }

    public void setConsumerSecret(String consumerSecret) {
        apiInvoker.setConsumerSecret(consumerSecret);
    }

    public String getConsumerSecret() {
        return apiInvoker.getConsumerSecret();
    }

    public String getToken() {
        return apiInvoker.getToken();
    }

    public void setToken(String token) {
        apiInvoker.setToken(token);
    }

    public String getTokenSecret() {
        return apiInvoker.getTokenSecret();
    }

    public void setTokenSecret(String tokenSecret) {
        apiInvoker.setTokenSecret(tokenSecret);
    }

    public Boolean getFirstAttempt() {
        return firstAttempt;
    }

    public void setFirstAttempt(Boolean firstAttempt) {
        this.firstAttempt = firstAttempt;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuth_mode() {
        return auth_mode;
    }

    public void setAuth_mode(String auth_mode) {
        this.auth_mode = auth_mode;
    }

    public Boolean getValidateResponse() {
        return validateResponse;
    }

    public void setValidateResponse(Boolean validateResponse) {
        this.validateResponse = validateResponse;
    }

    public Device registerDevice(Device body) throws ApiException {
        return V1devicesApi.getInstance().registerDevice(body);
    }

    public void generateNewToken() throws ApiException {
        setToken(null);
        setTokenSecret(null);
        
        Token token = requestToken();
        setToken(token.getOauth_token());
        setTokenSecret(token.getOauth_token_secret());
        token = accessToken(user, password, auth_mode);
        setToken(token.getOauth_token());
        setTokenSecret(token.getOauth_token_secret());
    }

    public Device findDeviceByIdentifier(String identifier) throws ApiException {
        return V1devicesApi.getInstance().findDeviceByIdentifier(identifier);
    }

    public List<Device> findDeviceByUser(String userCode) throws ApiException {
        return V1devicesApi.getInstance().findDeviceByUser(userCode);
    }

    public byte[] getDocument(String type, String messageCode, String documentCode) throws ApiException {

        String url = "";
        if ("preview".equalsIgnoreCase(type)) {
            url = V1documentsApi.getInstance().downloadPreview(messageCode).getLink();
        } else if ("signed".equalsIgnoreCase(type)) {
            url = V1documentsApi.getInstance().downloadSigned(messageCode).getLink();
        } else if ("temporal".equalsIgnoreCase(type)) {
            url = V1documentsApi.getInstance().downloadTemporal(messageCode).getLink();
        }
        
        int size = 1024;
        byte[] bytes;
        InputStream in = null;

        try {
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
        } catch (IOException e) {
            throw new ApiException();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    throw new ApiException();
                }
            }
        }

        return bytes;
    }

    public String sendMessage(Message body) throws ApiException {
        return V1messagesApi.getInstance().sendMessage(body);
    }

    public Message getMessageByCode(String messageCode) throws ApiException {
        return V1messagesApi.getInstance().getMessageByCode(messageCode);
    }

    public String sendNotification(Notification body) throws ApiException {
        return V1notificationsApi.getInstance().sendNotification(body).getCode();
    }

    public Notification findNotificationsByCode(String code) throws ApiException {
        return V1notificationsApi.getInstance().findNotificationsByCode(code);
    }

    public void changeNotificationStatus(String code, String status) throws ApiException {
        V1notificationsApi.getInstance().changeNotificationStatus(code, status);
    }

    public Policy prepareSignature(String messageCode, String policyCode, String userCode) throws ApiException {
        return V1signaturesApi.getInstance().prepareSignature(messageCode, policyCode, userCode);
    }

    public Policy registerSignature(String messageCode, String policyCode, String signatureCode) throws ApiException {
        return V1signaturesApi.getInstance().registerSignature(messageCode, policyCode, signatureCode);
    }

    public void registerUser(User body) throws ApiException {
        V1usersApi.getInstance().registerUser(body);
    }

    public User findUserByCode(String userCode) throws ApiException {
        return V1usersApi.getInstance().findUserByCode(userCode);
    }

    public Token requestToken() throws ApiException {
        return V1oauthApi.getInstance().requestToken();
    }

    public Token accessToken(String x_auth_username, String x_auth_password, String x_auth_mode) throws ApiException {
        return V1oauthApi.getInstance().accessToken(x_auth_mode, x_auth_username, x_auth_password);
    }
    
    public List<TemplateList> findTemplatesByUser(String userCode) throws ApiException {
        return V1templateApi.getInstance().findTemplatesByUser(userCode);
    }
    
    public Template findTemplateByCode(String templateCode) throws ApiException {
        return V1templateApi.getInstance().findTemplateByCode(templateCode);
    }
}
