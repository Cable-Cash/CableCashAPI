package com.cablecash.api.unit.controller;

import com.cablecash.api.exception.EmprestimoException;
import com.cablecash.api.model.entity.Emprestimo;
import com.cablecash.api.repository.EmprestimoRepository;
import com.cablecash.api.service.EmprestimoService;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EmprestimoControllerUnitTest {

    @Autowired
    EmprestimoRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @MockBean
    EmprestimoService service;

    @BeforeEach
    void setUp() {
        repository.deleteAll();
    }

    @Test
    void addEmprestimoTest() throws Exception {
        mockMvc.perform(post("/api/emprestimo/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new Emprestimo())))
                .andExpect(status().isCreated());
    }

    @Test
    void getEmprestimoByIdTest() throws Exception {
        mockMvc.perform(get("/api/emprestimo/1"))
                .andExpect(status().isOk());
    }

    @Test
    void getEmprestimoByIdNotFoundTest() throws Exception {
        mockMvc.perform(get("/api/emprestimo/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getEmprestimoByIdBadRequestTest() throws Exception {
        mockMvc.perform(get("/api/emprestimo/abc"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getEmprestimoByIdInternalServerErrorTest() throws Exception {
        mockMvc.perform(get("/api/emprestimo/0"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void addEmprestimoExceptionTest() throws Exception {
        Emprestimo testEntity = new Emprestimo();
        String errorMessage = "Erro ao adicionar empréstimo";

        when(service.addEmprestimo(any(Emprestimo.class))).thenThrow(new EmprestimoException(errorMessage));

        mockMvc.perform(post("/api/emprestimo/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testEntity)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getEmprestimoByIdExceptionTest() throws Exception {
        String errorMessage = "Empréstimo não encontrado";

        when(service.getEmprestimoById(1L)).thenThrow(new EmprestimoException(errorMessage));

        mockMvc.perform(get("/api/emprestimo/1"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getEmprestimoByClienteTest() throws Exception {
        mockMvc.perform(get("/api/emprestimo/cliente=1"))
                .andExpect(status().isOk());
    }

    @Test
    void getEmprestimoByClienteNotFoundTest() throws Exception {
        mockMvc.perform(get("/api/emprestimo/cliente=1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void getEmprestimoByClienteBadRequestTest() throws Exception {
        mockMvc.perform(get("/api/emprestimo/cliente=abc"))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getEmprestimoByClienteInternalServerErrorTest() throws Exception {
        mockMvc.perform(get("/api/emprestimo/cliente=0"))
                .andExpect(status().isInternalServerError());
    }

    @Test
    void deleteEmprestimoTest() throws Exception {
        mockMvc.perform(delete("/api/emprestimo/1"))
                .andExpect(status().isAccepted());
    }

    @Test
    void deleteEmprestimoNotFoundTest() throws Exception {
        mockMvc.perform(delete("/api/emprestimo/1"))
                .andExpect(status().isNotFound());
    }
}
