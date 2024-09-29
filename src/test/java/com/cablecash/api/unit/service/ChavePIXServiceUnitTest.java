package com.cablecash.api.unit.service;

import com.cablecash.api.model.dto.ChavePIXDTO;
import com.cablecash.api.model.entity.ChavePIX;
import com.cablecash.api.repository.ChavePIXRepository;
import com.cablecash.api.service.ChavePIXService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ChavePIXServiceUnitTest {

    @InjectMocks
    ChavePIXService service;

    @Mock
    ChavePIXRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addChavePIXTest() {
        ChavePIX testEntity = new ChavePIX();

        when(repository.save(testEntity)).thenReturn(testEntity);

        ChavePIXDTO dto = service.addChavePIX(testEntity);

        assertNotNull(dto);

        verify(repository).save(testEntity);
    }

    @Test
    public void getChavePIXByContaTest() {
        ChavePIX testEntity = new ChavePIX();

        when(repository.findByContaId(1L)).thenReturn(java.util.List.of(testEntity));

        List<ChavePIXDTO> dto = service.getChavePIXByConta(1L);

        assertNotNull(dto);

        verify(repository).findByContaId(1L);
    }

    @Test
    public void getChavePIXByClienteTest() {
        ChavePIX testEntity = new ChavePIX();

        when(repository.findByContaId(1L)).thenReturn(java.util.List.of(testEntity));

        List<ChavePIXDTO> dto = service.getChavePIXByCliente(1L);

        assertNotNull(dto);

        verify(repository).findByClienteId(1L);
    }

    @Test
    public void deleteChavePIXTest() {
        ChavePIX testEntity = new ChavePIX();

        when(repository.findById(1L)).thenReturn(java.util.Optional.of(testEntity));

        service.deleteChavePIX(1L);

        verify(repository).delete(testEntity);
    }
}
