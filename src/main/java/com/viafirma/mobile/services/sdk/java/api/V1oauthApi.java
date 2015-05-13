package com.viafirma.mobile.services.sdk.java.api;

import com.viafirma.mobile.services.sdk.java.ApiException;
import com.viafirma.mobile.services.sdk.java.ApiInvoker;

import com.viafirma.mobile.services.sdk.java.model.*;

import java.util.*;

import com.viafirma.mobile.services.sdk.java.model.Token;

import com.sun.jersey.multipart.FormDataMultiPart;

import javax.ws.rs.core.MediaType;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class V1oauthApi {

  private static final V1oauthApi INSTANCE = new V1oauthApi();
  private V1oauthApi(){}
  public static V1oauthApi getInstance() {
    return INSTANCE;
  }
  
  
    
  public Token accessToken (String x_auth_mode, String x_auth_username, String x_auth_password) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/v1/oauth/accessToken".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    
    
    String[] contentTypes = {
      "application/x-www-form-urlencoded"
    };

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      hasFields = true;
      mp.field("x_auth_mode", x_auth_mode, MediaType.MULTIPART_FORM_DATA_TYPE);
      
      hasFields = true;
      mp.field("x_auth_username", x_auth_username, MediaType.MULTIPART_FORM_DATA_TYPE);
      
      hasFields = true;
      mp.field("x_auth_password", x_auth_password, MediaType.MULTIPART_FORM_DATA_TYPE);
      
      if(hasFields)
        postBody = mp;
    }
    else {
      formParams.put("x_auth_mode", x_auth_mode);
      formParams.put("x_auth_username", x_auth_username);
      formParams.put("x_auth_password", x_auth_password);
      
    }

    try {
      String response = ApiInvoker.getInstance().invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (Token) ApiInvoker.deserialize(response, "", Token.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return  null;
      }
      else {
        throw ex;
      }
    }
  }
  
    
  public Token requestToken () throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/v1/oauth/requestToken".replaceAll("\\{format\\}","json");

    // query params
    Map<String, String> queryParams = new HashMap<String, String>();
    Map<String, String> headerParams = new HashMap<String, String>();
    Map<String, String> formParams = new HashMap<String, String>();

    
    
    String[] contentTypes = {
      
    };

    String contentType = contentTypes.length > 0 ? contentTypes[0] : "application/json";

    if(contentType.startsWith("multipart/form-data")) {
      boolean hasFields = false;
      FormDataMultiPart mp = new FormDataMultiPart();
      
      if(hasFields)
        postBody = mp;
    }
    else {
      
    }

    try {
      String response = ApiInvoker.getInstance().invokeAPI(path, "GET", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (Token) ApiInvoker.deserialize(response, "", Token.class);
      }
      else {
        return null;
      }
    } catch (ApiException ex) {
      if(ex.getCode() == 404) {
      	return  null;
      }
      else {
        throw ex;
      }
    }
  }
  
}
