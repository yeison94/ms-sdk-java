package com.viafirma.mobile.services.sdk.java.model;

import java.util.*;
public class FormValue {
  private String key = null;
  private List<String> values = new ArrayList<String>();
  public String getKey() {
    return key;
  }
  public void setKey(String key) {
    this.key = key;
  }

  public List<String> getValues() {
    return values;
  }
  public void setValues(List<String> values) {
    this.values = values;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormValue {\n");
    sb.append("  key: ").append(key).append("\n");
    sb.append("  values: ").append(values).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

