package com.cablecash.api.model.dto._public;

import com.cablecash.api.enums.EnumTipoConta;
import com.cablecash.api.model.entity._public.Conta;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class ContaDTO {

    private Long id;
    private String numeroConta;
    private String tipoConta;
    private BigDecimal saldo;
    private Date dataAbertura;
    private Long idCliente;

    public ContaDTO(Conta conta) {
        this.id = conta.getId();
        this.numeroConta = conta.getNumeroConta();
        this.tipoConta = conta.getTipoConta().toString();
        this.saldo = conta.getSaldo();
        this.dataAbertura = conta.getDataAbertura();
        this.idCliente = conta.getIdCliente().getId();
    }
}
