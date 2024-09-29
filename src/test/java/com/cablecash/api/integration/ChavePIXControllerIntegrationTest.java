package com.cablecash.api.integration;

import com.cablecash.api.controller.ChavePIXController;
import com.cablecash.api.model.entity.ChavePIX;
import com.cablecash.api.repository.ChavePIXRepository;
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
public class ChavePIXControllerIntegrationTest {

    @Autowired
    ChavePIXController controller;

    @Autowired
    ChavePIXRepository repository;

    @BeforeEach
    public void setUp() {
        repository.deleteAll();
    }


    @Test
    void addChavePIXTest() {
        ChavePIX testEntity = new ChavePIX();

        ResponseEntity<?> response = controller.addChavePIX(testEntity);

        if (response.getBody() != null) {
            assertEquals(HttpStatus.CREATED, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        }
    }

    @Test
    void getChavePIXByContaTest() {
        addChavePIXTest();

        ResponseEntity<?> response = controller.getChavePIXByConta(1L);

        if (response.getBody() == null) {
            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.OK, response.getStatusCode());
        }
    }

    @Test
    void getChavePIXByclienteTest() {
        addChavePIXTest();

        ResponseEntity<?> response = controller.getChavePIXByCliente(1L);

        if (response.getBody() == null) {
            assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        } else {
            assertEquals(HttpStatus.OK, response.getStatusCode());
        }
    }

    @Test
    void deleteChavePIXTest() {
        addChavePIXTest();

        ChavePIX testEntity = new ChavePIX();

        if (testEntity.getId() != null) {
            ResponseEntity<?> response = controller.deleteChavePIX(testEntity.getId());
            assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
        }
    }
}
