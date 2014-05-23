package com.viafirma.mobile.services.sdk.java.model;

import com.viafirma.mobile.services.sdk.java.model.Policy;
public class Setting {
  private String titleKey = null;
  private String descriptionKey = null;
  private Policy policy = null;
  private String callbackURL = null;
  public String getTitleKey() {
    return titleKey;
  }
  public void setTitleKey(String titleKey) {
    this.titleKey = titleKey;
  }

  public String getDescriptionKey() {
    return descriptionKey;
  }
  public void setDescriptionKey(String descriptionKey) {
    this.descriptionKey = descriptionKey;
  }

  public Policy getPolicy() {
    return policy;
  }
  public void setPolicy(Policy policy) {
    this.policy = policy;
  }

  public String getCallbackURL() {
    return callbackURL;
  }
  public void setCallbackURL(String callbackURL) {
    this.callbackURL = callbackURL;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Setting {\n");
    sb.append("  titleKey: ").append(titleKey).append("\n");
    sb.append("  descriptionKey: ").append(descriptionKey).append("\n");
    sb.append("  policy: ").append(policy).append("\n");
    sb.append("  callbackURL: ").append(callbackURL).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

