package com.cablecash.api.unit.controller;

import com.cablecash.api.exception.ContaException;
import com.cablecash.api.model.entity.Conta;
import com.cablecash.api.repository.ContaRepository;
import com.cablecash.api.service.ContaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static com.cablecash.api.config.MockDataConfig.mockContaValues;
import static com.cablecash.api.config.MockDataConfig.transformContaToDto;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ContaControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ContaService service;

    @Autowired
    ContaRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        repository.deleteAll();
    }

    @Test
    void addContaTest() throws Exception {
        Conta testEntity = new Conta();

        when(service.addConta(any(Conta.class))).thenReturn(transformContaToDto(testEntity));

        mockMvc.perform(post("/api/conta/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testEntity)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(transformContaToDto(testEntity))));
    }

    @Test
    void addContaExceptionTest() throws Exception {
        Conta testEntity = new Conta();
        String errorMessage = "Erro ao adicionar conta!";

        when(service.addConta(any(Conta.class))).thenThrow(new ContaException(errorMessage));

        mockMvc.perform(post("/api/conta/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testEntity)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getContaByIdTest() throws Exception {
        Conta testEntity = new Conta();

        when(service.getContaById(1L)).thenReturn(transformContaToDto(testEntity));

        mockMvc.perform(get("/api/conta/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(transformContaToDto(testEntity))));
    }

    @Test
    void getContaByIdExceptionTest() throws Exception {
        String errorMessage = "Conta não encontrada!";

        when(service.getContaById(1L)).thenThrow(new ContaException(errorMessage));

        mockMvc.perform(get("/api/conta/1"))
                .andExpect(status().isNotFound());
    }

//    @Test
//    void  updateContaTest() throws Exception {
//        Conta testEntity = mockContaValues(new Conta());
//
//        when(service.updateConta(1L, testEntity)).thenReturn(transformContaToDto(testEntity));
//
//        mockMvc.perform(put("/api/conta/1")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(testEntity)))
//                .andExpect(status().isAccepted());
//    }
}
