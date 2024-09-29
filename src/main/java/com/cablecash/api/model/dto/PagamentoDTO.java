package com.cablecash.api.model.dto;

import com.cablecash.api.model.entity.Pagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PagamentoDTO {

    private Long id;
    private String valor;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date data;
    private String descricao;
    private Long conta;

    private Long cartao;

    public PagamentoDTO(Pagamento entity) {
        this.id = entity.getId();
        this.valor = entity.getValor().toString();
        this.data = entity.getData();
        this.descricao = entity.getDescricao();
        this.conta = entity.getConta().getId();
        this.cartao = entity.getCartao().getId();
    }
}
