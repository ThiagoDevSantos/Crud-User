package br.com.thiago.teste.ciandt.controller;


import br.com.thiago.teste.ciandt.domain.User;
import br.com.thiago.teste.ciandt.domain.dto.UserDTO;
import br.com.thiago.teste.ciandt.repositories.UserRepository;
import br.com.thiago.teste.ciandt.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/user")
@RequiredArgsConstructor
@Api(value = "API REST")
public class UserController {

    public static final String ID = "/{id}";
    public static final String APPLICATION_JSON = "application/json";

    private final ModelMapper mapper;

    private final UserService service;

    private final UserRepository repository;

    private final PasswordEncoder encoder;

    @GetMapping(value = ID,produces = APPLICATION_JSON)
    @ApiOperation(value = "List By Id")
    public ResponseEntity<UserDTO> findById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(mapper.map(service.findById(id),UserDTO.class));

    }

    @GetMapping(produces = APPLICATION_JSON)
    @ApiOperation(value = "List All")
    public ResponseEntity<List<UserDTO>> findAll() {
        return ResponseEntity.ok()
                .body(service.findAll().stream().map(x -> mapper.map(x, UserDTO.class))
                        .collect(Collectors.toList()));
    }

    @PostMapping(produces = APPLICATION_JSON, consumes = APPLICATION_JSON)
    @ApiOperation(value = "Save User")
    public ResponseEntity<User> create(@RequestBody UserDTO userDTO){
       userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        return ResponseEntity.ok(service.create(userDTO));
    }

    @PutMapping(value = ID, produces = APPLICATION_JSON, consumes = APPLICATION_JSON)
    @ApiOperation(value = "Update User")
    public ResponseEntity<UserDTO> update(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        userDTO.setPassword(encoder.encode(userDTO.getPassword()));
        userDTO.setId(id);
        return ResponseEntity.ok().body(mapper.map(service.update(userDTO),UserDTO.class));
    }

    @DeleteMapping(value = ID,produces = APPLICATION_JSON)
    @ApiOperation(value = "Delete User")
    public ResponseEntity<UserDTO> delete(@PathVariable Integer id){
        service.delete(id);
        return ResponseEntity.noContent().build();

    }


}
