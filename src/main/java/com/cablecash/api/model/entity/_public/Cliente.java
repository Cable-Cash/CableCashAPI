package com.cablecash.api.model.entity._public;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.math.BigDecimal;
import java.util.Date;

public class Cliente {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "sobrenome", length = 100, nullable = false)
    private String sobrenome;

    @Column(name = "dataNascimento", nullable = false)
    private Date dataNascimento;

    @Column(name = "cpf",  length = 11, unique = true, nullable = false)
    private String cpf;

    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;

    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Column(name = "rendaMensal", length = 15, precision = 2)
    private BigDecimal rendaMensal;

}
