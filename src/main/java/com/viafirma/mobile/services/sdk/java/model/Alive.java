package com.viafirma.mobile.services.sdk.java.model;


import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Alive  {
  
  private String isAlive = null;
  private String pid = null;

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("isAlive")
  public String getIsAlive() {
    return isAlive;
  }
  public void setIsAlive(String isAlive) {
    this.isAlive = isAlive;
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

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Alive {\n");
    
    sb.append("  isAlive: ").append(isAlive).append("\n");
    sb.append("  pid: ").append(pid).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
