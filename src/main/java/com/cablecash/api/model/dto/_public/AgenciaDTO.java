package com.cablecash.api.model.dto._public;

import com.cablecash.api.model.entity._public.Agencia;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgenciaDTO {

    private Long id;
    private String nome;
    private String endereco;
    private String telefone;

    public AgenciaDTO(Agencia agencia) {
        this.id = agencia.getId();
        this.nome = agencia.getNome();
        this.endereco = agencia.getEndereco();
        this.telefone = agencia.getTelefone();
    }
}
