package com.cablecash.api.controller;

import com.cablecash.api.model.entity.ChavePIX;
import com.cablecash.api.service.ChavePIXService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/chavepix", produces = "application/json")
@Tag(
        name = "Chave PIX",
        description = "Endpoint de Chave PIX"
)
public class ChavePIXController {

    @Autowired
    ChavePIXService service;

    @PostMapping(value = "/new")
    @Operation(
            summary = "Criar nova Chave PIX.",
            description = "Cria uma nova chave PIX com as informações fornecidas."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Chave criada com sucesso."
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Dados inválidos fornecidos."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor."
                    )
            }
    )
    public ResponseEntity<?> addChavePIX(@RequestBody ChavePIX entity) {
        try {
            return ResponseEntity.status(201).body(service.addChavePIX(entity));
        } catch (Exception ex) {
            return ResponseEntity.status(400).body(ex.getMessage());
        }
    }

    @GetMapping(value = "/conta={id}")
    @Operation(
            summary = "Buscar Chave PIX por ID da Conta.",
            description = "Busca a Chave PIX através do ID da Conta."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Chave PIX encontrada com sucesso."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Chave PIX não encontrada."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor."
                    )
            }
    )
    public ResponseEntity<?> getChavePIXByConta(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(200).body(service.getChavePIXByConta(id));
        } catch (Exception ex) {
            return ResponseEntity.status(404).body("Erro ao buscar chave PIX: " + ex.getMessage());
        }
    }

    @GetMapping(value = "/cliente={id}")
    @Operation(
            summary = "Buscar Chave PIX por ID da Cliente.",
            description = "Busca a Chave PIX através do ID da Cliente."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Chave PIX encontrada com sucesso."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Chave PIX não encontrada."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor."
                    )
            }
    )
    public ResponseEntity<?> getChavePIXByCliente(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(202).body(service.getChavePIXByCliente(id));
        } catch (Exception ex) {
            return ResponseEntity.status(404).body("Erro ao buscar chave PIX: " + ex.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    @Operation(
            summary = "Deletar Chave PIX.",
            description = "Deleta a Chave PIX através do ID."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Chave PIX deletada com sucesso."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Chave PIX não encontrada."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor."
                    )
            }
    )
    public ResponseEntity<?> deleteChavePIX(Long id) {
        try {
            service.deleteChavePIX(id);
            return ResponseEntity.status(204).body("Chave PIX deletada com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.status(404).body("Erro ao deletar chave PIX: " + ex.getMessage());
        }
    }
}
