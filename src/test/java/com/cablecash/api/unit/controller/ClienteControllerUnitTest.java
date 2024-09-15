package com.cablecash.api.unit.controller;

import static com.cablecash.api.config.MockDataConfig.transformClienteToDto;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.cablecash.api.exception.ClienteException;
import com.cablecash.api.model.entity._public.Cliente;
import com.cablecash.api.repository._public.ClienteRepository;
import com.cablecash.api.service._public.ClienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ClienteControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ClienteService service;

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        repository.deleteAll();
    }

    @Test
    void addClienteTest() throws Exception {
        Cliente testEntity = new Cliente();

        when(service.addCliente(any(Cliente.class))).thenReturn(transformClienteToDto(testEntity));

        mockMvc.perform(post("/api/cliente/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testEntity)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(transformClienteToDto(testEntity))));
    }

    @Test
    void addClienteExceptionTest() throws Exception {
        Cliente testEntity = new Cliente();
        String errorMessage = "Erro ao adicionar cliente";

        when(service.addCliente(any(Cliente.class))).thenThrow(new ClienteException(errorMessage));

        mockMvc.perform(post("/api/cliente/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testEntity)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void getClienteByIdTest() throws Exception {
        Cliente testEntity = new Cliente();

        when(service.getClienteById(1L)).thenReturn(transformClienteToDto(testEntity));

        mockMvc.perform(get("/api/cliente/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(transformClienteToDto(testEntity))));
    }

    @Test
    void getClienteByIdExceptionTest() throws Exception {
        String errorMessage = "Cliente não encontrado";

        when(service.getClienteById(1L)).thenThrow(new ClienteException(errorMessage));

        mockMvc.perform(get("/api/cliente/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    void updateClienteTest() throws Exception {
        Cliente testEntity = new Cliente();

        when(service.updateCliente(1L, testEntity)).thenReturn(transformClienteToDto(testEntity));

        mockMvc.perform(patch("/api/cliente/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testEntity)))
                .andExpect(status().isAccepted());
    }

    @Test
    void deleteClienteTest() throws Exception {
        Cliente testEntity = new Cliente();

        doNothing().when(service).deleteCliente(transformClienteToDto(testEntity).getId());

        mockMvc.perform(delete("/api/cliente/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteClienteExceptionTest() throws Exception {
        String errorMessage = "Erro ao deletar cliente";

        doThrow(new ClienteException(errorMessage)).when(service).deleteCliente(1L);

        mockMvc.perform(delete("/api/cliente/1"))
                .andExpect(status().isBadRequest());
    }
}
