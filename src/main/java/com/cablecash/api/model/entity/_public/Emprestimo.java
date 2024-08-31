//package com.cablecash.api.model.entity._public;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//import java.util.Date;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "emprestimo", schema = "public")
//public class Emprestimo {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "valor_emprestimo", precision = 15, scale = 2, nullable = false)
//    private BigDecimal valorEmprestimo;
//
//    @Column(name = "taxa_juros", precision = 5, scale = 2, nullable = false)
//    private BigDecimal taxaJuros;
//
//    @Column(name = "data_inicio", nullable = false)
//    private Date dataInicio;
//
//    @Column(name = "data_fim", nullable = false)
//    private Date dataFim;
//
//    @Column(name = "saldo_devido", precision = 15, scale = 2, nullable = false)
//    private BigDecimal saldoDevido;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "id_cliente", referencedColumnName = "id", nullable = false)
//    private Cliente idCliente;
//
//}
