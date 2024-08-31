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
//@Table(name = "pagamento", schema = "public")
//public class Pagamento {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(name = "valor", nullable = false, precision = 15, scale = 2)
//    private BigDecimal valor;
//
//    @Column(name = "data", nullable = false)
//    private Date data;
//
//    @Column(name = "descricao", nullable = false, length = 100)
//    private String descricao;
//
//    @ManyToOne(fetch = FetchType.LAZY, optional = false)
//    @JoinColumn(name = "id_conta", nullable = false)
//    private Conta idConta;
//
////    @ManyToOne(fetch = FetchType.LAZY, optional = false)
////    @JoinColumn(name = "id_cartao", nullable = false)
////    private Cartao idCartao;
//
//}
