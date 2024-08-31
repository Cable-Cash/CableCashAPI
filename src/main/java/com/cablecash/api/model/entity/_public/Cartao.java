//package com.cablecash.api.model.entity._public;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//import java.sql.Timestamp;
//import java.util.Date;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "cartao", schema = "public")
//public class Cartao {
//
//    @Id
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    @Column(name = "numero_cartao", length = 24, unique = true, nullable = false)
//    private String numeroCartao;
//
//    @Column(name = "validade", nullable = false)
//    private Timestamp validade;
//
//    @Column(name = "cvv", length = 3, nullable = false)
//    private String cvv;
//
//    @Column(name = "limite_credito", precision = 15, scale = 2)
//    private BigDecimal limiteCredito;
//
//    @Column(name = "saldo_atual", precision = 15, scale = 2)
//    private BigDecimal saldoAtual;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
//    private Cliente cliente;
//
//}
