package com.cablecash.api.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "emprestimo", schema = "public")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_emprestimo", precision = 15, scale = 2, nullable = false)
    private BigDecimal valorEmprestimo;

    @Column(name = "taxa_juros", precision = 5, scale = 2, nullable = false)
    private BigDecimal taxaJuros;

    @Column(name = "data_inicio", nullable = false)
    private Date dataInicio;

    @Column(name = "data_fim", nullable = false)
    private Date dataFim;

    @Column(name = "saldo_devido", precision = 15, scale = 2, nullable = false)
    private BigDecimal saldoDevido;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @PrePersist
    public void prePersist() {
        if (this.valorEmprestimo == null) {
            this.valorEmprestimo = BigDecimal.ZERO;
        }
        if (this.dataInicio == null) {
            this.dataInicio = Timestamp.from(Instant.now());
        }
        if (this.dataFim == null) {
            LocalDate now = LocalDate.now();
            LocalDate validadeDate = now.plus(Period.ofYears(8));
            this.dataFim = Timestamp.valueOf(validadeDate.atStartOfDay());
        }
        if (this.taxaJuros == null) {
            this.taxaJuros = BigDecimal.ZERO;
        }
        if (this.saldoDevido == null) {
            this.saldoDevido = BigDecimal.ZERO;
        }
    }
}
