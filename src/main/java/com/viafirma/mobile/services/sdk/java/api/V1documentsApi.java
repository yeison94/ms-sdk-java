package com.viafirma.mobile.services.sdk.java.api;

import com.viafirma.mobile.services.sdk.java.ApiException;
import com.viafirma.mobile.services.sdk.java.ApiInvoker;

import com.viafirma.mobile.services.sdk.java.model.*;

import java.util.*;

import com.viafirma.mobile.services.sdk.java.model.Download;

import com.sun.jersey.multipart.FormDataMultiPart;

import javax.ws.rs.core.MediaType;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class V1documentsApi {

  private static final V1documentsApi INSTANCE = new V1documentsApi();
  private V1documentsApi(){}
  public static V1documentsApi getInstance() {
    return INSTANCE;
  }
  
  
    
  public Download downloadPreview (String messageCode) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/v1/documents/download/preview/{messageCode}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "messageCode" + "\\}", ApiInvoker.getInstance().escapeString(messageCode.toString()));

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
        return (Download) ApiInvoker.deserialize(response, "", Download.class);
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
  
    
  public Download downloadSigned (String messageCode) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/v1/documents/download/signed/{messageCode}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "messageCode" + "\\}", ApiInvoker.getInstance().escapeString(messageCode.toString()));

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
        return (Download) ApiInvoker.deserialize(response, "", Download.class);
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
  
    
  public Download downloadTemporal (String messageCode) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/v1/documents/download/temporal/{messageCode}".replaceAll("\\{format\\}","json")
      .replaceAll("\\{" + "messageCode" + "\\}", ApiInvoker.getInstance().escapeString(messageCode.toString()));

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
        return (Download) ApiInvoker.deserialize(response, "", Download.class);
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
