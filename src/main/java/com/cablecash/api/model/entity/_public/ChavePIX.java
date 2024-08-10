package com.cablecash.api.model.entity._public;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "chave_pix", schema = "public")
public class ChavePIX {

    @Id
    @GeneratedValue(generator = "chave_pix_id_seq")
    private Long id;

    @Column(name = "tipo_chave", length = 20, nullable = false)
    private String tipoChave;

    @Column(name = "valor_chave", length = 255, unique = true, nullable = false)
    private String valorChave;

    @Column(name = "data_criacao", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp dataCriacao;

    private Long idCliente;
    
    private Long idConta;

//    id SERIAL PRIMARY KEY,
//    tipo_chave VARCHAR(20) NOT NULL,
//    valor_chave VARCHAR(255) UNIQUE NOT NULL,
//    id_cliente INT NOT NULL,
//    id_conta INT NOT NULL,
//    data_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
//    FOREIGN KEY (id_cliente) REFERENCES Cliente(id),
//    FOREIGN KEY (id_conta) REFERENCES Conta(id)
}
