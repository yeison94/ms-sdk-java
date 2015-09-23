package com.viafirma.mobile.services.sdk.java.model;

import com.viafirma.mobile.services.sdk.java.model.Document;
import com.viafirma.mobile.services.sdk.java.model.Param;
import com.viafirma.mobile.services.sdk.java.model.Workflow;
import java.util.Date;
import com.viafirma.mobile.services.sdk.java.model.Policy;
import com.viafirma.mobile.services.sdk.java.model.ErrorResponse;
import java.util.*;
import com.viafirma.mobile.services.sdk.java.model.Notification;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Message  {
  
  private String code = null;
  private String userCode = null;
  private String groupCode = null;
  private String appCode = null;
  private String version = null;
  private Workflow workflow = null;
  private Notification notification = null;
  private Document document = null;
  private List<Param> metadataList = new ArrayList<Param>() ;
  private List<Policy> policies = new ArrayList<Policy>() ;
  private String callbackURL = null;
  private String callbackMails = null;
  private List<String> callbackMailsFormKeys = new ArrayList<String>() ;
  private ErrorResponse error = null;
  private String pid = null;
  private String server = null;
  private Date processTimeExpired = null;
  private String commentReject = null;

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("code")
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("userCode")
  public String getUserCode() {
    return userCode;
  }
  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("groupCode")
  public String getGroupCode() {
    return groupCode;
  }
  public void setGroupCode(String groupCode) {
    this.groupCode = groupCode;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("appCode")
  public String getAppCode() {
    return appCode;
  }
  public void setAppCode(String appCode) {
    this.appCode = appCode;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("version")
  public String getVersion() {
    return version;
  }
  public void setVersion(String version) {
    this.version = version;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("workflow")
  public Workflow getWorkflow() {
    return workflow;
  }
  public void setWorkflow(Workflow workflow) {
    this.workflow = workflow;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("notification")
  public Notification getNotification() {
    return notification;
  }
  public void setNotification(Notification notification) {
    this.notification = notification;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("document")
  public Document getDocument() {
    return document;
  }
  public void setDocument(Document document) {
    this.document = document;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("metadataList")
  public List<Param> getMetadataList() {
    return metadataList;
  }
  public void setMetadataList(List<Param> metadataList) {
    this.metadataList = metadataList;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("policies")
  public List<Policy> getPolicies() {
    return policies;
  }
  public void setPolicies(List<Policy> policies) {
    this.policies = policies;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("callbackURL")
  public String getCallbackURL() {
    return callbackURL;
  }
  public void setCallbackURL(String callbackURL) {
    this.callbackURL = callbackURL;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("callbackMails")
  public String getCallbackMails() {
    return callbackMails;
  }
  public void setCallbackMails(String callbackMails) {
    this.callbackMails = callbackMails;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("callbackMailsFormKeys")
  public List<String> getCallbackMailsFormKeys() {
    return callbackMailsFormKeys;
  }
  public void setCallbackMailsFormKeys(List<String> callbackMailsFormKeys) {
    this.callbackMailsFormKeys = callbackMailsFormKeys;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("error")
  public ErrorResponse getError() {
    return error;
  }
  public void setError(ErrorResponse error) {
    this.error = error;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("pid")
  public String getPid() {
    return pid;
  }
  public void setPid(String pid) {
    this.pid = pid;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("server")
  public String getServer() {
    return server;
  }
  public void setServer(String server) {
    this.server = server;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("processTimeExpired")
  public Date getProcessTimeExpired() {
    return processTimeExpired;
  }
  public void setProcessTimeExpired(Date processTimeExpired) {
    this.processTimeExpired = processTimeExpired;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("commentReject")
  public String getCommentReject() {
    return commentReject;
  }
  public void setCommentReject(String commentReject) {
    this.commentReject = commentReject;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Message {\n");
    
    sb.append("  code: ").append(code).append("\n");
    sb.append("  userCode: ").append(userCode).append("\n");
    sb.append("  groupCode: ").append(groupCode).append("\n");
    sb.append("  appCode: ").append(appCode).append("\n");
    sb.append("  version: ").append(version).append("\n");
    sb.append("  workflow: ").append(workflow).append("\n");
    sb.append("  notification: ").append(notification).append("\n");
    sb.append("  document: ").append(document).append("\n");
    sb.append("  metadataList: ").append(metadataList).append("\n");
    sb.append("  policies: ").append(policies).append("\n");
    sb.append("  callbackURL: ").append(callbackURL).append("\n");
    sb.append("  callbackMails: ").append(callbackMails).append("\n");
    sb.append("  callbackMailsFormKeys: ").append(callbackMailsFormKeys).append("\n");
    sb.append("  error: ").append(error).append("\n");
    sb.append("  pid: ").append(pid).append("\n");
    sb.append("  server: ").append(server).append("\n");
    sb.append("  processTimeExpired: ").append(processTimeExpired).append("\n");
    sb.append("  commentReject: ").append(commentReject).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
