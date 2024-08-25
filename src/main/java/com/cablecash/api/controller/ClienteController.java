package com.cablecash.api.controller;

import com.cablecash.api.model.dto._public.ClienteDTO;
import com.cablecash.api.model.entity._public.Cliente;
import com.cablecash.api.service._public.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/cliente", produces = "application/json")
public class ClienteController {

    @Autowired
    ClienteService service;

    @PostMapping("/new")
    public ResponseEntity<ClienteDTO> addCliente(@RequestBody Cliente request) {
        try {
            ClienteDTO response = service.addCliente(request);
            return ResponseEntity.created(URI.create("/new" + response.getId())).body(response);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> getClienteById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.ok(service.getClienteById(id));
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable("id") Long id, @RequestBody Cliente request) {
        try {
            ClienteDTO response = service.updateCliente(id, request);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable("id") Long id) {
        try {
            service.deleteCliente(id);
            return ResponseEntity.ok().build();
        } catch (Exception ex) {
            return ResponseEntity.badRequest().build();
        }
    }
}
