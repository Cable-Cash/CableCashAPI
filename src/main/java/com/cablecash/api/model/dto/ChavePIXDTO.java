package com.cablecash.api.model.dto;

import com.cablecash.api.config.serializer.PIXFormatterSerializer;
import com.cablecash.api.model.entity.ChavePIX;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@JsonSerialize(using = PIXFormatterSerializer.class)
public class ChavePIXDTO {

    private Long id;
    private String tipoChave;
    private String valorChave;
    private Timestamp dataCriacao;
    private Long cliente;
    private Long conta;

    public ChavePIXDTO(ChavePIX pix) {
        this.id = pix.getId();
        this.tipoChave = pix.getTipoChave();
        this.valorChave = pix.getValorChave();
        this.dataCriacao = pix.getDataCriacao();
        this.cliente = pix.getCliente().getId();
        this.conta = pix.getConta().getId();
    }
}
