package com.cablecash.api.model.entity._public;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "agencia", schema = "public")
public class Agencia {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "endereco", length = 100, nullable = false)
    private String endereco;

    @Column(name = "telefone", length = 15)
    private String telefone;

}
