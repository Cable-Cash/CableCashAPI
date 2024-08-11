package com.cablecash.api.model.dto._public;

import com.cablecash.api.model.entity._public.Transacao;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
public class TransacaoDTO {

    private Long id;
    private String tipoTransacao;
    private Double valor;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private Timestamp dataTransacao;
    private Long idContaOrigem;
    private Long idContaDestino;
    private Long idChavePixOrigem;
    private Long idChavePixDestino;

    public TransacaoDTO(Transacao transacao) {
        this.id = transacao.getId();
        this.tipoTransacao = transacao.getTipoTransacao();
        this.valor = transacao.getValor();
        this.dataTransacao = transacao.getDataTransacao();
        this.idContaOrigem = transacao.getContaOrigem().getId();
        this.idContaDestino = transacao.getContaDestino().getId();
        this.idChavePixOrigem = transacao.getChavePIXOrigem().getId();
        this.idChavePixDestino = transacao.getChavePIXDestino().getId();
    }
}
