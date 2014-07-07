package com.viafirma.mobile.services.sdk.java.api;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.viafirma.mobile.services.sdk.java.ApiException;
import com.viafirma.mobile.services.sdk.java.ApiInvoker;
import com.viafirma.mobile.services.sdk.java.model.Device;
import com.viafirma.mobile.services.sdk.java.model.Evidence;
import com.viafirma.mobile.services.sdk.java.model.Form;
import com.viafirma.mobile.services.sdk.java.model.Message;
import com.viafirma.mobile.services.sdk.java.model.Notification;
import com.viafirma.mobile.services.sdk.java.model.Policy;
import com.viafirma.mobile.services.sdk.java.model.Token;
import com.viafirma.mobile.services.sdk.java.model.User;

public class V1Api {
  String basePath = "/";
  String consumerKey = null;
  String consumerSecret = null;
  String token = null;
  String tokenSecret = null;

  ApiInvoker apiInvoker = ApiInvoker.getInstance();

  public ApiInvoker getInvoker() {
    return apiInvoker;
  }
  
  public void setBasePath(String basePath) {
    this.basePath = basePath;
  }
  
  public String getBasePath() {
    return basePath;
  }

  public void setConsumerKey(String consumerKey) {
     this.consumerKey = consumerKey;
  }

  public String getConsumerKey() {
    return consumerKey;
  }

  public void setConsumerSecret(String consumerSecret) {
    this.consumerSecret = consumerSecret;
  }

  public String getConsumerSecret() {
    return consumerSecret;
  }

  public String getToken() {
  	return token;
  }

  public void setToken(String token) {
  	this.token = token;
  }

  public String getTokenSecret() {
  	return tokenSecret;
  }

  public void setTokenSecret(String tokenSecret) {
  	this.tokenSecret = tokenSecret;
  }

  public Device registerDevice (Device body) throws ApiException {
    // verify required params are set
    if(body == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/devices".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "POST", queryParams, body, headerParams, formParams, contentType);
      if(response != null){
        return (Device) ApiInvoker.deserialize(response, "", Device.class);
      }else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public Device findDeviceByIdentifier (String identifier) throws ApiException {
    // verify required params are set
    if(identifier == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/devices/{identifier}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "identifier" + "\\}", apiInvoker.escapeString(identifier.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "GET", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (Device) ApiInvoker.deserialize(response, "", Device.class);
      }else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public List<Device> findDeviceByUser (String userCode) throws ApiException {
    // verify required params are set
    if(userCode == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/devices/user/{userCode}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "userCode" + "\\}", apiInvoker.escapeString(userCode.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "GET", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (List<Device>) ApiInvoker.deserialize(response, "Array", Device.class);
      }else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public byte[] getDocument (String type, String messageCode, String documentCode) throws ApiException {
    // verify required params are set
    if(type == null || messageCode == null || documentCode == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/documents/{type}/{messageCode}/{documentCode}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "type" + "\\}", apiInvoker.escapeString(type.toString())).replaceAll("\\{" + "messageCode" + "\\}", apiInvoker.escapeString(messageCode.toString())).replaceAll("\\{" + "documentCode" + "\\}", apiInvoker.escapeString(documentCode.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

      byte[] response = apiInvoker.invokeFileAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "GET", queryParams, null, headerParams, formParams, contentType);
      return response;
    
  }
  public Evidence sendEvidence (String messageCode, String policyCode, String evidenceCode, File body, String metadata, String fingerID, String algorithmic) throws ApiException {
    // create path and map variables
    String path = "/v1/evidences/upload".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    formParams.put("messageCode", messageCode);
    formParams.put("policyCode", policyCode);
    formParams.put("evidenceCode", evidenceCode);
    formParams.put("metadata", metadata);
    formParams.put("fingerID", fingerID);
    formParams.put("algorithmic", algorithmic);
    String[] contentTypes = {
      "multipart/form-data"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "POST", queryParams, body, headerParams, formParams, contentType);
      if(response != null){
        return (Evidence) ApiInvoker.deserialize(response, "", Evidence.class);
      }else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public List<Form> findFormsByUser (String code) throws ApiException {
    // verify required params are set
    if(code == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/form/user/{code}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "code" + "\\}", apiInvoker.escapeString(code.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "GET", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (List<Form>) ApiInvoker.deserialize(response, "Array", Form.class);
      }else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public String sendMessage (Message body) throws ApiException {
    // verify required params are set
    if(body == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/messages".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "POST", queryParams, body, headerParams, formParams, contentType);
      if(response != null){
        return (String) ApiInvoker.deserialize(response, "", String.class);
      }else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public Message getMessageByCode (String messageCode) throws ApiException {
    // verify required params are set
    if(messageCode == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/messages/{messageCode}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "messageCode" + "\\}", apiInvoker.escapeString(messageCode.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "GET", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (Message) ApiInvoker.deserialize(response, "", Message.class);
      }else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public String sendNotification (Notification body) throws ApiException {
    // verify required params are set
    if(body == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/notifications".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "POST", queryParams, body, headerParams, formParams, contentType);
      if(response != null){
        return (String) ApiInvoker.deserialize(response, "", String.class);
      }else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public List<Notification> findNotificationsByToken (String token) throws ApiException {
    // verify required params are set
    if(token == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/notifications/token/{token}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "token" + "\\}", apiInvoker.escapeString(token.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "GET", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (List<Notification>) ApiInvoker.deserialize(response, "Array", Notification.class);
      }else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public List<Notification> findNotificationsByTokenStatus (String token, String status) throws ApiException {
    // verify required params are set
    if(token == null || status == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/notifications/token/{token}/status/{status}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "token" + "\\}", apiInvoker.escapeString(token.toString())).replaceAll("\\{" + "status" + "\\}", apiInvoker.escapeString(status.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "GET", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (List<Notification>) ApiInvoker.deserialize(response, "Array", Notification.class);
      }else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public List<Notification> findNotificationsByCode (String code) throws ApiException {
    // verify required params are set
    if(code == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/notifications/code/{code}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "code" + "\\}", apiInvoker.escapeString(code.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "GET", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (List<Notification>) ApiInvoker.deserialize(response, "Array", Notification.class);
      }else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public void changeNotificationStatus (String code, String status) throws ApiException {
    // verify required params are set
    if(code == null || status == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/notifications/code/{code}/status/{status}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "code" + "\\}", apiInvoker.escapeString(code.toString())).replaceAll("\\{" + "status" + "\\}", apiInvoker.escapeString(status.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "PUT", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return ;
      }else {
        return ;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return ;
      }
      else {
        throw ex;
      }
    }
  }
  public Policy prepareSignature (String messageCode, String policyCode, String userCode) throws ApiException {
    // verify required params are set
    if(messageCode == null || policyCode == null || userCode == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/signatures/prepare".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    formParams.put("messageCode", messageCode);
    formParams.put("policyCode", policyCode);
    formParams.put("userCode", userCode);
    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "POST", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (Policy) ApiInvoker.deserialize(response, "", Policy.class);
      }else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public Policy registerSignature (String messageCode, String policyCode, String signatureCode) throws ApiException {
    // verify required params are set
    if(messageCode == null || policyCode == null || signatureCode == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/signatures/register".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    formParams.put("messageCode", messageCode);
    formParams.put("policyCode", policyCode);
    formParams.put("signatureCode", signatureCode);
    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "POST", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (Policy) ApiInvoker.deserialize(response, "", Policy.class);
      }else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public void registerUser (User body) throws ApiException {
    // verify required params are set
    if(body == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/users".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "POST", queryParams, body, headerParams, formParams, contentType);
      if(response != null){
        return ;
      }else {
        return ;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return ;
      }
      else {
        throw ex;
      }
    }
  }
  public User findUserByCode (String userCode) throws ApiException {
    // verify required params are set
    if(userCode == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/users/{userCode}".replaceAll("\\{format\\}","json").replaceAll("\\{" + "userCode" + "\\}", apiInvoker.escapeString(userCode.toString()));

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/json"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "GET", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (User) ApiInvoker.deserialize(response, "", User.class);
      }else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public Token postRequestToken () throws ApiException {
    // create path and map variables
    String path = "/v1/oauth/requestToken".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    String[] contentTypes = {
      "application/x-www-form-urlencoded"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "POST", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (Token) ApiInvoker.deserialize(response, "", Token.class);
      }else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  public Token postAccessToken (String x_auth_username, String x_auth_password, String x_auth_mode) throws ApiException {
    // verify required params are set
    if(x_auth_mode == null || x_auth_username == null || x_auth_password == null ) {
       throw new ApiException(400, "missing required params");
    }
    // create path and map variables
    String path = "/v1/oauth/accessToken".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    formParams.put("x_auth_mode", x_auth_mode);
    formParams.put("x_auth_username", x_auth_username);
    formParams.put("x_auth_password", x_auth_password);
    String[] contentTypes = {
      "application/x-www-form-urlencoded"};

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    try {
      String response = apiInvoker.invokeJsonAPI(basePath, consumerKey, consumerSecret, token, tokenSecret, path, "POST", queryParams, null, headerParams, formParams, contentType);
      if(response != null){
        return (Token) ApiInvoker.deserialize(response, "", Token.class);
      }else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return null;
      }
      else {
        throw ex;
      }
    }
  }
  }

