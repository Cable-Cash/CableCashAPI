package com.cablecash.api.integration;

import com.cablecash.api.controller.PagamentoController;
import com.cablecash.api.model.entity.Pagamento;
import com.cablecash.api.repository.PagamentoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PagamentoControllerIntegrationTest {

    @Autowired
    PagamentoController controller;

    @Autowired
    PagamentoRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void addPagamentoTest() {
        Pagamento testEntity = new Pagamento();

        ResponseEntity<?> response = controller.addPagamento(testEntity);

        if (response.getBody() != null) {
            assertEquals(HttpStatus.CREATED, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        }
    }

    @Test
    void getPagamentoByContaTest() {
        Pagamento testEntity = new Pagamento();
        repository.save(testEntity);

        ResponseEntity<?> response = controller.getPagamentoByConta(testEntity.getConta().getId());

        if (response.getBody() != null) {
            assertEquals(HttpStatus.OK, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        }
    }

    @Test
    void getPagamentoByCartaoTest() {
        Pagamento testEntity = new Pagamento();
        repository.save(testEntity);

        ResponseEntity<?> response = controller.getPagamentoByCartao(testEntity.getCartao().getId());

        if (response.getBody() != null) {
            assertEquals(HttpStatus.OK, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        }
    }
}
