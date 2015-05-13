package com.viafirma.mobile.services.sdk.java.model;

import java.util.Date;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Download  {
  
  private String link = null;
  private String md5 = null;
  private String fileName = null;
  private Date expires = null;

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("link")
  public String getLink() {
    return link;
  }
  public void setLink(String link) {
    this.link = link;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("md5")
  public String getMd5() {
    return md5;
  }
  public void setMd5(String md5) {
    this.md5 = md5;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("fileName")
  public String getFileName() {
    return fileName;
  }
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("expires")
  public Date getExpires() {
    return expires;
  }
  public void setExpires(Date expires) {
    this.expires = expires;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Download {\n");
    
    sb.append("  link: ").append(link).append("\n");
    sb.append("  md5: ").append(md5).append("\n");
    sb.append("  fileName: ").append(fileName).append("\n");
    sb.append("  expires: ").append(expires).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
