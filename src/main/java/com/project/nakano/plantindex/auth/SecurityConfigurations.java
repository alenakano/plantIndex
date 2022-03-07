package com.project.nakano.plantindex.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private AuthenticationService authenticationService;
  
  /* 
   * Configura a autenticação, mostrando service que faz autenticação e 
   * qual o encoder que é utilizado para salvar o password
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    /* 
     * Configura qual é a classe de autenticação e qual é o password encoder
     * utilizado nos dados que vem do DB
     */
    auth.userDetailsService(this.authenticationService).passwordEncoder(new BCryptPasswordEncoder());
  }

  /*
   * Precisamos transformar o AuthenticationManager em Bean para poder injetá-lo
   * na AutenticacaoController (por alguma razão, o Spring não o injeta
   * automaticamente nesse caso
   */
  @Override
  @Bean
  protected AuthenticationManager authenticationManager() throws Exception {
    return super.authenticationManager();
  }

  // Configura autorização
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    /*
     * Consulta pública para todos que chamarem GET /topicos e /topicos/*, o
     * restante deve ser autenticado
     */
    http.authorizeRequests().antMatchers(HttpMethod.POST, "/auth").permitAll()
        .antMatchers(HttpMethod.GET, "/searchplants*").permitAll().antMatchers(HttpMethod.GET, "/plant*").permitAll()
        .antMatchers(HttpMethod.GET, "/categories*").permitAll().anyRequest().authenticated().and().csrf().disable()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
  }

  // Configura recursos estáticos (js, css, imgs, etc)
  @Override
  public void configure(WebSecurity web) throws Exception {

  }

}
