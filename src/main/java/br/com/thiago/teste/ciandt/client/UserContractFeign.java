package br.com.thiago.teste.ciandt.client;

import br.com.thiago.teste.ciandt.client.entity.ContractRequest;
import br.com.thiago.teste.ciandt.client.entity.ContractResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "${client.user.contract.name}" , url = "${client.user.contract.url}")
public interface UserContractFeign {

    @PostMapping(value = "/contract", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ContractResponse saveUserContract(@RequestBody ContractRequest user);

    @PutMapping(value = "/contract",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ContractResponse updateUserContract(@RequestBody ContractRequest user);

    @DeleteMapping(value = "/contract/{idContract}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ContractResponse deleteUserContract(@PathVariable String idContract);

    @GetMapping(value = "/contract",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    List<ContractResponse> getAllUserContract();

    @GetMapping(value = "/contract/{idContract}",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ContractResponse getUserContractById(@PathVariable String idContract);

}
