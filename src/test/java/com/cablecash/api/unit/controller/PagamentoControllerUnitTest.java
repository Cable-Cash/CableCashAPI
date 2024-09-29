package com.cablecash.api.unit.controller;

import com.cablecash.api.model.entity.Pagamento;
import com.cablecash.api.repository.PagamentoRepository;
import com.cablecash.api.service.PagamentoService;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PagamentoControllerUnitTest {

    @MockBean
    PagamentoService service;

    @Autowired
    PagamentoRepository repository;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void addPagamentoTest() throws Exception {
        mockMvc.perform(post("/api/pagamento/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new Pagamento())))
                .andExpect(status().isCreated());
    }

    @Test
    void getPagamentoByContaTest() throws Exception {
        mockMvc.perform(get("/api/pagamento/conta=1"))
                .andExpect(status().isOk());
    }

    @Test
    void getPagamentoByContaNotFoundTest() throws Exception {
        mockMvc.perform(get("/api/pagamento/conta=1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getPagamentoByContaBadRequestTest() throws Exception {
        mockMvc.perform(get("/api/pagamento/conta=abc"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getPagamentoByContaInternalServerErrorTest() throws Exception {
        mockMvc.perform(get("/api/pagamento/conta=0"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void addPagamentoExceptionTest() throws Exception {
        Pagamento testEntity = new Pagamento();
    }

    @Test
    void getPagamentoByCartaoTest() throws Exception {
        mockMvc.perform(get("/api/pagamento/cartao=1"))
                .andExpect(status().isOk());
    }

    @Test
    void getPagamentoByCartaoNotFoundTest() throws Exception {
        mockMvc.perform(get("/api/pagamento/cartao=1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getPagamentoByCartaoBadRequestTest() throws Exception {
        mockMvc.perform(get("/api/pagamento/cartao=0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getPagamentoByCartaoInternalServerErrorTest() throws Exception {
        mockMvc.perform(get("/api/pagamento/cartao=1"))
                .andExpect(status().isInternalServerError());
    }

}
