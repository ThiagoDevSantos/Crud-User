package br.com.thiago.teste.ciandt.services.impl;

import br.com.thiago.teste.ciandt.client.UserContractFeign;
import br.com.thiago.teste.ciandt.client.entity.ContractRequest;
import br.com.thiago.teste.ciandt.controller.dto.ContractDto;
import br.com.thiago.teste.ciandt.services.ContractService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ContractServiceImpl implements ContractService {

    @Autowired
    private final UserContractFeign feign;

    @Autowired
    private ModelMapper mapper;

    @Override
    public ContractDto createUserContract(ContractRequest user) {
        var contractResponse = feign.saveUserContract(user) ;
        var contractDto = mapper.map(contractResponse, ContractDto.class);
        return contractDto;
    }

    @Override
    public ContractDto updateUserContract(ContractRequest user) {
        var contractResponse = feign.updateUserContract(user) ;
        var contractDto = mapper.map(contractResponse, ContractDto.class);
        return contractDto;
    }

    @Override
    public void deleteUserContract(String idContract) {
        feign.deleteUserContract(idContract);
    }

    @Override
    public List<ContractDto> getAllUserContract() {
        return feign.getAllUserContract().stream().map(contractRequest -> mapper.map(contractRequest, ContractDto.class))
                .collect(Collectors.toList());

    }

    @Override
    public ContractDto getUserContractById(String idContract) {

        var contractResponse= feign.getUserContractById(idContract);
        var dto = mapper.map(contractResponse, ContractDto.class);
        return dto;
    }

}


