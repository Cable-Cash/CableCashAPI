package com.cablecash.api.model.entity._public;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Schema(description = "Modelo de cliente")
@Getter
@Setter
@Entity
@Table(name = "cliente", schema = "public")
public class Cliente {

    @Schema(description = "ID do cliente", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Schema(description = "Nome do cliente", example = "Antonio")
    @Column(name = "nome", length = 100, nullable = false)
    private String nome;

    @Schema(description = "Sobrenome do cliente", example = "Carlos")
    @Column(name = "sobrenome", length = 100, nullable = false)
    private String sobrenome;

    @Schema(description = "Data de nascimento do cliente", example = "01/01/2000")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    @Column(name = "dataNascimento", nullable = false)
    private Date dataNascimento;

    @Schema(description = "CPF do cliente", example = "123.456.789-01")
    @Column(name = "cpf",  length = 11, unique = true, nullable = false)
    private String cpf;

    @Schema(description = "E-mail do cliente", example = "email@email.com")
    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;

    @Schema(description = "Telefone do cliente", example = "(99) 99999-9999")
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    @Schema(description = "Endereço do cliente", example = "Rua dos Reis, nº 0")
    @Column(name = "endereco", nullable = false)
    private String endereco;

    @Schema(description = "Renda mensal do cliente", example = "R$ 1.000,00")
    @Column(name = "rendaMensal", precision = 15, scale = 2)
    private BigDecimal rendaMensal;

    @PrePersist
    private void prePersist() {
        if (this.rendaMensal == null) {
            this.rendaMensal = BigDecimal.ZERO;
        }
    }
}
