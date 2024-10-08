package com.cablecash.api.model.dto;

import com.cablecash.api.config.serializer.CpfFormatterSerializer;
import com.cablecash.api.config.serializer.TelefoneFormatterSerializer;
import com.cablecash.api.model.entity.Cliente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Hidden
@NoArgsConstructor
public class ClienteDTO {

    private Long id;
    private String nome;
    private String sobrenome;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
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
