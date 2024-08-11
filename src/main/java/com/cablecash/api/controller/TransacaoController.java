package com.cablecash.api.controller;

import com.cablecash.api.model.dto._public.TransacaoDTO;
import com.cablecash.api.service._public.TransacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/transacoes", produces = "application/json")
public class TransacaoController {

    @Autowired
    TransacaoService service;

    @GetMapping("/listar")
    public Stream<TransacaoDTO> listarTransacoes() {
        return service.listarTransacoes();
    }
}
