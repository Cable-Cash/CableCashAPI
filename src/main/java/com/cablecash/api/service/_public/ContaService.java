package com.cablecash.api.service._public;

import com.cablecash.api.model.dto._public.ContaDTO;
import com.cablecash.api.repository._public.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ContaService {

    @Autowired
    ContaRepository repository;

    public Stream<ContaDTO> getContas() {
        return repository.findAll().stream().map(ContaDTO::new);
    }
}
