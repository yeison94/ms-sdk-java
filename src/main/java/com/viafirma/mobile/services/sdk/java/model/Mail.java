package com.viafirma.mobile.services.sdk.java.model;

import com.viafirma.mobile.services.sdk.java.model.MailConfig;

import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Mail  {
  
  private MailConfig from = null;
  private MailConfig fromName = null;
  private MailConfig to = null;
  private MailConfig subject = null;
  private MailConfig replyTo = null;
  private MailConfig cc = null;
  private MailConfig bcc = null;
  private MailConfig text = null;

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("from")
  public MailConfig getFrom() {
    return from;
  }
  public void setFrom(MailConfig from) {
    this.from = from;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("fromName")
  public MailConfig getFromName() {
    return fromName;
  }
  public void setFromName(MailConfig fromName) {
    this.fromName = fromName;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("to")
  public MailConfig getTo() {
    return to;
  }
  public void setTo(MailConfig to) {
    this.to = to;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("subject")
  public MailConfig getSubject() {
    return subject;
  }
  public void setSubject(MailConfig subject) {
    this.subject = subject;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("replyTo")
  public MailConfig getReplyTo() {
    return replyTo;
  }
  public void setReplyTo(MailConfig replyTo) {
    this.replyTo = replyTo;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("cc")
  public MailConfig getCc() {
    return cc;
  }
  public void setCc(MailConfig cc) {
    this.cc = cc;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("bcc")
  public MailConfig getBcc() {
    return bcc;
  }
  public void setBcc(MailConfig bcc) {
    this.bcc = bcc;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("text")
  public MailConfig getText() {
    return text;
  }
  public void setText(MailConfig text) {
    this.text = text;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Mail {\n");
    
    sb.append("  from: ").append(from).append("\n");
    sb.append("  fromName: ").append(fromName).append("\n");
    sb.append("  to: ").append(to).append("\n");
    sb.append("  subject: ").append(subject).append("\n");
    sb.append("  replyTo: ").append(replyTo).append("\n");
    sb.append("  cc: ").append(cc).append("\n");
    sb.append("  bcc: ").append(bcc).append("\n");
    sb.append("  text: ").append(text).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
