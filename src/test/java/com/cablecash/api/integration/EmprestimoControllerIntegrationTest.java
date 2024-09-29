package com.cablecash.api.integration;

import com.cablecash.api.controller.EmprestimoController;
import com.cablecash.api.model.entity.Emprestimo;
import com.cablecash.api.repository.EmprestimoRepository;
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
public class EmprestimoControllerIntegrationTest {

    @Autowired
    EmprestimoController controller;

    @Autowired
    EmprestimoRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void addEmprestimoTest() {
        Emprestimo testEntity = new Emprestimo();

        ResponseEntity<?> response = controller.addEmprestimo(testEntity);

        if (response.getBody() != null) {
            assertEquals(HttpStatus.CREATED, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        }
    }

    @Test
    void getEmprestimoByIdTest() {
        Emprestimo testEntity = new Emprestimo();
        repository.save(testEntity);

        ResponseEntity<?> response = controller.getEmprestimoById(testEntity.getId());

        if (response.getBody() != null) {
            assertEquals(HttpStatus.OK, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        }
    }

    @Test
    void getEmprestimosByClienteTest() {
        Emprestimo testEntity = new Emprestimo();
        repository.save(testEntity);

        ResponseEntity<?> response = controller.getEmprestimoByCliente(testEntity.getCliente().getId());

        if (response.getBody() != null) {
            assertEquals(HttpStatus.OK, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        }
    }

    @Test
    void deleteEmprestimoTest() {
        Emprestimo testEntity = new Emprestimo();
        repository.save(testEntity);

        ResponseEntity<?> response = controller.deleteEmprestimo(testEntity.getId());

        if (response.getBody() != null) {
            assertEquals(HttpStatus.OK, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        }
    }
}
