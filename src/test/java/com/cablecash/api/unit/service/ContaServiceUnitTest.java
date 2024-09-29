package com.cablecash.api.unit.service;

import com.cablecash.api.exception.ContaException;
import com.cablecash.api.model.dto.ContaDTO;
import com.cablecash.api.model.entity.Conta;
import com.cablecash.api.repository.ContaRepository;
import com.cablecash.api.service.ContaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ContaServiceUnitTest {

    @InjectMocks
    ContaService service;

    @Mock
    ContaRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addContaTest() {
        Conta testEntity = new Conta();

        when(repository.save(testEntity)).thenReturn(testEntity);

        ContaDTO dto = service.addConta(testEntity);

        assertNotNull(dto);

        verify(repository).save(testEntity);
    }

    @Test
    public void getContaByIdTest() {
        Conta testEntity = new Conta();

        when(repository.findById(1L)).thenReturn(java.util.Optional.of(testEntity));

        ContaDTO dto = service.getContaById(1L);

        assertNotNull(dto);

        verify(repository).findById(1L);
    }

    @Test
    public void getContaByClienteTest() {
        Conta testEntity = new Conta();

        when(repository.findByClienteId(1L)).thenReturn(java.util.List.of(testEntity));

        service.getContaByCliente(1L);

        verify(repository).findByClienteId(1L);
    }

    @Test
    public void deleteContaTest() {
        Conta testEntity = new Conta();

        when(repository.findById(1L)).thenReturn(java.util.Optional.of(testEntity));

        service.deleteConta(1L);

        verify(repository).delete(testEntity);
    }

    @Test
    public void deleteContaExceptionTest() {
        Conta testEntity = new Conta();

        when(repository.findById(1L)).thenReturn(java.util.Optional.of(testEntity));

        ContaException exception = assertThrows(ContaException.class, () -> {
            service.deleteConta(1L);
        });

        assertEquals("Conta não encontrada!", exception.getMessage());
    }
}
