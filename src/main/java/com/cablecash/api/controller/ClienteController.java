package com.cablecash.api.controller;

import com.cablecash.api.model.entity.Cliente;
import com.cablecash.api.service.ClienteService;
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
@RequestMapping(
        value = "/api/cliente",
        produces = "application/json"
)
@Tag(
        name = "Cliente",
        description = "Endpoint de Cliente"
)
public class ClienteController {

    @Autowired
    ClienteService service;

    @PostMapping("/new")
    @Operation(
            summary = "Cria um novo cliente.",
            description = "Cria um novo cliente com as informações fornecidas."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Cliente criado com sucesso."
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
    public ResponseEntity<?> addCliente(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Objeto do cliente a ser criado.",
                    required = true,
                    content = @io.swagger.v3.oas.annotations.media.Content(
                            schema = @Schema(implementation = Cliente.class)
                    )
            )
            @org.springframework.web.bind.annotation.RequestBody Cliente request
    ) {
        try {
            return ResponseEntity.status(201).body(service.addCliente(request));
        } catch (Exception ex) {
            return ResponseEntity.status(400).body(ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Obtém um cliente por ID.",
            description = "Recupera um cliente específico com base no ID fornecido.")
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Cliente encontrado."
                    ), 
                    @ApiResponse(
                            responseCode = "404",
                            description = "Cliente não encontrado."
                    ), 
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor."
                    )
            }
    )
    public ResponseEntity<?> getClienteById(
            @Parameter(
                    description = "ID do cliente a ser recuperado.",
                    required = true,
                    example = "1"
            )
            @PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(200).body(service.getClienteById(id));
        } catch (Exception ex) {
            return ResponseEntity.status(404).body(ex.getMessage());
        }
    }

    @PatchMapping("/{id}")
    @Operation(
            summary = "Atualiza um cliente existente.",
            description = "Atualiza um cliente com base no ID e nas informações fornecidas."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "202",
                            description = "Cliente atualizado com sucesso."
                    ), 
                    @ApiResponse(
                            responseCode = "400",
                            description = "Dados inválidos fornecidos."
                    ), 
                    @ApiResponse(
                            responseCode = "404",
                            description = "Cliente não encontrado."
                    ), 
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor."
                    )
            }
    )
    public ResponseEntity<?> updateCliente(
            @Parameter(
                    description = "ID do cliente a ser atualizado.",
                    required = true,
                    example = "1"
            )
            @PathVariable("id") Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Objeto do cliente com as informações atualizadas.",
                    required = true,
                    content = @io.swagger.v3.oas.annotations.media.Content(
                            schema = @Schema(
                                    implementation = Cliente.class
                            )
                    )
            )
            @org.springframework.web.bind.annotation.RequestBody Cliente request
    ) {
        try {
            return ResponseEntity.status(202).body(service.updateCliente(id, request));
        } catch (Exception ex) {
            return ResponseEntity.status(400).body(ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deleta um cliente.",
            description = "Remove um cliente existente com base no ID fornecido."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Cliente removido com sucesso."
                    ), 
                    @ApiResponse(
                            responseCode = "404",
                            description = "Cliente não encontrado."
                    ), 
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor."
                    )
            }
    )
    public ResponseEntity<?> deleteCliente(
            @Parameter(
                    description = "ID do cliente a ser deletado.",
                    required = true,
                    example = "1"
            )
            @PathVariable("id") Long id
    ) {
        try {
            service.deleteCliente(id);
            return ResponseEntity.status(202).body("Cliente deletado com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.status(400).body(ex.getMessage());
        }
    }
}
