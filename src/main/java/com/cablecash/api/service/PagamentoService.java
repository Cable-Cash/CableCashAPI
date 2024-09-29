package com.cablecash.api.service;

import com.cablecash.api.model.dto.PagamentoDTO;
import com.cablecash.api.model.entity.Pagamento;
import com.cablecash.api.repository.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PagamentoService {

    @Autowired
    PagamentoRepository repository;

    public PagamentoDTO addPagamento(Pagamento entity) {
        try {
            return new PagamentoDTO(repository.save(entity));
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao criar pagamento: " + ex.getMessage());
        }
    }

    public List<PagamentoDTO> getPagamentosByConta(Long id) {
        try {
            List<Pagamento> pagamentos = repository.findByContaId(id);
            if (pagamentos.isEmpty()) {
                throw new RuntimeException("Pagamento não encontrado!");
            }
            return pagamentos.stream()
                    .map(PagamentoDTO::new)
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao buscar pagamentos: " + ex.getMessage());
        }
    }

    public List<PagamentoDTO> getPagamentosByCartao(Long id) {
        try {
            List<Pagamento> pagamentos = repository.findByCartaoId(id);
            if (pagamentos.isEmpty()) {
                throw new RuntimeException("Pagamento não encontrado!");
            }
            return pagamentos.stream()
                    .map(PagamentoDTO::new)
                    .collect(Collectors.toList());
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao buscar pagamentos: " + ex.getMessage());
        }
    }
}
