package com.viafirma.mobile.services.sdk.java.model;

import com.viafirma.mobile.services.sdk.java.model.MenuOption;
import java.util.*;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Configuration  {
  
  private String viafirmaURL = null;
  private Boolean editableURL = null;
  private Boolean frontCamera = null;
  private Boolean autoLogout = null;
  private Boolean showCSV = null;
  private Boolean personMask = null;
  private Boolean registerHide = null;
  private Boolean allowsInvalidSSLCertificate = null;
  private Boolean evidenceBase64 = null;
  private List<MenuOption> finalize_menu_options = new ArrayList<MenuOption>() ;
  private Boolean sSLPinningEnabled = null;

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("viafirmaURL")
  public String getViafirmaURL() {
    return viafirmaURL;
  }
  public void setViafirmaURL(String viafirmaURL) {
    this.viafirmaURL = viafirmaURL;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("editableURL")
  public Boolean getEditableURL() {
    return editableURL;
  }
  public void setEditableURL(Boolean editableURL) {
    this.editableURL = editableURL;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("frontCamera")
  public Boolean getFrontCamera() {
    return frontCamera;
  }
  public void setFrontCamera(Boolean frontCamera) {
    this.frontCamera = frontCamera;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("autoLogout")
  public Boolean getAutoLogout() {
    return autoLogout;
  }
  public void setAutoLogout(Boolean autoLogout) {
    this.autoLogout = autoLogout;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("showCSV")
  public Boolean getShowCSV() {
    return showCSV;
  }
  public void setShowCSV(Boolean showCSV) {
    this.showCSV = showCSV;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("personMask")
  public Boolean getPersonMask() {
    return personMask;
  }
  public void setPersonMask(Boolean personMask) {
    this.personMask = personMask;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("registerHide")
  public Boolean getRegisterHide() {
    return registerHide;
  }
  public void setRegisterHide(Boolean registerHide) {
    this.registerHide = registerHide;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("allowsInvalidSSLCertificate")
  public Boolean getAllowsInvalidSSLCertificate() {
    return allowsInvalidSSLCertificate;
  }
  public void setAllowsInvalidSSLCertificate(Boolean allowsInvalidSSLCertificate) {
    this.allowsInvalidSSLCertificate = allowsInvalidSSLCertificate;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("evidenceBase64")
  public Boolean getEvidenceBase64() {
    return evidenceBase64;
  }
  public void setEvidenceBase64(Boolean evidenceBase64) {
    this.evidenceBase64 = evidenceBase64;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("finalize_menu_options")
  public List<MenuOption> getFinalize_menu_options() {
    return finalize_menu_options;
  }
  public void setFinalize_menu_options(List<MenuOption> finalize_menu_options) {
    this.finalize_menu_options = finalize_menu_options;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("sSLPinningEnabled")
  public Boolean getSSLPinningEnabled() {
    return sSLPinningEnabled;
  }
  public void setSSLPinningEnabled(Boolean sSLPinningEnabled) {
    this.sSLPinningEnabled = sSLPinningEnabled;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Configuration {\n");
    
    sb.append("  viafirmaURL: ").append(viafirmaURL).append("\n");
    sb.append("  editableURL: ").append(editableURL).append("\n");
    sb.append("  frontCamera: ").append(frontCamera).append("\n");
    sb.append("  autoLogout: ").append(autoLogout).append("\n");
    sb.append("  showCSV: ").append(showCSV).append("\n");
    sb.append("  personMask: ").append(personMask).append("\n");
    sb.append("  registerHide: ").append(registerHide).append("\n");
    sb.append("  allowsInvalidSSLCertificate: ").append(allowsInvalidSSLCertificate).append("\n");
    sb.append("  evidenceBase64: ").append(evidenceBase64).append("\n");
    sb.append("  finalize_menu_options: ").append(finalize_menu_options).append("\n");
    sb.append("  sSLPinningEnabled: ").append(sSLPinningEnabled).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
