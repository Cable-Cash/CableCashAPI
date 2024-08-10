package com.cablecash.api.controller;

import com.cablecash.api.model.dto._public.ChavePIXDTO;
import com.cablecash.api.service._public.ChavePIXService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/chavepix", produces = "application/json")
public class ChavePIXController {

    @Autowired
    ChavePIXService service;

    @GetMapping(value = "/get")
    public Stream<ChavePIXDTO> getAllPIX() {
        return service.getChavePIXs();
    }
}
