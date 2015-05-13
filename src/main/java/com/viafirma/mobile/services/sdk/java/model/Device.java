package com.viafirma.mobile.services.sdk.java.model;


import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Device  {
  
  private String appCode = null;
  private String code = null;
  private String description = null;
  private String locale = null;
  public enum StatusEnum {
     ACTIVE,  INACTIVE, 
  };
  private StatusEnum status = null;
  private String token = null;
  private String uniqueIdentifier = null;
  public enum TypeEnum {
     ANDROID,  IOS,  WP, 
  };
  private TypeEnum type = null;
  private String userEmail = null;
  private String userCode = null;
  private String userNationalId = null;

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
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
  @JsonProperty("code")
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("locale")
  public String getLocale() {
    return locale;
  }
  public void setLocale(String locale) {
    this.locale = locale;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("status")
  public StatusEnum getStatus() {
    return status;
  }
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("token")
  public String getToken() {
    return token;
  }
  public void setToken(String token) {
    this.token = token;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("uniqueIdentifier")
  public String getUniqueIdentifier() {
    return uniqueIdentifier;
  }
  public void setUniqueIdentifier(String uniqueIdentifier) {
    this.uniqueIdentifier = uniqueIdentifier;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("type")
  public TypeEnum getType() {
    return type;
  }
  public void setType(TypeEnum type) {
    this.type = type;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("userEmail")
  public String getUserEmail() {
    return userEmail;
  }
  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
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
  @JsonProperty("userNationalId")
  public String getUserNationalId() {
    return userNationalId;
  }
  public void setUserNationalId(String userNationalId) {
    this.userNationalId = userNationalId;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Device {\n");
    
    sb.append("  appCode: ").append(appCode).append("\n");
    sb.append("  code: ").append(code).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  locale: ").append(locale).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  token: ").append(token).append("\n");
    sb.append("  uniqueIdentifier: ").append(uniqueIdentifier).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  userEmail: ").append(userEmail).append("\n");
    sb.append("  userCode: ").append(userCode).append("\n");
    sb.append("  userNationalId: ").append(userNationalId).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
