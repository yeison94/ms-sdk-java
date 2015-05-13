package com.viafirma.mobile.services.sdk.java.model;


import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Status  {
  
  private String current = null;
  private String next = null;

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("current")
  public String getCurrent() {
    return current;
  }
  public void setCurrent(String current) {
    this.current = current;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("next")
  public String getNext() {
    return next;
  }
  public void setNext(String next) {
    this.next = next;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Status {\n");
    
    sb.append("  current: ").append(current).append("\n");
    sb.append("  next: ").append(next).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
