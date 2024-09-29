package com.cablecash.api.controller;

import com.cablecash.api.model.entity.Pagamento;
import com.cablecash.api.service.PagamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/pagamento", produces = "application/json")
@Tag(
        name = "Pagamento",
        description = "Endpoint de Pagamento"
)
public class PagamentoController {

    @Autowired
    PagamentoService service;

    @PostMapping("/new")
    @Operation(
            summary = "Criar Pagamento.",
            description = "Cria um novo pagamento."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Pagamento criado com sucesso."
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
    public ResponseEntity<?> addPagamento(@RequestBody Pagamento request) {
        try {
            return ResponseEntity.status(201).body(service.addPagamento(request));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/conta={id}")
    @Operation(
            summary = "Buscar Pagamento por ID da Conta.",
            description = "Busca pagamentos através do ID da conta."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Pagamento encontrado."
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Pagamento não encontrado."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor."
                    )
            }
    )
    public ResponseEntity<?> getPagamentoByConta(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(200).body(service.getPagamentosByConta(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/cartao={id}")
    @Operation(
            summary = "Buscar Pagamento por ID do Cartão.",
            description = "Busca pagamentos através do ID do cartão."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Pagamento encontrado."
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Pagamento não encontrado."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor."
                    )
            }
    )
    public ResponseEntity<?> getPagamentoByCartao(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(200).body(service.getPagamentosByCartao(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
