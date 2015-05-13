package com.viafirma.mobile.services.sdk.java.model;


import com.wordnik.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;


@ApiModel(description = "")
public class Token  {
  
  private String oauth_token = null;
  private String oauth_token_secret = null;

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("oauth_token")
  public String getOauth_token() {
    return oauth_token;
  }
  public void setOauth_token(String oauth_token) {
    this.oauth_token = oauth_token;
  }

  
  /**
   **/
  @ApiModelProperty(required = false, value = "")
  @JsonProperty("oauth_token_secret")
  public String getOauth_token_secret() {
    return oauth_token_secret;
  }
  public void setOauth_token_secret(String oauth_token_secret) {
    this.oauth_token_secret = oauth_token_secret;
  }

  

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Token {\n");
    
    sb.append("  oauth_token: ").append(oauth_token).append("\n");
    sb.append("  oauth_token_secret: ").append(oauth_token_secret).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
