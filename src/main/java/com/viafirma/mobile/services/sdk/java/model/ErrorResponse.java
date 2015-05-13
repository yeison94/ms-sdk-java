package com.viafirma.mobile.services.sdk.java.model;


import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class ErrorResponse  {
  
  private Integer code = null;
  private String type = null;
  private String message = null;
  private String trace = null;

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("code")
  public Integer getCode() {
    return code;
  }
  public void setCode(Integer code) {
    this.code = code;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("type")
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("trace")
  public String getTrace() {
    return trace;
  }
  public void setTrace(String trace) {
    this.trace = trace;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    
    sb.append("  code: ").append(code).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("  trace: ").append(trace).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
