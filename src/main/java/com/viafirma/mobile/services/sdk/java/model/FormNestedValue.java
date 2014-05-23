package com.viafirma.mobile.services.sdk.java.model;

import java.util.*;
import com.viafirma.mobile.services.sdk.java.model.FormValue;
public class FormNestedValue {
  private String key = null;
  private List<FormValue> values = new ArrayList<FormValue>();
  public String getKey() {
    return key;
  }
  public void setKey(String key) {
    this.key = key;
  }

  public List<FormValue> getValues() {
    return values;
  }
  public void setValues(List<FormValue> values) {
    this.values = values;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class FormNestedValue {\n");
    sb.append("  key: ").append(key).append("\n");
    sb.append("  values: ").append(values).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

