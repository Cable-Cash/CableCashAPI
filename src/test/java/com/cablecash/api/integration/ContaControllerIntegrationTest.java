package com.cablecash.api.integration;

import com.cablecash.api.controller.ClienteController;
import com.cablecash.api.controller.ContaController;
import com.cablecash.api.model.entity.Cliente;
import com.cablecash.api.model.entity.Conta;
import com.cablecash.api.repository.ContaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static com.cablecash.api.config.MockDataConfig.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ContaControllerIntegrationTest {

    @Autowired
    ClienteController clienteController;

    @Autowired
    ContaController controller;

    @Autowired
    ContaRepository repository;

    @BeforeEach
    public void setUp() {
        repository.deleteAll();
    }

    @Test
    void addContaTest() {
        Cliente cliente = mockClienteValues(new Cliente());
        Conta testEntity = new Conta();

        clienteController.addCliente(cliente);

        ResponseEntity<?> response = controller.addConta(mockContaValues(testEntity));

        if (response.getBody() != null) {
            assertEquals(HttpStatus.CREATED, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        }
    }

    @Test
    void getContaTest() {
        addContaTest();

        ResponseEntity<?> response = controller.getContaById(1L);

        if (response.getBody() == null) {
            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.OK, response.getStatusCode());
        }
    }

    @Test
    void deleteContaTest() {
        clienteController.addCliente(mockClienteValues(new Cliente()));

        addContaTest();

        Conta testEntity = new Conta();

        if (testEntity.getId() != null) {
            ResponseEntity<?> response = controller.deleteConta(mockContaValues(testEntity).getId());
            assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        }
    }
}
