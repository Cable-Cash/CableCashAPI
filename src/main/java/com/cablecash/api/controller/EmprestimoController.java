package com.cablecash.api.controller;

import com.cablecash.api.model.entity.Emprestimo;
import com.cablecash.api.service.EmprestimoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/emprestimo", produces = "application/json")
@Tag(
        name = "Empréstimo",
        description = "Endpoint de Empréstimo"
)
public class EmprestimoController {

    @Autowired
    EmprestimoService service;

    @PostMapping("/new")
    @Operation(
            summary = "Criar Empréstimo.",
            description = "Cria um novo empréstimo."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Empréstimo criado com sucesso."
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
    public ResponseEntity<?> addEmprestimo(@RequestBody Emprestimo request) {
        try {
            return ResponseEntity.status(201).body(service.addEmprestimo(request));
        } catch (Exception e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar Empréstimo por ID.",
            description = "Busca o empréstimo através do ID."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Empréstimo encontrada com sucesso."
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
    public ResponseEntity<?> getEmprestimoById(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(200).body(service.getEmprestimoById(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/cliente={id}")
    @Operation(
            summary = "Buscar Empréstimo por ID do Cliente.",
            description = "Busca o empréstimo através do ID do cliente."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Empréstimo encontrada com sucesso."
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
    public ResponseEntity<?> getEmprestimoByCliente(@PathVariable("id") Long id) {
        try {
            return ResponseEntity.status(200).body(service.getEmprestimoByCliente(id));
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Deletar Empréstimo por ID.",
            description = "Deleta o empréstimo através do ID."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Empréstimo deletado com sucesso."
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Empréstimo não encontrada."
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno do servidor."
                    )
            }
    )
    public ResponseEntity<?> deleteEmprestimo(@PathVariable("id") Long id) {
        try {
            service.deleteEmprestimo(id);
            return ResponseEntity.status(204).body("Empréstimo deletado com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
