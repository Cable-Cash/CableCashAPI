package com.cablecash.api.controller;

import com.cablecash.api.model.dto._public.ContaDTO;
import com.cablecash.api.service._public.ContaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/conta", produces = "application/json")
public class ContaController {

    @Autowired
    ContaService service;

    @GetMapping(value = "/get")
    public Stream<ContaDTO> getContas() {
        return service.getContas();
    }
}
