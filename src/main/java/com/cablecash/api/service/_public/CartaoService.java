package com.cablecash.api.service._public;

import com.cablecash.api.model.dto._public.CartaoDTO;
import com.cablecash.api.repository._public.CartaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class CartaoService {

    @Autowired
    CartaoRepository repository;

    public Stream<CartaoDTO> findAll() {
        return repository.findAll().stream().map(CartaoDTO::new);
    }
}
