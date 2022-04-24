package br.com.thiago.teste.services.impl;

import br.com.thiago.teste.domain.User;
import br.com.thiago.teste.domain.dto.UserDTO;
import br.com.thiago.teste.repositories.UserRepository;
import br.com.thiago.teste.services.UserService;
import br.com.thiago.teste.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private ModelMapper mapper;

    public User findById(Integer id) {
        Optional<User> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }

    public List<User> findAll(){
        return repository.findAll();
    }

    @Override
    public User create(UserDTO obj) {
        return repository.save(mapper.map(obj,User.class));
    }
}
