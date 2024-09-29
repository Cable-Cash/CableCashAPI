package com.cablecash.api.controller;

import com.cablecash.api.model.entity.Conta;
import com.cablecash.api.service.ContaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/conta", produces = "application/json")
@Tag(
        name = "Conta",
        description = "Endpoint de Conta"
)
public class ContaController {

    @Autowired
    ContaService service;

    @PostMapping("/new")
    @Operation(
            summary = "Criar conta.",
            description = "Cria uma nova conta com as informações fornecidas."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Conta criada com sucesso."
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
    public ResponseEntity<?> addConta(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Objeto da conta a ser criado.",
                    required = true,
                    content = @io.swagger.v3.oas.annotations.media.Content(
                            schema = @Schema(implementation = Conta.class)
                    )
            )
            @org.springframework.web.bind.annotation.RequestBody Conta request
    ) {
        try {
            return ResponseEntity.status(201).body(service.addConta(request));
        } catch (Exception ex) {
            return ResponseEntity.status(400).body(ex.getMessage());
        }
    }

    @GetMapping(value = "/{id}")
    @Operation(
            summary = "Obter conta por ID.",
            description = "Recupera uma conta específica com base no ID fornecido.")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Conta encontrada."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Conta não encontrada."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor."
                    )
            }
    )
    public ResponseEntity<?> getContaById(
            @Parameter(
                    description = "ID da conta a ser recuperada.",
                    required = true,
                    example = "1"
            )
            @PathVariable("id") Long id
    ) {
        try {
            return ResponseEntity.status(200).body(service.getContaById(id));
        } catch (Exception ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @GetMapping(value = "/cliente={id}")
    @Operation(
            summary = "Obter conta por ID do cliente.",
            description = "Recupera uma conta específica com base no ID do cliente fornecido.")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Conta encontrada."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Conta não encontrada."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor."
                    )
            }
    )
    public ResponseEntity<?> getContaByCliente(
            @Parameter(
                    description = "ID do cliente da conta a ser buscada.",
                    required = true,
                    example = "1"
            )
            @PathVariable("id") Long id
    ) {
        try {
            return ResponseEntity.status(202).body(service.getContaByCliente(id));
        } catch (Exception ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @DeleteMapping(value = "/{id}")
    @Operation(
            summary = "Deletar conta.",
            description = "Deleta uma conta específica com base no ID fornecido.")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Conta deletada com sucesso."
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
    public ResponseEntity<?> deleteConta(
            @Parameter(
                    description = "ID da conta a ser deletado.",
                    required = true,
                    example = "1"
            )
            @PathVariable("id") Long id
    ) {
        try {
            service.deleteConta(id);
            return ResponseEntity.status(204).body("Conta deletada com sucesso.");
        } catch (Exception ex) {
            return ResponseEntity.status(400).body(ex.getMessage());
        }
    }
}
