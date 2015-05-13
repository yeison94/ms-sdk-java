package com.viafirma.mobile.services.sdk.java.model;

import com.viafirma.mobile.services.sdk.java.model.FormNestedValue;
import com.viafirma.mobile.services.sdk.java.model.Setting;
import com.viafirma.mobile.services.sdk.java.model.FormValue;
import java.util.*;
import com.viafirma.mobile.services.sdk.java.model.Container;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Form  {
  
  private String code = null;
  private String title = null;
  private String description = null;
  private String version = null;
  private String templateCode = null;
  private List<Container> containers = new ArrayList<Container>() ;
  private Setting settings = null;
  private List<FormValue> values = new ArrayList<FormValue>() ;
  private List<FormNestedValue> nestedValues = new ArrayList<FormNestedValue>() ;

  
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
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("title")
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
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
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("version")
  public String getVersion() {
    return version;
  }
  public void setVersion(String version) {
    this.version = version;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("templateCode")
  public String getTemplateCode() {
    return templateCode;
  }
  public void setTemplateCode(String templateCode) {
    this.templateCode = templateCode;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("containers")
  public List<Container> getContainers() {
    return containers;
  }
  public void setContainers(List<Container> containers) {
    this.containers = containers;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("settings")
  public Setting getSettings() {
    return settings;
  }
  public void setSettings(Setting settings) {
    this.settings = settings;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("values")
  public List<FormValue> getValues() {
    return values;
  }
  public void setValues(List<FormValue> values) {
    this.values = values;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("nestedValues")
  public List<FormNestedValue> getNestedValues() {
    return nestedValues;
  }
  public void setNestedValues(List<FormNestedValue> nestedValues) {
    this.nestedValues = nestedValues;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Form {\n");
    
    sb.append("  code: ").append(code).append("\n");
    sb.append("  title: ").append(title).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  version: ").append(version).append("\n");
    sb.append("  templateCode: ").append(templateCode).append("\n");
    sb.append("  containers: ").append(containers).append("\n");
    sb.append("  settings: ").append(settings).append("\n");
    sb.append("  values: ").append(values).append("\n");
    sb.append("  nestedValues: ").append(nestedValues).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
