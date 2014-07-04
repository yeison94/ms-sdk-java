package com.viafirma.mobile.services.sdk.java.model;

public class ErrorResponse {
  private String error = null;
  private String id = null;
  private Integer status = null;
  private String errorCode = null;
  public String getError() {
    return error;
  }
  public void setError(String error) {
    this.error = error;
  }

  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }

  public Integer getStatus() {
    return status;
  }
  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getErrorCode() {
    return errorCode;
  }
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    sb.append("  error: ").append(error).append("\n");
    sb.append("  id: ").append(id).append("\n");
    sb.append("  status: ").append(status).append("\n");
    sb.append("  errorCode: ").append(errorCode).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

