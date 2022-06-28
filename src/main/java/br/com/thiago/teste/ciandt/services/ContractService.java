package br.com.thiago.teste.ciandt.services;

import br.com.thiago.teste.ciandt.client.entity.ContractRequest;
import br.com.thiago.teste.ciandt.controller.dto.ContractDto;

import java.util.List;

public interface ContractService {
    ContractDto createUserContract(ContractRequest contract);
    ContractDto updateUserContract(ContractRequest contract);
    void deleteUserContract(String idContract);
    List<ContractDto> getAllUserContract();
    ContractDto getUserContractById(String idContract);
}
