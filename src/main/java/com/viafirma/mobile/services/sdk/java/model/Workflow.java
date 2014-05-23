package com.viafirma.mobile.services.sdk.java.model;

import java.util.Date;
import java.util.*;
import com.viafirma.mobile.services.sdk.java.model.EventHistory;
public class Workflow {
  private String code = null;
  private String current = null;
  private String next = null;
  private List<EventHistory> history = new ArrayList<EventHistory>();
  private Date initiate = null;
  private Date lastUpdated = null;
  private Date expires = null;
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  public String getCurrent() {
    return current;
  }
  public void setCurrent(String current) {
    this.current = current;
  }

  public String getNext() {
    return next;
  }
  public void setNext(String next) {
    this.next = next;
  }

  public List<EventHistory> getHistory() {
    return history;
  }
  public void setHistory(List<EventHistory> history) {
    this.history = history;
  }

  public Date getInitiate() {
    return initiate;
  }
  public void setInitiate(Date initiate) {
    this.initiate = initiate;
  }

  public Date getLastUpdated() {
    return lastUpdated;
  }
  public void setLastUpdated(Date lastUpdated) {
    this.lastUpdated = lastUpdated;
  }

  public Date getExpires() {
    return expires;
  }
  public void setExpires(Date expires) {
    this.expires = expires;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Workflow {\n");
    sb.append("  code: ").append(code).append("\n");
    sb.append("  current: ").append(current).append("\n");
    sb.append("  next: ").append(next).append("\n");
    sb.append("  history: ").append(history).append("\n");
    sb.append("  initiate: ").append(initiate).append("\n");
    sb.append("  lastUpdated: ").append(lastUpdated).append("\n");
    sb.append("  expires: ").append(expires).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

