package com.cablecash.api.service._public;

import com.cablecash.api.model.dto._public.PagamentoDTO;
import com.cablecash.api.repository._public.PagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class PagamentoService {

    @Autowired
    PagamentoRepository repository;

    public Stream<PagamentoDTO> findAll() {
        return repository.findAll().stream().map(PagamentoDTO::new);
    }
}
