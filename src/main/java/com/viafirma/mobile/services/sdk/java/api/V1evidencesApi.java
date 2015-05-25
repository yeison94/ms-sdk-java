package com.viafirma.mobile.services.sdk.java.api;

import com.viafirma.mobile.services.sdk.java.ApiException;
import com.viafirma.mobile.services.sdk.java.ApiInvoker;

import com.viafirma.mobile.services.sdk.java.model.*;

import java.util.*;

import com.viafirma.mobile.services.sdk.java.model.Evidence;

import com.sun.jersey.multipart.FormDataMultiPart;

import javax.ws.rs.core.MediaType;

import java.io.File;
import java.util.Map;
import java.util.HashMap;

public class V1evidencesApi {

  private static final V1evidencesApi INSTANCE = new V1evidencesApi();
  private V1evidencesApi(){}
  public static V1evidencesApi getInstance() {
    return INSTANCE;
  }
  
  
    
  public Evidence sendEvidence (String messageCode, String policyCode, String evidenceCode, String imageBase64, String metadata, String fingerID, String algorithmic) throws ApiException {
    Object postBody = null;
    

    // create path and map variables
    String path = "/v1/evidences".replaceAll("\\{format\\}","json");

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
      mp.field("messageCode", messageCode, MediaType.MULTIPART_FORM_DATA_TYPE);
      
      hasFields = true;
      mp.field("policyCode", policyCode, MediaType.MULTIPART_FORM_DATA_TYPE);
      
      hasFields = true;
      mp.field("evidenceCode", evidenceCode, MediaType.MULTIPART_FORM_DATA_TYPE);
      
      hasFields = true;
      mp.field("imageBase64", imageBase64, MediaType.MULTIPART_FORM_DATA_TYPE);
      
      hasFields = true;
      mp.field("metadata", metadata, MediaType.MULTIPART_FORM_DATA_TYPE);
      
      hasFields = true;
      mp.field("fingerID", fingerID, MediaType.MULTIPART_FORM_DATA_TYPE);
      
      hasFields = true;
      mp.field("algorithmic", algorithmic, MediaType.MULTIPART_FORM_DATA_TYPE);
      
      if(hasFields)
        postBody = mp;
    }
    else {
      formParams.put("messageCode", messageCode);
      formParams.put("policyCode", policyCode);
      formParams.put("evidenceCode", evidenceCode);
      formParams.put("imageBase64", imageBase64);
      formParams.put("metadata", metadata);
      formParams.put("fingerID", fingerID);
      formParams.put("algorithmic", algorithmic);
      
    }

    try {
      String response = ApiInvoker.getInstance().invokeAPI(path, "POST", queryParams, postBody, headerParams, formParams, contentType);
      if(response != null){
        return (Evidence) ApiInvoker.deserialize(response, "", Evidence.class);
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
