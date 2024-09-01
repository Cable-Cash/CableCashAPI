package com.cablecash.api.model.dto._public;

import com.cablecash.api.config.serializer.CpfFormatterSerializer;
import com.cablecash.api.config.serializer.DataFormatterSerializer;
import com.cablecash.api.config.serializer.TelefoneFormatterSerializer;
import com.cablecash.api.model.entity._public.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Hidden
public class ClienteDTO {

    private Long id;
    private String nome;
    private String sobrenome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @JsonSerialize(using = DataFormatterSerializer.class)
    private Date dataNascimento;

    @JsonSerialize(using = CpfFormatterSerializer.class)
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
