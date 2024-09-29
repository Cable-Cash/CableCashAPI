package com.cablecash.api.integration;

import com.cablecash.api.controller.CartaoController;
import com.cablecash.api.model.entity.Cartao;
import com.cablecash.api.repository.CartaoRepository;
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
public class CartaoControllerIntegrationTest {

    @Autowired
    CartaoController controller;

    @Autowired
    CartaoRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void addCartaoTest() {
        Cartao testEntity = new Cartao();

        ResponseEntity<?> response = controller.addCartao(testEntity);

        if (response.getBody() != null) {
            assertEquals(HttpStatus.CREATED, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        }
    }

    @Test
    void getCartaoByIdTest() {
        addCartaoTest();

        ResponseEntity<?> response = controller.getCartaoById(1L);

        if (response.getBody() != null) {
            assertEquals(HttpStatus.OK, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        }
    }

    @Test
    void getCartaoByClienteTest() {
        addCartaoTest();

        ResponseEntity<?> response = controller.getCartaoByCliente(1L);

        if (response.getBody() != null) {
            assertEquals(HttpStatus.OK, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        }
    }

    @Test
    void deleteCartaoTest() {
        addCartaoTest();

        Cartao testEntity = new Cartao();

        if (testEntity.getId() != null) {
            ResponseEntity<?> response = controller.deleteCartao(testEntity.getId());

            if (response.getBody() != null) {
                assertEquals(HttpStatus.OK, response.getStatusCode());
            } else {
                assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
            }
        }
    }
}
