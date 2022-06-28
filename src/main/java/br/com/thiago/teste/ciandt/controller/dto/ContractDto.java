package br.com.thiago.teste.ciandt.controller.dto;


import br.com.thiago.teste.ciandt.utils.Cpf;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class ContractDto {

    String idContract;
    String cpf;
    String product;
}
