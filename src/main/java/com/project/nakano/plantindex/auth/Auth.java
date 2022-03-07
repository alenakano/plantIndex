package com.project.nakano.plantindex.auth;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class Auth {
  private String email;
  private String password;

  public String getEmail() {
    return email;
  }

  public void setEmail(String user) {
    this.email = user;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UsernamePasswordAuthenticationToken convertToAuthenticationToken() {
    return new UsernamePasswordAuthenticationToken(getEmail(), getPassword());
  }

}
