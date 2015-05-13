package com.viafirma.mobile.services.sdk.java.model;


import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class User  {
  
  private String code = null;
  private String nationalId = null;
  private String email = null;
  private String password = null;
  private String name = null;
  private String surname = null;
  private String rol = null;
  private String description = null;
  private String viafirmaKey = null;
  private String viafirmaPassword = null;
  private String viafirmaCertificate = null;
  private String region = null;
  private String pos = null;
  private String mobile = null;
  private String channel = null;

  
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
  @JsonProperty("nationalId")
  public String getNationalId() {
    return nationalId;
  }
  public void setNationalId(String nationalId) {
    this.nationalId = nationalId;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("password")
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("surname")
  public String getSurname() {
    return surname;
  }
  public void setSurname(String surname) {
    this.surname = surname;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("rol")
  public String getRol() {
    return rol;
  }
  public void setRol(String rol) {
    this.rol = rol;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("viafirmaKey")
  public String getViafirmaKey() {
    return viafirmaKey;
  }
  public void setViafirmaKey(String viafirmaKey) {
    this.viafirmaKey = viafirmaKey;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("viafirmaPassword")
  public String getViafirmaPassword() {
    return viafirmaPassword;
  }
  public void setViafirmaPassword(String viafirmaPassword) {
    this.viafirmaPassword = viafirmaPassword;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("viafirmaCertificate")
  public String getViafirmaCertificate() {
    return viafirmaCertificate;
  }
  public void setViafirmaCertificate(String viafirmaCertificate) {
    this.viafirmaCertificate = viafirmaCertificate;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("region")
  public String getRegion() {
    return region;
  }
  public void setRegion(String region) {
    this.region = region;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("pos")
  public String getPos() {
    return pos;
  }
  public void setPos(String pos) {
    this.pos = pos;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("mobile")
  public String getMobile() {
    return mobile;
  }
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("channel")
  public String getChannel() {
    return channel;
  }
  public void setChannel(String channel) {
    this.channel = channel;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("  code: ").append(code).append("\n");
    sb.append("  nationalId: ").append(nationalId).append("\n");
    sb.append("  email: ").append(email).append("\n");
    sb.append("  password: ").append(password).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  surname: ").append(surname).append("\n");
    sb.append("  rol: ").append(rol).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  viafirmaKey: ").append(viafirmaKey).append("\n");
    sb.append("  viafirmaPassword: ").append(viafirmaPassword).append("\n");
    sb.append("  viafirmaCertificate: ").append(viafirmaCertificate).append("\n");
    sb.append("  region: ").append(region).append("\n");
    sb.append("  pos: ").append(pos).append("\n");
    sb.append("  mobile: ").append(mobile).append("\n");
    sb.append("  channel: ").append(channel).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
