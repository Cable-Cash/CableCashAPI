package com.cablecash.api.model.entity._public;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "conta", schema = "public")
public class Conta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numero_conta", unique = true, nullable = false, length = 20)
    private String numeroConta;

    @Column(name = "tipo_conta", nullable = false, length = 20)
    private String tipoConta;

    @Column(name = "saldo", nullable = false, precision = 15, scale = 2, columnDefinition = "numeric default 0")
    private BigDecimal saldo;

    @Column(name = "data_abertura", nullable = false)
    private Date dataAbertura;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente idCliente;

}
