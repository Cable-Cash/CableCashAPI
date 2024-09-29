package com.cablecash.api.model.dto;

import com.cablecash.api.model.entity.Cartao;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Getter
@Setter
public class CartaoDTO {

    private Long id;
    private String numeroCartao;

    @JsonFormat(pattern = "MM/yy")
    private Timestamp validade;
    private String cvv;
    private BigDecimal limiteCredito;
    private BigDecimal saldoAtual;
    private Long cliente;

    public CartaoDTO(Cartao cartao) {
        this.id = cartao.getId();
        this.numeroCartao = cartao.getNumeroCartao();
        this.validade = cartao.getValidade();
        this.cvv = cartao.getCvv();
        this.limiteCredito = cartao.getLimiteCredito();
        this.saldoAtual = cartao.getSaldoAtual();
        this.cliente = cartao.getCliente().getId();
    }
}
