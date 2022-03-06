package com.project.nakano.plantindex.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private AuthenticationService authenticationService;
  
  // Configura a autenticação
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    //Configura qual é a classe de autenticação e qual é o password encoder utilizado nos dados que vem do DB
    auth.userDetailsService(this.authenticationService).passwordEncoder(new BCryptPasswordEncoder());
  }

  // Configura autorização
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    /** 
        Consulta pública para todos que chamarem 
        GET /topicos e /topicos/*, o restante deve
        ser autenticado
    **/
    http.authorizeRequests()
      .antMatchers(HttpMethod.POST, "/auth").permitAll()
//      .antMatchers(HttpMethod.GET, "/searchplants*").permitAll()
      .antMatchers(HttpMethod.GET, "/plant*").permitAll()
      .antMatchers(HttpMethod.GET, "/categories*").permitAll()
      .anyRequest().authenticated()
      .and().formLogin();
  }

  // Configura recursos estáticos (js, css, imgs, etc)
  @Override
  public void configure(WebSecurity web) throws Exception {
  
  }

}
