package com.viafirma.mobile.services.sdk.java.model;

import com.viafirma.mobile.services.sdk.java.model.Param;
import com.viafirma.mobile.services.sdk.java.model.Device;
import java.util.*;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Notification  {
  
  private String code = null;
  private String validateCode = null;
  private String text = null;
  private String detail = null;
  private String sound = null;
  public enum StatusEnum {
     DISPATCHED,  DISPOSED,  READ,  RECEIVED,  COMPLETED,  REJECTED,  EXPIRED, 
  };
  private StatusEnum status = null;
  private String location = null;
  private List<Param> metadata = new ArrayList<Param>() ;
  private List<Device> devices = new ArrayList<Device>() ;

  
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
  @JsonProperty("validateCode")
  public String getValidateCode() {
    return validateCode;
  }
  public void setValidateCode(String validateCode) {
    this.validateCode = validateCode;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("text")
  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("detail")
  public String getDetail() {
    return detail;
  }
  public void setDetail(String detail) {
    this.detail = detail;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("sound")
  public String getSound() {
    return sound;
  }
  public void setSound(String sound) {
    this.sound = sound;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
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
  @JsonProperty("location")
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("metadata")
  public List<Param> getMetadata() {
    return metadata;
  }
  public void setMetadata(List<Param> metadata) {
    this.metadata = metadata;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("devices")
  public List<Device> getDevices() {
    return devices;
  }
  public void setDevices(List<Device> devices) {
    this.devices = devices;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Notification {\n");
    
    sb.append("  code: ").append(code).append("\n");
    sb.append("  validateCode: ").append(validateCode).append("\n");
    sb.append("  text: ").append(text).append("\n");
    sb.append("  detail: ").append(detail).append("\n");
    sb.append("  sound: ").append(sound).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  location: ").append(location).append("\n");
    sb.append("  metadata: ").append(metadata).append("\n");
    sb.append("  devices: ").append(devices).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
