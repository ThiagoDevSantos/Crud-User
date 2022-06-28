package br.com.thiago.teste.ciandt.client.entity;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class ContractRequest {
    String idContract;
    String cpf;
    String product;
}
