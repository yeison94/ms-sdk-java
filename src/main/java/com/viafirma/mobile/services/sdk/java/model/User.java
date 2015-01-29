package com.viafirma.mobile.services.sdk.java.model;

public class User {
  private String code = null;
  private String nationalId = null;
  private String email = null;
  private String password = null;
  private String name = null;
  private String surname = null;
  private String rol = null;
  private String description = null;
  private String viafirmaKey = null;
  private String viafirmaPassword = null;
  private String viafirmaCertificate = null;
  private String region = null;
  private String pos = null;
  private String mobile = null;
  private String channel = null;
  public String getCode() {
    return code;
  }
  public void setCode(String code) {
    this.code = code;
  }

  public String getNationalId() {
    return nationalId;
  }
  public void setNationalId(String nationalId) {
    this.nationalId = nationalId;
  }

  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }
  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getRol() {
    return rol;
  }
  public void setRol(String rol) {
    this.rol = rol;
  }

  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }

  public String getViafirmaKey() {
    return viafirmaKey;
  }
  public void setViafirmaKey(String viafirmaKey) {
    this.viafirmaKey = viafirmaKey;
  }

  public String getViafirmaPassword() {
    return viafirmaPassword;
  }
  public void setViafirmaPassword(String viafirmaPassword) {
    this.viafirmaPassword = viafirmaPassword;
  }

  public String getViafirmaCertificate() {
    return viafirmaCertificate;
  }
  public void setViafirmaCertificate(String viafirmaCertificate) {
    this.viafirmaCertificate = viafirmaCertificate;
  }

  public String getRegion() {
    return region;
  }
  public void setRegion(String region) {
    this.region = region;
  }

  public String getPos() {
    return pos;
  }
  public void setPos(String pos) {
    this.pos = pos;
  }

  public String getMobile() {
    return mobile;
  }
  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public String getChannel() {
    return channel;
  }
  public void setChannel(String channel) {
    this.channel = channel;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    sb.append("  code: ").append(code).append("\n");
    sb.append("  nationalId: ").append(nationalId).append("\n");
    sb.append("  email: ").append(email).append("\n");
    sb.append("  password: ").append(password).append("\n");
    sb.append("  name: ").append(name).append("\n");
    sb.append("  surname: ").append(surname).append("\n");
    sb.append("  rol: ").append(rol).append("\n");
    sb.append("  description: ").append(description).append("\n");
    sb.append("  viafirmaKey: ").append(viafirmaKey).append("\n");
    sb.append("  viafirmaPassword: ").append(viafirmaPassword).append("\n");
    sb.append("  viafirmaCertificate: ").append(viafirmaCertificate).append("\n");
    sb.append("  region: ").append(region).append("\n");
    sb.append("  pos: ").append(pos).append("\n");
    sb.append("  mobile: ").append(mobile).append("\n");
    sb.append("  channel: ").append(channel).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

