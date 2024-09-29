package com.cablecash.api.unit.service;

import com.cablecash.api.model.dto.EmprestimoDTO;
import com.cablecash.api.model.entity.Emprestimo;
import com.cablecash.api.repository.EmprestimoRepository;
import com.cablecash.api.service.EmprestimoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EmprestimoServiceUnitTest {

    @InjectMocks
    EmprestimoService service;

    @Mock
    EmprestimoRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addEmprestimoTest() {
        Emprestimo testEntity = new Emprestimo();

        when(repository.save(testEntity)).thenReturn(testEntity);

        EmprestimoDTO dto = service.addEmprestimo(testEntity);

        assertNotNull(dto);

        verify(repository).save(testEntity);
    }

    @Test
    void getEmprestimoByIdTest() {
        Emprestimo testEntity = new Emprestimo();

        when(repository.findById(1L)).thenReturn(java.util.Optional.of(testEntity));

        EmprestimoDTO dto = service.getEmprestimoById(1L);

        assertNotNull(dto);
    }

    @Test
    void getEmprestimoByClienteTest() {
        Emprestimo testEntity = new Emprestimo();

        when(repository.findByClienteId(1L)).thenReturn(java.util.List.of(testEntity));

        service.getEmprestimoByCliente(1L);

        verify(repository).findByClienteId(1L);
    }

    @Test
    void deleteEmprestimoTest() {
        Emprestimo testEntity = new Emprestimo();

        when(repository.findById(1L)).thenReturn(java.util.Optional.of(testEntity));

        service.deleteEmprestimo(1L);

        verify(repository).delete(testEntity);
    }

}
