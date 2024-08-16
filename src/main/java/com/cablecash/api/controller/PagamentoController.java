package com.cablecash.api.controller;

import com.cablecash.api.model.dto._public.PagamentoDTO;
import com.cablecash.api.service._public.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/pagamento", produces = "application/json")
public class PagamentoController {

    @Autowired
    PagamentoService service;

    @GetMapping(value = "/get")
    public Stream<PagamentoDTO> findAll() {
        return service.findAll();
    }
}
