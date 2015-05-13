package com.viafirma.mobile.services.sdk.java.model;


import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class MailConfig  {
  
  private Boolean required = null;
  private Boolean visible = null;
  private String default_value = null;

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("required")
  public Boolean getRequired() {
    return required;
  }
  public void setRequired(Boolean required) {
    this.required = required;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("visible")
  public Boolean getVisible() {
    return visible;
  }
  public void setVisible(Boolean visible) {
    this.visible = visible;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("default_value")
  public String getDefault_value() {
    return default_value;
  }
  public void setDefault_value(String default_value) {
    this.default_value = default_value;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class MailConfig {\n");
    
    sb.append("  required: ").append(required).append("\n");
    sb.append("  visible: ").append(visible).append("\n");
    sb.append("  default_value: ").append(default_value).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
