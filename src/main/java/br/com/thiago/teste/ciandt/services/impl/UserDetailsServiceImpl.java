package br.com.thiago.teste.ciandt.services.impl;

import br.com.thiago.teste.ciandt.domain.User;
import br.com.thiago.teste.ciandt.domain.UserDetailsData;
import br.com.thiago.teste.ciandt.repositories.UserRepository;
import br.com.thiago.teste.ciandt.services.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

   private final UserRepository repository;

    public UserDetailsServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = repository.findByName(username);
         if(user.isEmpty()){
             throw new UsernameNotFoundException("user [ " + username + " ] not found ");
         }
         return new UserDetailsData(user);
    }
}
