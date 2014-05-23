package com.viafirma.mobile.services.sdk.java.model;

import java.util.Date;
import com.viafirma.mobile.services.sdk.java.model.ErrorResponse;
public class EventHistory {
  private Date start = null;
  private Date ends = null;
  private String taskName = null;
  private Integer order = null;
  private ErrorResponse error = null;
  public Date getStart() {
    return start;
  }
  public void setStart(Date start) {
    this.start = start;
  }

  public Date getEnds() {
    return ends;
  }
  public void setEnds(Date ends) {
    this.ends = ends;
  }

  public String getTaskName() {
    return taskName;
  }
  public void setTaskName(String taskName) {
    this.taskName = taskName;
  }

  public Integer getOrder() {
    return order;
  }
  public void setOrder(Integer order) {
    this.order = order;
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
    sb.append("class EventHistory {\n");
    sb.append("  start: ").append(start).append("\n");
    sb.append("  ends: ").append(ends).append("\n");
    sb.append("  taskName: ").append(taskName).append("\n");
    sb.append("  order: ").append(order).append("\n");
    sb.append("  error: ").append(error).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

