package com.cablecash.api.service._public;

import com.cablecash.api.model.dto._public.TransacaoDTO;
import com.cablecash.api.repository._public.TransacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class TransacaoService {

    @Autowired
    TransacaoRepository repository;

    public Stream<TransacaoDTO> listarTransacoes() {
        return repository.findAll().stream().map(TransacaoDTO::new);
    }
}
