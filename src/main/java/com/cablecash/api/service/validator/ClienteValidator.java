package com.cablecash.api.service.validator;

import com.cablecash.api.model.entity.Cliente;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

@Component
public class ClienteValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Cliente.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Cliente cliente = (Cliente) target;

        if (cliente.getNome().isEmpty()) {
            errors.rejectValue("Nome", "Nome vazio", "O nome não pode estar vazio.");
        }

        if (cliente.getSobrenome().isEmpty()) {
            errors.rejectValue("Sobrenome", "Sobrenome vazio", "O sobrenome não pode estar vazio.");
        }

        if (cliente.getDataNascimento() == null || cliente.getDataNascimento().toString().isEmpty()) {
            errors.rejectValue("DataNascimento", "Data de nascimento vazia", "A data de nascimento não pode estar vazia.");
        }

        if (cliente.getCpf().isEmpty()) {
            errors.rejectValue("Cpf", "CPF vazio", "O CPF não pode estar vazio.");
        }

        if (cliente.getEmail() != null && !cliente.getEmail().matches("[^@ ]+@[^@ ]+\\.[^@ ]+")) {
            errors.rejectValue("Email", "Email inválido", "O email informado é inválido.");
        }

        if (cliente.getTelefone().isEmpty()) {
            errors.rejectValue("Telefone", "Telefone inválido", "O telefone informado é inválido.");
        }

        if (cliente.getEndereco().isEmpty()) {
            errors.rejectValue("Endereco", "Endereço vazio", "O endereço não pode estar vazio.");
        }

        if (cliente.getRendaMensal() != null) {
            if (cliente.getRendaMensal().compareTo(BigDecimal.ZERO) < 0) {
                errors.rejectValue("RendaMensal", "Renda mensal inválida", "A renda mensal informada é inválida.");
            }
        }

    }

    public Cliente updateValivator(Cliente entity, Cliente patchEntity) {
        if (entity != null) {
            if (entity.getNome() != null) {
                patchEntity.setNome(entity.getNome());
            }
            if (entity.getSobrenome() != null) {
                patchEntity.setSobrenome(entity.getSobrenome());
            }
            if (entity.getDataNascimento() != null) {
                patchEntity.setDataNascimento(entity.getDataNascimento());
            }
            if (entity.getCpf() != null) {
                patchEntity.setCpf(entity.getCpf());
            }
            if (entity.getEmail() != null) {
                patchEntity.setEmail(entity.getEmail());
            }
            if (entity.getEndereco() != null) {
                patchEntity.setEndereco(entity.getEndereco());
            }
            patchEntity.setTelefone(entity.getTelefone());
            patchEntity.setRendaMensal(entity.getRendaMensal());
        }
        return patchEntity;
    }
}
