package br.com.thiago.teste.services.impl;

import br.com.thiago.teste.domain.User;
import br.com.thiago.teste.repositories.UserRepository;
import br.com.thiago.teste.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElse(null);
    }
}
