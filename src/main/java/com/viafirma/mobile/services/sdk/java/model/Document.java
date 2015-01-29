package com.viafirma.mobile.services.sdk.java.model;

import java.util.*;
import com.viafirma.mobile.services.sdk.java.model.Item;
public class Document {
  private String templateCode = null;
  private String templateReference = null;
  private String draftedCode = null;
  private String draftedReference = null;
  private String signedCode = null;
  private String signedReference = null;
  private String templateType = null;
  //public enum templateTypeEnum { docx, odt, url, }; 
  private List<Item> items = new ArrayList<Item>();
  public String getTemplateCode() {
    return templateCode;
  }
  public void setTemplateCode(String templateCode) {
    this.templateCode = templateCode;
  }

  public String getTemplateReference() {
    return templateReference;
  }
  public void setTemplateReference(String templateReference) {
    this.templateReference = templateReference;
  }

  public String getDraftedCode() {
    return draftedCode;
  }
  public void setDraftedCode(String draftedCode) {
    this.draftedCode = draftedCode;
  }

  public String getDraftedReference() {
    return draftedReference;
  }
  public void setDraftedReference(String draftedReference) {
    this.draftedReference = draftedReference;
  }

  public String getSignedCode() {
    return signedCode;
  }
  public void setSignedCode(String signedCode) {
    this.signedCode = signedCode;
  }

  public String getSignedReference() {
    return signedReference;
  }
  public void setSignedReference(String signedReference) {
    this.signedReference = signedReference;
  }

  public String getTemplateType() {
    return templateType;
  }
  public void setTemplateType(String templateType) {
    this.templateType = templateType;
  }

  public List<Item> getItems() {
    return items;
  }
  public void setItems(List<Item> items) {
    this.items = items;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Document {\n");
    sb.append("  templateCode: ").append(templateCode).append("\n");
    sb.append("  templateReference: ").append(templateReference).append("\n");
    sb.append("  draftedCode: ").append(draftedCode).append("\n");
    sb.append("  draftedReference: ").append(draftedReference).append("\n");
    sb.append("  signedCode: ").append(signedCode).append("\n");
    sb.append("  signedReference: ").append(signedReference).append("\n");
    sb.append("  templateType: ").append(templateType).append("\n");
    sb.append("  items: ").append(items).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

