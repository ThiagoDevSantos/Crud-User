package br.com.thiago.teste.services;

import br.com.thiago.teste.domain.User;

import java.util.List;

public interface UserService {
    User findById (Integer id);
    List <User> findAll();
}
