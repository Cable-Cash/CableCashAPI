package com.cablecash.api.model.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;

@Getter
@Setter
@Entity
@Table(name = "cartao", schema = "public")
public class Cartao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_cartao", length = 19, unique = true, nullable = false)
    private String numeroCartao;

    @Column(name = "validade", nullable = false)
    private Timestamp validade;

    @Column(name = "cvv", length = 3, nullable = false)
    private String cvv;

    @Column(name = "limite_credito", precision = 15, scale = 2)
    private BigDecimal limiteCredito;

    @Column(name = "saldo_atual", precision = 15, scale = 2)
    private BigDecimal saldoAtual;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    @PrePersist
    public void prePersist() {
        if (this.limiteCredito == null) {
            this.limiteCredito = BigDecimal.valueOf(200.00);
        }
        if (this.validade == null) {
            LocalDate now = LocalDate.now();
            LocalDate validadeDate = now.plus(Period.ofYears(8));
            this.validade = Timestamp.valueOf(validadeDate.atStartOfDay());
        }
        if (this.numeroCartao == null) {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                if (i > 0) {
                    sb.append("-");
                }
                for (int j = 0; j < 4; j++) {
                    sb.append(random.nextInt(10));
                }
            }
            this.numeroCartao = sb.toString();
        }
        if (this.cvv == null) {
            Random random = new Random();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++) {
                sb.append(random.nextInt(10));
            }
            this.cvv = sb.toString();
        }
        if (this.saldoAtual == null) {
            this.saldoAtual = BigDecimal.ZERO;
        }
    }
}
