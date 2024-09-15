package com.cablecash.api.service.validator;

import com.cablecash.api.enums.EnumTipoConta;
import com.cablecash.api.exception.ContaException;
import com.cablecash.api.model.entity._public.Conta;
import com.cablecash.api.repository._public.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ContaValidator implements Validator {

    @Autowired
    private ContaRepository repository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Conta.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Conta conta = (Conta) target;
        if (repository.findByTipoConta(conta.getTipoConta()).isPresent()) {
            errors.rejectValue("tipoConta", "Conta com o mesmo tipo já existe!");
        }
    }

    public void validate(Conta conta) {
        conta.setTipoConta(EnumTipoConta.valueOf(conta.getTipoConta().toString()));
        if (conta.getTipoConta().equals(EnumTipoConta.CONTA_SALARIO) && repository.findByTipoConta(EnumTipoConta.CONTA_SALARIO).isPresent()) {
            throw new ContaException("Cliente já contém conta salário!");
        }
    }
}
