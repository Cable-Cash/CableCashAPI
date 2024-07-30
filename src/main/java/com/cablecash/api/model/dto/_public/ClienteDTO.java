package com.cablecash.api.model.dto._public;

import com.cablecash.api.config.serializer.DataFormatterSerializer;
import com.cablecash.api.config.serializer.TelefoneFormatterSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
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

}
