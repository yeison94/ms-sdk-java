package com.viafirma.mobile.services.sdk.java.model;

import java.util.*;
import com.viafirma.mobile.services.sdk.java.model.FormValue;
import com.viafirma.mobile.services.sdk.java.model.Setting;
import com.viafirma.mobile.services.sdk.java.model.Container;
import com.viafirma.mobile.services.sdk.java.model.FormNestedValue;
public class Form {
  private String code = null;
  private String title = null;
  private String version = null;
  private String templateCode = null;
  private List<Container> containers = new ArrayList<Container>();
  private Setting setting = null;
  private List<FormValue> values = new ArrayList<FormValue>();
  private List<FormNestedValue> nestedValues = new ArrayList<FormNestedValue>();
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }

  public String getVersion() {
    return version;
  }
  public void setVersion(String version) {
    this.version = version;
  }

  public String getTemplateCode() {
    return templateCode;
  }
  public void setTemplateCode(String templateCode) {
    this.templateCode = templateCode;
  }

  public List<Container> getContainers() {
    return containers;
  }
  public void setContainers(List<Container> containers) {
    this.containers = containers;
  }

  public Setting getSetting() {
    return setting;
  }
  public void setSetting(Setting setting) {
    this.setting = setting;
  }

  public List<FormValue> getValues() {
    return values;
  }
  public void setValues(List<FormValue> values) {
    this.values = values;
  }

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
    sb.append("  version: ").append(version).append("\n");
    sb.append("  templateCode: ").append(templateCode).append("\n");
    sb.append("  containers: ").append(containers).append("\n");
    sb.append("  setting: ").append(setting).append("\n");
    sb.append("  values: ").append(values).append("\n");
    sb.append("  nestedValues: ").append(nestedValues).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

