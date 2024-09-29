package com.cablecash.api.unit.service;

import com.cablecash.api.model.dto.PagamentoDTO;
import com.cablecash.api.model.entity.Pagamento;
import com.cablecash.api.repository.PagamentoRepository;
import com.cablecash.api.service.PagamentoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class PagamentoServiceUnitTest {

    @InjectMocks
    PagamentoService service;

    @Mock
    PagamentoRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addPagamentoTest() {
        Pagamento testEntity = new Pagamento();

        when(repository.save(testEntity)).thenReturn(testEntity);

        PagamentoDTO dto = service.addPagamento(testEntity);

        assertNotNull(dto);

        verify(repository).save(testEntity);
    }

    @Test
    void getPagamentosByContaTest() {
        Pagamento testEntity = new Pagamento();

        when(repository.findByContaId(1L)).thenReturn(java.util.List.of(testEntity));

        assertNotNull(service.getPagamentosByConta(1L));
    }

    @Test
    void getPagamentosByCartaoTest() {
        Pagamento testEntity = new Pagamento();

        when(repository.findByCartaoId(1L)).thenReturn(java.util.List.of(testEntity));

        assertNotNull(service.getPagamentosByCartao(1L));
    }
}
