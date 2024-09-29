package com.cablecash.api.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "chavepix", schema = "public")
public class ChavePIX {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_chave", length = 20, nullable = false)
    private String tipoChave;

    @Column(name = "valor_chave", unique = true, nullable = false)
    private String valorChave;

    @Column(name = "data_criacao", nullable = false)
    private Timestamp dataCriacao;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_conta", nullable = false)
    private Conta conta;

    @PrePersist
    private void prePersist() {
        if (this.dataCriacao == null) {
            this.dataCriacao = Timestamp.from(Instant.now());
        }
        if (this.valorChave == null) {
            this.valorChave = UUID.randomUUID().toString();
        }
    }
}
