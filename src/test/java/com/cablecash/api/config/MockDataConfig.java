package com.cablecash.api.config;

import com.cablecash.api.enums.EnumTipoConta;
import com.cablecash.api.model.dto._public.ClienteDTO;
import com.cablecash.api.model.dto._public.ContaDTO;
import com.cablecash.api.model.entity._public.Cliente;
import com.cablecash.api.model.entity._public.Conta;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MockDataConfig {

    public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    public static ClienteDTO transformClienteToDto(Cliente entity) {

        try {
            entity.setId(1L);
            entity.setNome("Nome");
            entity.setSobrenome("Sobrenome");
            entity.setDataNascimento(formatter.parse("01/01/2000"));
            entity.setCpf("12345678901");
            entity.setEmail("teste@email.com");
            entity.setTelefone("5519123456789");
            entity.setEndereco("Rua teste, 123");
            entity.setRendaMensal(BigDecimal.valueOf(1000,0));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }

        return new ClienteDTO(entity);
    }

    public static ContaDTO transformContaToDto(Conta entity) {

        try {
            entity.setId(1L);
            entity.setDataAbertura(new Timestamp(System.currentTimeMillis()));
            entity.setNumeroConta("123456");
            entity.setTipoConta(EnumTipoConta.CONTA_CORRENTE);
            entity.setIdCliente(mockClienteValues(new Cliente()));
            entity.setSaldo(BigDecimal.valueOf(1000,0));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ContaDTO(entity);
    }

    public static Cliente mockClienteValues(Cliente entity) {

        try {
            entity.setId(1L);
            entity.setNome("Nome");
            entity.setSobrenome("Sobrenome");
            entity.setDataNascimento(formatter.parse("01/01/2000"));
            entity.setCpf("12345678901");
            entity.setEmail("teste@email.com");
            entity.setTelefone("5519123456789");
            entity.setEndereco("Rua teste, 123");
            entity.setRendaMensal(BigDecimal.valueOf(1000,0));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }

        return entity;
    }

    public static Cliente mockClienteUpdatedValues(Cliente entity) {

        try {
            entity.setNome("Nome atualizado");
            entity.setSobrenome("Sobrenome atualizado");
            entity.setDataNascimento(formatter.parse("01/01/2000"));
            entity.setCpf("60345274902");
            entity.setEmail("testeatualizado@email.com");
            entity.setTelefone("5519312645978");
            entity.setEndereco("Rua atualizada, 456");
            entity.setRendaMensal(BigDecimal.valueOf(2000,0));
        } catch (ParseException pe) {
            pe.printStackTrace();
        }

        return entity;
    }

    public static Conta mockContaValues(Conta entity) {

        entity.setId(1L);
        entity.setDataAbertura(new Timestamp(System.currentTimeMillis()));
        entity.setNumeroConta("123456");
        entity.setTipoConta(EnumTipoConta.CONTA_CORRENTE);
        entity.setIdCliente(mockClienteValues(new Cliente()));
        entity.setSaldo(BigDecimal.valueOf(1000,0));

        return entity;
    }

    public static Conta mockContaUpdatedValues(Conta entity) {

        entity.setDataAbertura(new Timestamp(System.currentTimeMillis()));
        entity.setNumeroConta("123456");
        entity.setTipoConta(EnumTipoConta.CONTA_CORRENTE);
        entity.setSaldo(BigDecimal.valueOf(2000,0));

        return entity;
    }
}
