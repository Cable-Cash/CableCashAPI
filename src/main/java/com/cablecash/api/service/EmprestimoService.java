package com.cablecash.api.service;

import com.cablecash.api.model.dto.EmprestimoDTO;
import com.cablecash.api.model.entity.Emprestimo;
import com.cablecash.api.repository.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmprestimoService {

    @Autowired
    EmprestimoRepository repository;

    public EmprestimoDTO addEmprestimo(Emprestimo entity) {
        try {
            return new EmprestimoDTO(repository.save(entity));
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao criar empréstimo: " + ex.getMessage());
        }
    }

    public EmprestimoDTO getEmprestimoById(Long id) {
        return repository.findById(id)
                .map(EmprestimoDTO::new)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado!"));
    }

    public List<EmprestimoDTO> getEmprestimoByCliente(Long id) {
        List<Emprestimo> emprestimos = repository.findByClienteId(id);
        if (emprestimos.isEmpty()) {
            throw new RuntimeException("Empréstimo não encontrado!");
        }
        return emprestimos.stream()
                .map(EmprestimoDTO::new)
                .collect(Collectors.toList());
    }

    public void deleteEmprestimo(Long id) {
        Emprestimo entity = repository.findById(id).orElseThrow(
                        () -> new RuntimeException("Empréstimo não encontrado!")
                );
        try {
            repository.delete(entity);
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar empréstimo!");
        }
    }
}
