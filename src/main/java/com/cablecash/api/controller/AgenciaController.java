package com.cablecash.api.controller;

import com.cablecash.api.model.dto._public.AgenciaDTO;
import com.cablecash.api.service._public.AgenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/agencia", produces = "application/json")
public class AgenciaController {

//    @Autowired
//    AgenciaService service;
//
//    @GetMapping(value = "/get")
//    public Stream<AgenciaDTO> getAgencias() {
//        return service.getAgencias();
//    }
}
