package com.cablecash.api.service;

import com.cablecash.api.exception.ChavePIXException;
import com.cablecash.api.model.dto.ChavePIXDTO;
import com.cablecash.api.model.entity.ChavePIX;
import com.cablecash.api.repository.ChavePIXRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ChavePIXService {

    @Autowired
    ChavePIXRepository repository;

    public ChavePIXDTO addChavePIX(ChavePIX entity) {
        try {
            return new ChavePIXDTO(repository.save(entity));
        } catch (Exception ex) {
            throw new ChavePIXException("Erro ao criar chave PIX: " + ex.getMessage());
        }
    }

    public List<ChavePIXDTO> getChavePIXByConta(Long id) {
        List<ChavePIX> contas = repository.findByContaId(id);
        if (contas.isEmpty()) {
            throw new ChavePIXException("Chave PIX não encontrada!");
        }
        return contas.stream().map(ChavePIXDTO::new).collect(Collectors.toList());
    }

    public List<ChavePIXDTO> getChavePIXByCliente(Long id) {
        List<ChavePIX> cliente = repository.findByClienteId(id);
        if (cliente.isEmpty()) {
            throw new ChavePIXException("Chave PIX não encontrada!");
        }
        return cliente.stream().map(ChavePIXDTO::new).collect(Collectors.toList());
    }

    public void deleteChavePIX(Long id) {
        ChavePIX entity = repository.findById(id).orElseThrow(
                () -> new ChavePIXException("Chave PIX não encontrada!")
        );
        try {
            repository.delete(entity);
        } catch (Exception ex) {
            throw new ChavePIXException("Erro ao deletar chave PIX!");
        }
    }
}
