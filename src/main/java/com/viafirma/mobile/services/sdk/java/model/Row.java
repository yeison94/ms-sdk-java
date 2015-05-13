package com.viafirma.mobile.services.sdk.java.model;

import com.viafirma.mobile.services.sdk.java.model.Item;
import java.util.*;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Row  {
  
  private List<Item> items = new ArrayList<Item>() ;

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("items")
  public List<Item> getItems() {
    return items;
  }
  public void setItems(List<Item> items) {
    this.items = items;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Row {\n");
    
    sb.append("  items: ").append(items).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
