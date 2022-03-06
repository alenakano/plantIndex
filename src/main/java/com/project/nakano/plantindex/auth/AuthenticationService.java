package com.project.nakano.plantindex.auth;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("authenticationService")
public class AuthenticationService implements UserDetailsService {
  
  @Autowired
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {    
    Optional<User> usuario = this.userRepository.findByEmail(username);
    if (usuario.isPresent()) {
      return usuario.get();
    }
    throw new UsernameNotFoundException("Dados inválidos!");
  }
}
