package com.viafirma.mobile.services.sdk.java.model;

import java.util.*;
import com.viafirma.mobile.services.sdk.java.model.Evidence;
import com.viafirma.mobile.services.sdk.java.model.ErrorResponse;
import com.viafirma.mobile.services.sdk.java.model.Param;
public class Policy {
  private String code = null;
  private String userCode = null;
  private String typeFormatSign = null;
  //public enum typeFormatSignEnum { DIGITALIZED_SIGN, PAdES_BASIC, PAdES_BES, PAdES_EPES, PAdES_LTV, PDF_PKCS7, }; 
  private String typeSign = null;
  //public enum typeSignEnum { ATTACHED, DETACHED, ENVELOPED, ENVELOPING, }; 
  private Boolean signByServer = null;
  private String certificateAlias = null;
  private String certificatePassword = null;
  private String idTemporal = null;
  private String idSign = null;
  private List<Param> paramList = new ArrayList<Param>();
  private List<Evidence> evidences = new ArrayList<Evidence>();
  private ErrorResponse error = null;
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  public String getUserCode() {
    return userCode;
  }
  public void setUserCode(String userCode) {
    this.userCode = userCode;
  }

  public String getTypeFormatSign() {
    return typeFormatSign;
  }
  public void setTypeFormatSign(String typeFormatSign) {
    this.typeFormatSign = typeFormatSign;
  }

  public String getTypeSign() {
    return typeSign;
  }
  public void setTypeSign(String typeSign) {
    this.typeSign = typeSign;
  }

  public Boolean getSignByServer() {
    return signByServer;
  }
  public void setSignByServer(Boolean signByServer) {
    this.signByServer = signByServer;
  }

  public String getCertificateAlias() {
    return certificateAlias;
  }
  public void setCertificateAlias(String certificateAlias) {
    this.certificateAlias = certificateAlias;
  }

  public String getCertificatePassword() {
    return certificatePassword;
  }
  public void setCertificatePassword(String certificatePassword) {
    this.certificatePassword = certificatePassword;
  }

  public String getIdTemporal() {
    return idTemporal;
  }
  public void setIdTemporal(String idTemporal) {
    this.idTemporal = idTemporal;
  }

  public String getIdSign() {
    return idSign;
  }
  public void setIdSign(String idSign) {
    this.idSign = idSign;
  }

  public List<Param> getParamList() {
    return paramList;
  }
  public void setParamList(List<Param> paramList) {
    this.paramList = paramList;
  }

  public List<Evidence> getEvidences() {
    return evidences;
  }
  public void setEvidences(List<Evidence> evidences) {
    this.evidences = evidences;
  }

  public ErrorResponse getError() {
    return error;
  }
  public void setError(ErrorResponse error) {
    this.error = error;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Policy {\n");
    sb.append("  code: ").append(code).append("\n");
    sb.append("  userCode: ").append(userCode).append("\n");
    sb.append("  typeFormatSign: ").append(typeFormatSign).append("\n");
    sb.append("  typeSign: ").append(typeSign).append("\n");
    sb.append("  signByServer: ").append(signByServer).append("\n");
    sb.append("  certificateAlias: ").append(certificateAlias).append("\n");
    sb.append("  certificatePassword: ").append(certificatePassword).append("\n");
    sb.append("  idTemporal: ").append(idTemporal).append("\n");
    sb.append("  idSign: ").append(idSign).append("\n");
    sb.append("  paramList: ").append(paramList).append("\n");
    sb.append("  evidences: ").append(evidences).append("\n");
    sb.append("  error: ").append(error).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

