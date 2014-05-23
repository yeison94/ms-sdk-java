package com.viafirma.mobile.services.sdk.java.model;

public class Rectangle {
  private Integer x = null;
  private Integer y = null;
  private Integer width = null;
  private Integer height = null;
  public Integer getX() {
    return x;
  }
  public void setX(Integer x) {
    this.x = x;
  }

  public Integer getY() {
    return y;
  }
  public void setY(Integer y) {
    this.y = y;
  }

  public Integer getWidth() {
    return width;
  }
  public void setWidth(Integer width) {
    this.width = width;
  }

  public Integer getHeight() {
    return height;
  }
  public void setHeight(Integer height) {
    this.height = height;
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Rectangle {\n");
    sb.append("  x: ").append(x).append("\n");
    sb.append("  y: ").append(y).append("\n");
    sb.append("  width: ").append(width).append("\n");
    sb.append("  height: ").append(height).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}

