package com.cablecash.api.model.dto._public;

import com.cablecash.api.model.entity._public.Conta;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Getter
@Setter
public class ContaDTO {

    private Long id;
    private String conta;
    private String tipo;
    private BigDecimal saldo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Timestamp abertura;

    private Long cliente;

    public ContaDTO(Conta conta) {
        this.id = conta.getId();
        this.conta = conta.getNumeroConta();
        this.tipo = conta.getTipoConta().toString();
        this.saldo = conta.getSaldo();
        this.abertura = conta.getDataAbertura();
        this.cliente = conta.getCliente().getId();
    }
}
