package br.com.thiago.teste.ciandt.controller;

import br.com.thiago.teste.ciandt.client.entity.ContractRequest;
import br.com.thiago.teste.ciandt.controller.dto.ContractDto;
import br.com.thiago.teste.ciandt.services.ContractService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/contract")
@RequiredArgsConstructor
public class ContractController {

    public static final String ID_CONTRACT = "/{idContract}";

    private final ContractService service;

    private final ModelMapper mapper;

    @PostMapping
     public ResponseEntity<ContractDto> createUserContract(@RequestBody ContractRequest user){
       ContractDto dto= service.createUserContract(user);
        return ResponseEntity.ok().body(dto);

    }

    @PutMapping(value = ID_CONTRACT)
    public ResponseEntity<ContractDto> updateUserContract(@PathVariable String idContract, @RequestBody ContractRequest user){
        return ResponseEntity.ok().body(mapper.map(service.updateUserContract(user), ContractDto.class));
    }

    @DeleteMapping(value = ID_CONTRACT)
    public ResponseEntity<ContractDto> deleteUserContract(@PathVariable String idContract) {
        service.deleteUserContract(idContract);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ContractDto>> getAllUserContract() {
        return ResponseEntity.ok()
                .body(service.getAllUserContract().stream().map(x -> mapper.map(x, ContractDto.class))
                        .collect(Collectors.toList()));
    }

    @GetMapping(value = ID_CONTRACT)
    public ResponseEntity<ContractDto> getUserContractById(@PathVariable String idContract) {
        return ResponseEntity.ok().body(mapper.map(service.getUserContractById(idContract), ContractDto.class));

    }

}
