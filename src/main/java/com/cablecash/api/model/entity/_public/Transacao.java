package com.cablecash.api.model.entity._public;

import com.cablecash.api.enums.EnumTipoTransacao;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "transacao", schema = "public")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "tipo_transacao", nullable = false)
    private String tipoTransacao;

    @Column(name = "valor", nullable = false)
    private Double valor;

    @Column(name = "data_transacao", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp dataTransacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conta_origem", referencedColumnName = "id", nullable = false)
    private Conta contaOrigem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_conta_destino", referencedColumnName = "id", nullable = false)
    private Conta contaDestino;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chave_pix_origem", referencedColumnName = "id", nullable = false)
    private ChavePIX chavePIXOrigem;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_chave_pix_destino", referencedColumnName = "id", nullable = false)
    private ChavePIX chavePIXDestino;

}
