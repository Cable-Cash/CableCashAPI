package com.cablecash.api.unit.controller;

import static com.cablecash.api.config.MockDataConfig.transformEntityToDto;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.cablecash.api.exception.cliente.ClienteException;
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

        when(service.addCliente(any(Cliente.class))).thenReturn(transformEntityToDto(testEntity));

        mockMvc.perform(post("/api/cliente/new")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(testEntity)))
                .andExpect(status().isCreated())
                .andExpect(content().json(objectMapper.writeValueAsString(transformEntityToDto(testEntity))));
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

        when(service.getClienteById(1L)).thenReturn(transformEntityToDto(testEntity));

        mockMvc.perform(get("/api/cliente/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("Nome"))
                .andExpect(jsonPath("$.sobrenome").value("Sobrenome"))
                .andExpect(jsonPath("$.cpf").value("123.456.789-01"))
                .andExpect(jsonPath("$.email").value("teste@email.com"))
                .andExpect(jsonPath("$.telefone").value("+55 (19) 12345-6789"))
                .andExpect(jsonPath("$.endereco").value("Rua teste, 123"))
                .andExpect(jsonPath("$.rendaMensal").value(1000));
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

        when(service.updateCliente(1L, testEntity)).thenReturn(transformEntityToDto(testEntity));

        mockMvc.perform(patch("/api/cliente/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(testEntity)))
                .andExpect(status().isAccepted());
    }

    @Test
    void deleteClienteTest() throws Exception {
        Cliente testEntity = new Cliente();

        doNothing().when(service).deleteCliente(transformEntityToDto(testEntity).getId());

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
