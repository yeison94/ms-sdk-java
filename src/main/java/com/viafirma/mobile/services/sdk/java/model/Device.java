package com.viafirma.mobile.services.sdk.java.model;

public class Device {
  private String appCode = null;
  private String code = null;
  private String description = null;
  private String locale = null;
  private String status = null;
  //public enum statusEnum { ACTIVE, INACTIVE, }; 
  private String token = null;
  private String uniqueIdentifier = null;
  private String type = null;
  //public enum typeEnum { ANDROID, IOS, WP, }; 
  private String userEmail = null;
  private String userCode = null;
  private String userNationalId = null;
  public String getAppCode() {
    return appCode;
  }
  public void setAppCode(String appCode) {
    this.appCode = appCode;
  }

  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public String getLocale() {
    return locale;
  }
  public void setLocale(String locale) {
    this.locale = locale;
  }

  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }

  public String getToken() {
    return token;
  }
  public void setToken(String token) {
    this.token = token;
  }

  public String getUniqueIdentifier() {
    return uniqueIdentifier;
  }
  public void setUniqueIdentifier(String uniqueIdentifier) {
    this.uniqueIdentifier = uniqueIdentifier;
  }

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  public String getUserEmail() {
    return userEmail;
  }
  public void setUserEmail(String userEmail) {
    this.userEmail = userEmail;
  }

  public String getUserCode() {
    return userCode;
  }
  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

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

