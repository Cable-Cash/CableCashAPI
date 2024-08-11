package com.cablecash.api.model.dto._public;

import com.cablecash.api.enums.EnumTipoConta;
import com.cablecash.api.model.entity._public.Conta;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class ContaDTO {

    private Long conta;
    private String numero;
    private String tipo;
    private BigDecimal saldo;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataAbertura;
    private Long cliente;

    public ContaDTO(Conta conta) {
        this.conta = conta.getId();
        this.numero = conta.getNumeroConta();
        this.tipo = conta.getTipoConta().toString();
        this.saldo = conta.getSaldo();
        this.dataAbertura = conta.getDataAbertura();
        this.cliente = conta.getIdCliente().getId();
    }
}
