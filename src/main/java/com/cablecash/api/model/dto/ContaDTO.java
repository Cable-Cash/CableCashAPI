package com.cablecash.api.model.dto;

import com.cablecash.api.model.entity.Conta;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
public class ContaDTO {

    private Long id;
    private String conta;
    private String tipo;
    private BigDecimal saldo;
    private Integer agencia;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Timestamp abertura;

    private Long cliente;

    public ContaDTO(Conta conta) {
        this.id = conta.getId();
        this.conta = conta.getNumeroConta();
        this.tipo = conta.getTipoConta().toString();
        this.saldo = conta.getSaldo();
        this.agencia = conta.getAgencia();
        this.abertura = conta.getDataAbertura();
        this.cliente = conta.getCliente().getId();
    }
}
