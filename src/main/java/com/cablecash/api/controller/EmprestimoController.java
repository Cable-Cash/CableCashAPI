package com.cablecash.api.controller;

import com.cablecash.api.model.dto._public.EmprestimoDTO;
import com.cablecash.api.service._public.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping(value = "/emprestimo", produces = "application/json")
public class EmprestimoController {

    @Autowired
    EmprestimoService service;

    @GetMapping("/get")
    public Stream<EmprestimoDTO> getAllEmprestimos() {
        return service.getAllEmprestimos();
    }
}
