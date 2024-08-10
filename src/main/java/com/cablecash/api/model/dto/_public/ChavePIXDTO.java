package com.cablecash.api.model.dto._public;

import com.cablecash.api.model.entity._public.ChavePIX;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChavePIXDTO {

    private Long id;
    private String tipoChave;
    private String valorChave;
    private String dataCriacao;
    private Long idCliente;
    private Long idConta;

    public ChavePIXDTO(ChavePIX pix) {
        this.id = pix.getId();
        this.tipoChave = pix.getTipoChave();
        this.valorChave = pix.getValorChave();
        this.dataCriacao = pix.getDataCriacao().toString();
        this.idCliente = pix.getIdCliente().getId();
        this.idConta = pix.getIdConta().getId();
    }
}
