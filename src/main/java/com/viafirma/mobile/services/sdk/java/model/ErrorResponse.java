package com.viafirma.mobile.services.sdk.java.model;

public class ErrorResponse {
  private String type = null;
  private String message = null;
  private String trace = null;
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }

  public String getMessage() {
    return message;
  }
  public void setMessage(String message) {
    this.message = message;
  }

  public String getTrace() {
    return trace;
  }
  public void setTrace(String trace) {
    this.trace = trace;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponse {\n");
    sb.append("  type: ").append(type).append("\n");
    sb.append("  message: ").append(message).append("\n");
    sb.append("  trace: ").append(trace).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

