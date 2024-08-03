package com.cablecash.api.controller;

import com.cablecash.api.model.dto._public.ClienteDTO;
import com.cablecash.api.service._public.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/cliente", produces = "application/json")
public class ClienteController {

    @Autowired
    ClienteService service;

    @GetMapping(value = "/get")
    public Stream<ClienteDTO> getClientes() {
        return service.getClientes();
    }
}
