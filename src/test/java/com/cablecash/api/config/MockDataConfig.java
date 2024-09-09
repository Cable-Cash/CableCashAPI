package com.cablecash.api.config;

import com.cablecash.api.model.dto._public.ClienteDTO;
import com.cablecash.api.model.entity._public.Cliente;

import java.math.BigDecimal;
import java.util.Date;

public class MockDataConfig {

    public static ClienteDTO transformEntityToDto(Cliente entity) {

        entity.setId(1L);
        entity.setNome("Nome");
        entity.setSobrenome("Sobrenome");
        entity.setDataNascimento(new Date(System.currentTimeMillis()));
        entity.setCpf("12345678901");
        entity.setEmail("teste@email.com");
        entity.setTelefone("5519123456789");
        entity.setEndereco("Rua teste, 123");
        entity.setRendaMensal(BigDecimal.valueOf(1000,0));

        return new ClienteDTO(entity);
    }

    public static Cliente mockClienteValues(Cliente entity) {

        entity.setId(1L);
        entity.setNome("Nome");
        entity.setSobrenome("Sobrenome");
        entity.setDataNascimento(new Date(System.currentTimeMillis()));
        entity.setCpf("12345678901");
        entity.setEmail("teste@email.com");
        entity.setTelefone("5519123456789");
        entity.setEndereco("Rua teste, 123");
        entity.setRendaMensal(BigDecimal.valueOf(1000,0));

        return entity;
    }

    public static Cliente mockClienteUpdatedValues(Cliente entity) {

        entity.setNome("Nome atualizado");
        entity.setSobrenome("Sobrenome atualizado");
        entity.setDataNascimento(new Date(System.currentTimeMillis()));
        entity.setCpf("60345274902");
        entity.setEmail("testeatualizado@email.com");
        entity.setTelefone("5519312645978");
        entity.setEndereco("Rua atualizada, 456");
        entity.setRendaMensal(BigDecimal.valueOf(2000,0));

        return entity;
    }
}
