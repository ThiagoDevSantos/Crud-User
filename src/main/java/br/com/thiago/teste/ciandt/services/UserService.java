package br.com.thiago.teste.ciandt.services;

import br.com.thiago.teste.ciandt.domain.User;
import br.com.thiago.teste.ciandt.domain.dto.UserDTO;

import java.util.List;

public interface UserService {
    User findById (Integer id);
    List <User> findAll();
    User create(UserDTO obj);
    User update(UserDTO obj);
    void delete(Integer id);
    void findByEmail(UserDTO obj);

}
