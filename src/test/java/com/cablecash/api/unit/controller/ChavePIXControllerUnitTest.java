package com.cablecash.api.unit.controller;

import com.cablecash.api.model.entity.ChavePIX;
import com.cablecash.api.repository.ChavePIXRepository;
import com.cablecash.api.service.ChavePIXService;
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

import static com.cablecash.api.config.MockDataConfig.listTransformChavePIXToDto;
import static com.cablecash.api.config.MockDataConfig.transformChavePIXToDto;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ChavePIXControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ChavePIXService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    ChavePIXRepository repository;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void addChavePIXTest() throws Exception {
        ChavePIX testEntity = new ChavePIX();

        when(service.addChavePIX(any(ChavePIX.class))).thenReturn(transformChavePIXToDto(testEntity));

        mockMvc.perform(post("/api/pix/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testEntity)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(testEntity)));
    }

    @Test
    void addChavePIXInvalidDataTest() throws Exception {
        ChavePIX testEntity = new ChavePIX();

        when(service.addChavePIX(any(ChavePIX.class))).thenThrow(new Exception("Dados inválidos fornecidos."));

        mockMvc.perform(post("/api/pix/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testEntity)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Dados inválidos fornecidos."));
    }

    @Test
    void addChavePIXInternalErrorTest() throws Exception {
        ChavePIX testEntity = new ChavePIX();

        when(service.addChavePIX(any(ChavePIX.class))).thenThrow(new Exception("Erro interno do servidor."));

        mockMvc.perform(post("/api/pix/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testEntity)))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Erro interno do servidor."));
    }

    @Test
    void getChavePIXByContaTest() throws Exception {
        ChavePIX testEntity = new ChavePIX();

        when(service.getChavePIXByConta(1L)).thenReturn(listTransformChavePIXToDto(testEntity));

        mockMvc.perform(get("/api/pix/conta=1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(testEntity)));
    }

    @Test
    void getChavePIXByContaNotFoundTest() throws Exception {
        when(service.getChavePIXByConta(1L)).thenThrow(new Exception("Chave PIX não encontrada."));

        mockMvc.perform(get("/api/pix/conta=1"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Chave PIX não encontrada."));
    }

    @Test
    void getChavePIXByContaInternalErrorTest() throws Exception {
        when(service.getChavePIXByConta(1L)).thenThrow(new Exception("Erro interno do servidor."));

        mockMvc.perform(get("/api/pix/conta=1"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Erro interno do servidor."));
    }

    @Test
    void getChavePIXByClienteTest() throws Exception {
        ChavePIX testEntity = new ChavePIX();

        when(service.getChavePIXByCliente(1L)).thenReturn(listTransformChavePIXToDto(testEntity));

        mockMvc.perform(get("/api/pix/cliente=1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(testEntity)));
    }

    @Test
    void getChavePIXByClienteNotFoundTest() throws Exception {
        when(service.getChavePIXByCliente(1L)).thenThrow(new Exception("Chave PIX não encontrada."));

        mockMvc.perform(get("/api/pix/cliente=1"))
                .andExpect(status().isNotFound())
                .andExpect(content().string("Chave PIX não encontrada."));
    }

    @Test
    void getChavePIXByClienteInternalErrorTest() throws Exception {
        when(service.getChavePIXByCliente(1L)).thenThrow(new Exception("Erro interno do servidor."));

        mockMvc.perform(get("/api/pix/cliente=1"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Erro interno do servidor."));
    }

    @Test
    void deleteChavePIXTest() throws Exception {
        String errorMessage = "Chave PIX não encontrada!";

        doThrow(new Exception(errorMessage)).when(service).deleteChavePIX(1L);

        mockMvc.perform(delete("/api/pix/1"))
                .andExpect(status().isNotFound())
                .andExpect(content().string(errorMessage));
    }
}
