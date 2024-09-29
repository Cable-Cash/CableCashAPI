package com.cablecash.api.model.dto;

import com.cablecash.api.model.entity.Emprestimo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
public class EmprestimoDTO {

    private Long id;
    private BigDecimal valorEmprestimo;
    private BigDecimal taxaJuros;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataInicio;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date dataFim;

    private BigDecimal saldoDevido;
    private Long cliente;

    public EmprestimoDTO(Emprestimo entity) {
        this.id = entity.getId();
        this.valorEmprestimo = entity.getValorEmprestimo();
        this.taxaJuros = entity.getTaxaJuros();
        this.dataInicio = entity.getDataInicio();
        this.dataFim = entity.getDataFim();
        this.saldoDevido = entity.getSaldoDevido();
        this.cliente = entity.getCliente().getId();
    }
}
