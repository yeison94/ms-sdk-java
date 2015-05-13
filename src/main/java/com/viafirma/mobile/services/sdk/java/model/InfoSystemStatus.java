package com.viafirma.mobile.services.sdk.java.model;

import com.viafirma.mobile.services.sdk.java.model.SystemStatus;
import java.util.*;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class InfoSystemStatus  {
  
  private String date = null;
  private List<SystemStatus> info = new ArrayList<SystemStatus>() ;

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("date")
  public String getDate() {
    return date;
  }
  public void setDate(String date) {
    this.date = date;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("info")
  public List<SystemStatus> getInfo() {
    return info;
  }
  public void setInfo(List<SystemStatus> info) {
    this.info = info;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class InfoSystemStatus {\n");
    
    sb.append("  date: ").append(date).append("\n");
    sb.append("  info: ").append(info).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
