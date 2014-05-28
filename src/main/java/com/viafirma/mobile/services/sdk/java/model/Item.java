package com.viafirma.mobile.services.sdk.java.model;

import java.util.*;
public class Item {
  private String key = null;
  private String value = null;
  private String type = null;
  private String label = null;
  private String placeHolder = null;
  private String size = null;
  private Boolean required = null;
  private String validation = null;
  private String validationRegex = null;
  private String refValues = null;
  private String list = null;
  private String nestedList = null;
  private String text = null;
  private String href = null;
  private String match = null;
  private String update = null;
  private Boolean disabled = null;
  private List<String> values = new ArrayList<String>();
  private String height = null;
  private String format = null;
  private String maxLength = null;
  private String minLength = null;
  private List<String> monthNames = new ArrayList<String>();
  private List<String> dayNames = new ArrayList<String>();
  public String getKey() {
    return key;
  }
  public void setKey(String key) {
    this.key = key;
  }

  public String getValue() {
    return value;
  }
  public void setValue(String value) {
    this.value = value;
  }

  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  public String getLabel() {
    return label;
  }
  public void setLabel(String label) {
    this.label = label;
  }

  public String getPlaceHolder() {
    return placeHolder;
  }
  public void setPlaceHolder(String placeHolder) {
    this.placeHolder = placeHolder;
  }

  public String getSize() {
    return size;
  }
  public void setSize(String size) {
    this.size = size;
  }

  public Boolean getRequired() {
    return required;
  }
  public void setRequired(Boolean required) {
    this.required = required;
  }

  public String getValidation() {
    return validation;
  }
  public void setValidation(String validation) {
    this.validation = validation;
  }

  public String getValidationRegex() {
    return validationRegex;
  }
  public void setValidationRegex(String validationRegex) {
    this.validationRegex = validationRegex;
  }

  public String getRefValues() {
    return refValues;
  }
  public void setRefValues(String refValues) {
    this.refValues = refValues;
  }

  public String getList() {
    return list;
  }
  public void setList(String list) {
    this.list = list;
  }

  public String getNestedList() {
    return nestedList;
  }
  public void setNestedList(String nestedList) {
    this.nestedList = nestedList;
  }

  public String getText() {
    return text;
  }
  public void setText(String text) {
    this.text = text;
  }

  public String getHref() {
    return href;
  }
  public void setHref(String href) {
    this.href = href;
  }

  public String getMatch() {
    return match;
  }
  public void setMatch(String match) {
    this.match = match;
  }

  public String getUpdate() {
    return update;
  }
  public void setUpdate(String update) {
    this.update = update;
  }

  public Boolean getDisabled() {
    return disabled;
  }
  public void setDisabled(Boolean disabled) {
    this.disabled = disabled;
  }

  public List<String> getValues() {
    return values;
  }
  public void setValues(List<String> values) {
    this.values = values;
  }

  public String getHeight() {
    return height;
  }
  public void setHeight(String height) {
    this.height = height;
  }

  public String getFormat() {
    return format;
  }
  public void setFormat(String format) {
    this.format = format;
  }

  public String getMaxLength() {
    return maxLength;
  }
  public void setMaxLength(String maxLength) {
    this.maxLength = maxLength;
  }

  public String getMinLength() {
    return minLength;
  }
  public void setMinLength(String minLength) {
    this.minLength = minLength;
  }

  public List<String> getMonthNames() {
    return monthNames;
  }
  public void setMonthNames(List<String> monthNames) {
    this.monthNames = monthNames;
  }

  public List<String> getDayNames() {
    return dayNames;
  }
  public void setDayNames(List<String> dayNames) {
    this.dayNames = dayNames;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Item {\n");
    sb.append("  key: ").append(key).append("\n");
    sb.append("  value: ").append(value).append("\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  label: ").append(label).append("\n");
    sb.append("  placeHolder: ").append(placeHolder).append("\n");
    sb.append("  size: ").append(size).append("\n");
    sb.append("  required: ").append(required).append("\n");
    sb.append("  validation: ").append(validation).append("\n");
    sb.append("  validationRegex: ").append(validationRegex).append("\n");
    sb.append("  refValues: ").append(refValues).append("\n");
    sb.append("  list: ").append(list).append("\n");
    sb.append("  nestedList: ").append(nestedList).append("\n");
    sb.append("  text: ").append(text).append("\n");
    sb.append("  href: ").append(href).append("\n");
    sb.append("  match: ").append(match).append("\n");
    sb.append("  update: ").append(update).append("\n");
    sb.append("  disabled: ").append(disabled).append("\n");
    sb.append("  values: ").append(values).append("\n");
    sb.append("  height: ").append(height).append("\n");
    sb.append("  format: ").append(format).append("\n");
    sb.append("  maxLength: ").append(maxLength).append("\n");
    sb.append("  minLength: ").append(minLength).append("\n");
    sb.append("  monthNames: ").append(monthNames).append("\n");
    sb.append("  dayNames: ").append(dayNames).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
