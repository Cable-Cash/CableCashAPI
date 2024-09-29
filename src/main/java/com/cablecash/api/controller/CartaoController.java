package com.cablecash.api.controller;

import com.cablecash.api.model.entity.Cartao;
import com.cablecash.api.service.CartaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/cartao", produces = "application/json")
@Tag(
        name = "Cartão",
        description = "Endpoint de Cartão"
)
public class CartaoController {

    @Autowired
    CartaoService service;

    @PostMapping("/new")
    @Operation(
            summary = "Criar Cartão.",
            description = "Cria um novo cartão."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Cartão criado com sucesso."
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
    public ResponseEntity<?> addCartao(@RequestBody Cartao entity) {
        try {
            return ResponseEntity.status(201).body(service.addCartao(entity));
        } catch (Exception ex) {
            return ResponseEntity.status(400).body("Erro ao criar cartão: " + ex.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar Cartão por ID.",
            description = "Busca o cartão através do ID."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Cartão encontrado com sucesso."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Cartão não encontrada."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor."
                    )
            }
    )
    public ResponseEntity<?> getCartaoById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(200).body(service.getCartaoById(id));
        } catch (Exception ex) {
            return ResponseEntity.status(404).body("Erro ao buscar cartão: " + ex.getMessage());
        }
    }

    @GetMapping("/cliente={id}")
    @Operation(
            summary = "Buscar Cartão por ID do Cliente.",
            description = "Busca o cartão através do ID do cliente."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Cartão encontrado com sucesso."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Cartão não encontrada."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor."
                    )
            }
    )
    public ResponseEntity<?> getCartaoByCliente(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(200).body(service.getCartaoByCliente(id));
        } catch (Exception ex) {
            return ResponseEntity.status(404).body("Erro ao buscar cartão: " + ex.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar Cartão por ID.",
            description = "Deleta o cartão através do ID."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Cartão deletado com sucesso."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Cartão não encontrada."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor."
                    )
            }
    )
    public ResponseEntity<?> deleteCartao(@PathVariable("id") Long id) {
        try {
            service.deleteCartao(id);
            return ResponseEntity.status(204).body("Cartão deletado com sucesso!");
        } catch (Exception ex) {
            return ResponseEntity.status(404).body("Erro ao deletar cartão: " + ex.getMessage());
        }
    }
}
