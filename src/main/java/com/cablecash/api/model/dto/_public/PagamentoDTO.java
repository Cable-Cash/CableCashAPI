package com.cablecash.api.model.dto._public;

import com.cablecash.api.model.entity._public.Pagamento;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PagamentoDTO {

    private Long id;
    private String valor;
    private String data;
    private String descricao;
    private Long idConta;
//    private Long idCartao;

    public PagamentoDTO(Pagamento pagamento) {
        this.id = pagamento.getId();
        this.valor = pagamento.getValor().toString();
        this.data = pagamento.getData().toString();
        this.descricao = pagamento.getDescricao();
        this.idConta = pagamento.getIdConta().getId();
    }
}
