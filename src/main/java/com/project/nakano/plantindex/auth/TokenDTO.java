package com.project.nakano.plantindex.auth;

public class TokenDTO {

  public String token;
  public String type;

  public TokenDTO() {
  }

  public TokenDTO(String token, String type) {
    this.token = token;
    this.type = type;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public void setType(String type) {
    this.type = type;
  }
}
