package br.com.thiago.teste.services.impl;

import br.com.thiago.teste.domain.User;
import br.com.thiago.teste.domain.dto.UserDTO;
import br.com.thiago.teste.repositories.UserRepository;

import br.com.thiago.teste.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {
    public static final Integer ID = 1;
    public static final String NAME = "Thiago";
    public static final String EMAIL = "thi@gmail.com";
    public static final String PASSWORD = "123";
    public static final String NAO_ENCONTRADO = "Objeto não encontrado";

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;

    @Mock
    private ModelMapper mapper;

    private User user;

    private UserDTO userDTO;

    private Optional<User> optionalUser;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenFindByIdThenReturnUserInstance() {
        when(repository.findById(anyInt())).thenReturn(optionalUser);
        User response = service.findById(ID);

        assertNotNull(response);

        assertEquals(User.class,response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(EMAIL,response.getEmail());
    }

    @Test
    void  whenFindByIdThenReturnAnObjectNotFound(){
        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException(NAO_ENCONTRADO));

        try {
            service.findById(ID);
        }catch (Exception ex){
            assertEquals(ObjectNotFoundException.class,ex.getClass());
            assertEquals(NAO_ENCONTRADO,ex.getMessage());
        }
    }


    @Test
    void listOfUSers() {
        when(repository.findAll()).thenReturn(List.of(user));

        List<User> response = service.findAll();

        assertNotNull(response);
        assertEquals(User.class, response.get(0).getClass());
        assertEquals(ID, response.get(0).getId());
        assertEquals(EMAIL,response.get(0).getEmail());
    }

    @Test
    void createUsers_Success() {
        when(repository.save(any())).thenReturn(user);

        User response = service.create(userDTO);

        assertNotNull(user);
        assertEquals(User.class,response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(EMAIL, response.getEmail());

    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser(){
        user = new User(ID, NAME, EMAIL, PASSWORD);
        userDTO = new UserDTO(ID, NAME, EMAIL, PASSWORD);
        optionalUser = Optional.of(new User(ID, NAME, EMAIL, PASSWORD));
    }
}