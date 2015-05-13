package com.viafirma.mobile.services.sdk.java.model;

import com.viafirma.mobile.services.sdk.java.model.Rectangle;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Position  {
  
  private Rectangle rectangle = null;
  private Integer page = null;

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("rectangle")
  public Rectangle getRectangle() {
    return rectangle;
  }
  public void setRectangle(Rectangle rectangle) {
    this.rectangle = rectangle;
  }

  
  /**
   **/
  @ApiModelProperty(required = true, value = "")
  @JsonProperty("page")
  public Integer getPage() {
    return page;
  }
  public void setPage(Integer page) {
    this.page = page;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Position {\n");
    
    sb.append("  rectangle: ").append(rectangle).append("\n");
    sb.append("  page: ").append(page).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
