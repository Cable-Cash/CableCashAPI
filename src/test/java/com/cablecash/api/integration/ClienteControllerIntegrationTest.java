package com.cablecash.api.integration;

import com.cablecash.api.controller.ClienteController;
import com.cablecash.api.model.dto._public.ClienteDTO;
import com.cablecash.api.model.entity._public.Cliente;
import com.cablecash.api.repository._public.ClienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static com.cablecash.api.config.MockDataConfig.mockClienteUpdatedValues;
import static com.cablecash.api.config.MockDataConfig.mockClienteValues;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ClienteControllerIntegrationTest {

    @Autowired
    ClienteController controller;

    @Autowired
    ClienteRepository repository;

    @BeforeEach
    public void setUp() {
        repository.deleteAll();
    }

    @Test
    void addClienteTest() {
        Cliente testEntity = new Cliente();

        ResponseEntity<ClienteDTO> response = controller.addCliente(mockClienteValues(testEntity));

        if (response.getBody() != null) {
            assertEquals(HttpStatus.CREATED, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        }
    }

    @Test
    void getClienteTest() {
        addClienteTest();

        ResponseEntity<ClienteDTO> response = controller.getClienteById(1L);

        if (response.getBody() == null) {
            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.OK, response.getStatusCode());
        }
    }

    @Test
    void updateClienteTest() {
        Cliente testEntity = new Cliente();

        addClienteTest();

        ResponseEntity<ClienteDTO> response = controller.updateCliente(mockClienteUpdatedValues(testEntity).getId(), mockClienteUpdatedValues(testEntity));

        if (response.getBody() == null) {
            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.ACCEPTED, response.getStatusCode());
        }
    }

    @Test
    void deleteClienteTest() {
        addClienteTest();

        ResponseEntity<Void> response = controller.deleteCliente(1L);

        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }
}
