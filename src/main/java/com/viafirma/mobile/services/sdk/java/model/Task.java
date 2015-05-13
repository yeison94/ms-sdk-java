package com.viafirma.mobile.services.sdk.java.model;


import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Task  {
  
  private String code = null;
  private Boolean finalStatus = null;
  private Integer numThreads = null;
  private String cacheName = null;
  private String classRef = null;

  
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
  @JsonProperty("finalStatus")
  public Boolean getFinalStatus() {
    return finalStatus;
  }
  public void setFinalStatus(Boolean finalStatus) {
    this.finalStatus = finalStatus;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("numThreads")
  public Integer getNumThreads() {
    return numThreads;
  }
  public void setNumThreads(Integer numThreads) {
    this.numThreads = numThreads;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("cacheName")
  public String getCacheName() {
    return cacheName;
  }
  public void setCacheName(String cacheName) {
    this.cacheName = cacheName;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("classRef")
  public String getClassRef() {
    return classRef;
  }
  public void setClassRef(String classRef) {
    this.classRef = classRef;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Task {\n");
    
    sb.append("  code: ").append(code).append("\n");
    sb.append("  finalStatus: ").append(finalStatus).append("\n");
    sb.append("  numThreads: ").append(numThreads).append("\n");
    sb.append("  cacheName: ").append(cacheName).append("\n");
    sb.append("  classRef: ").append(classRef).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
