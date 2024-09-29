package com.cablecash.api.unit.controller;

import com.cablecash.api.model.entity.Cartao;
import com.cablecash.api.repository.CartaoRepository;
import com.cablecash.api.service.CartaoService;
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
public class CartaoControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    CartaoService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    CartaoRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void addCartaoTest() throws Exception {
        mockMvc.perform(post("/api/cartao/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new Cartao())))
                .andExpect(status().isCreated());
    }

    @Test
    void getCartaoByIdTest() throws Exception {
        mockMvc.perform(get("/api/cartao/1"))
                .andExpect(status().isOk());
    }

    @Test
    void getCartaoByIdNotFoundTest() throws Exception {
        mockMvc.perform(get("/api/cartao/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getCartaoByIdBadRequestTest() throws Exception {
        mockMvc.perform(get("/api/cartao/0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getCartaoByIdInternalServerErrorTest() throws Exception {
        mockMvc.perform(get("/api/cartao/1"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void getCartaoByClienteTest() throws Exception {
        mockMvc.perform(get("/api/cartao/cliente/1"))
                .andExpect(status().isOk());
    }

    @Test
    void getCartaoByClienteNotFoundTest() throws Exception {
        mockMvc.perform(get("/api/cartao/cliente/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getCartaoByClienteBadRequestTest() throws Exception {
        mockMvc.perform(get("/api/cartao/cliente/0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getCartaoByClienteInternalServerErrorTest() throws Exception {
        mockMvc.perform(get("/api/cartao/cliente/1"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void deleteCartaoTest() throws Exception {
        mockMvc.perform(delete("/api/cartao/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteCartaoNotFoundTest() throws Exception {
        mockMvc.perform(delete("/api/cartao/1"))
                .andExpect(status().isNotFound());
    }
}
