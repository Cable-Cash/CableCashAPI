package com.cablecash.api.service;

import com.cablecash.api.model.dto.CartaoDTO;
import com.cablecash.api.model.entity.Cartao;
import com.cablecash.api.repository.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CartaoService {

    @Autowired
    CartaoRepository repository;

    public CartaoDTO addCartao(Cartao entity) {
        try {
            return new CartaoDTO(repository.save(entity));
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao criar cartão: " + ex.getMessage());
        }
    }

    public CartaoDTO getCartaoById(Long id) {
        Cartao cartao = repository.findById(id).orElseThrow(
                        () -> new RuntimeException("Cartão não encontrado!")
                );
        return new CartaoDTO(cartao);
    }

    public List<CartaoDTO> getCartaoByCliente(Long id) {
        List<Cartao> cartoes = repository.findByClienteId(id);
        if (cartoes.isEmpty()) {
            throw new RuntimeException("Cartão não encontrado!");
        }
        return cartoes.stream()
                .map(CartaoDTO::new)
                .collect(Collectors.toList());
    }

    public void deleteCartao(Long id) {
        Cartao entity = repository.findById(id).orElseThrow(
                        () -> new RuntimeException("Cartão não encontrado!")
                );
        try {
            repository.delete(entity);
        } catch (Exception ex) {
            throw new RuntimeException("Erro ao deletar cartão!");
        }
    }
}
