package com.viafirma.mobile.services.sdk.java.model;

public class ErrorResponse {
  private String errorCode = null;
  private String id = null;
  private String error = null;
  private Integer status = null;
  public String getErrorCode() {
    return errorCode;
  }
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public String getError() {
    return error;
  }
  public void setError(String error) {
    this.error = error;
  }

  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    sb.append("  errorCode: ").append(errorCode).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  error: ").append(error).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

