package com.cablecash.api.service._public;

import com.cablecash.api.exception.ContaException;
import com.cablecash.api.model.dto._public.ContaDTO;
import com.cablecash.api.model.entity._public.Conta;
import com.cablecash.api.repository._public.ContaRepository;
import com.cablecash.api.service.validator.ContaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ContaService {

    @Autowired
    ContaRepository repository;

    @Autowired
    ContaValidator validator;

    public ContaDTO addConta(Conta entity) {
        try {
//            validator.validate(entity);
            return new ContaDTO(repository.save(entity));
        } catch (Exception ex) {
            throw new ContaException("Erro ao criar conta: " + ex.getMessage());
        }
    }

    public ContaDTO getContaById(Long id) {
        return repository.findById(id)
                .map(ContaDTO::new)
                .orElseThrow(() -> new ContaException("Conta não encontrada!"));
    }

    public List<ContaDTO> getContaByCliente(Long id) {
        List<Conta> contas = repository.findByClienteId(id);
        if (contas.isEmpty()) {
            throw new ContaException("Conta não encontrada!");
        }
        return contas.stream()
                .map(ContaDTO::new)
                .collect(Collectors.toList());
    }

    public void deleteConta(Long id) {
        Conta entity = repository.findById(id).orElseThrow(
                        () -> new ContaException("Conta não encontrada!")
                );
        try {
            repository.delete(entity);
        } catch (Exception ex) {
            throw new ContaException("Erro ao deletar conta!");
        }
    }
}
