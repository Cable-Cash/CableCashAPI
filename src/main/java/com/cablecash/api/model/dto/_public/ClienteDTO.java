package com.cablecash.api.model.dto._public;

import com.cablecash.api.config.serializer.DataFormatterSerializer;
import com.cablecash.api.config.serializer.TelefoneFormatterSerializer;
import com.cablecash.api.model.entity._public.Cliente;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ClienteDTO {

    private Long id;

    private String nome;

    private String sobrenome;

    @JsonSerialize(using = DataFormatterSerializer.class)
    private Date dataNascimento;

    private String cpf;

    private String email;

    @JsonSerialize(using = TelefoneFormatterSerializer.class)
    private String telefone;

    private String endereco;

    private BigDecimal rendaMensal;

    public ClienteDTO(Cliente cliente) {
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.dataNascimento = cliente.getDataNascimento();
        this.cpf = cliente.getCpf();
        this.email = cliente.getEmail();
        this.telefone = cliente.getTelefone();
        this.endereco = cliente.getEndereco();
        this.rendaMensal = cliente.getRendaMensal();
    }
}
