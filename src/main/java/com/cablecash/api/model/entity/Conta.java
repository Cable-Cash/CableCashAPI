package com.cablecash.api.model.entity;

import com.cablecash.api.enums.EnumTipoConta;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Random;

@Getter
@Setter
@Entity
@Table(name = "conta", schema = "public")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_conta", unique = true, length = 11)
    private String numeroConta;

    @Column(name = "tipo_conta", nullable = false, length = 20)
    private EnumTipoConta tipoConta;

    @Column(name = "saldo", nullable = false, precision = 15, scale = 2)
    private BigDecimal saldo;

    @Column(name = "agencia", nullable = false)
    private Integer agencia;

    @Column(name = "data_abertura", nullable = false)
    private Timestamp dataAbertura;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @PrePersist
    private void prePersist() {
        if (this.numeroConta == null) {
            Random random = new Random();
            int numero = random.nextInt(900000000) + 100000000;
            int digito = random.nextInt(10);
            this.numeroConta = String.format("%09d-%d", numero, digito);
        }
        if (this.dataAbertura == null) {
            this.dataAbertura = Timestamp.from(Instant.now());
        }
        if (this.saldo == null) {
            this.saldo = BigDecimal.ZERO;
        }
        if (this.agencia == null) {
            this.agencia = 1;
        }
    }
}
