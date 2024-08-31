//package com.cablecash.api.model.dto._public;
//
//import com.cablecash.api.model.entity._public.Emprestimo;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.math.BigDecimal;
//import java.util.Date;
//
//@Getter
//@Setter
//public class EmprestimoDTO {
//
//    private Long id;
//    private BigDecimal valorEmprestimo;
//    private BigDecimal taxaJuros;
//    private Date dataInicio;
//    private Date dataFim;
//    private BigDecimal saldoDevido;
//    private Long idCliente;
//
//    public EmprestimoDTO(Emprestimo entity) {
//        this.id = entity.getId();
//        this.valorEmprestimo = entity.getValorEmprestimo();
//        this.taxaJuros = entity.getTaxaJuros();
//        this.dataInicio = entity.getDataInicio();
//        this.dataFim = entity.getDataFim();
//        this.saldoDevido = entity.getSaldoDevido();
//        this.idCliente = entity.getIdCliente().getId();
//    }
//}
