package com.cablecash.api.unit.service;

import com.cablecash.api.model.dto.CartaoDTO;
import com.cablecash.api.model.entity.Cartao;
import com.cablecash.api.repository.CartaoRepository;
import com.cablecash.api.service.CartaoService;
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
public class CartaoServiceUnitTest {

    @InjectMocks
    CartaoService service;

    @Mock
    CartaoRepository repository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addCartaoTest() {
        Cartao testEntity = new Cartao();

        when(repository.save(testEntity)).thenReturn(testEntity);

        CartaoDTO dto = service.addCartao(testEntity);

        assertNotNull(dto);

        verify(repository).save(testEntity);
    }

    @Test
    void getCartaoByIdTest() {
        Cartao testEntity = new Cartao();

        when(repository.findById(1L)).thenReturn(java.util.Optional.of(testEntity));

        CartaoDTO dto = service.getCartaoById(1L);

        assertNotNull(dto);
    }

    @Test
    void getCartaoByClienteTest() {
        Cartao testEntity = new Cartao();

        when(repository.findByClienteId(1L)).thenReturn(java.util.List.of(testEntity));

        service.getCartaoByCliente(1L);

        verify(repository).findByClienteId(1L);
    }

    @Test
    void deleteCartaoTest() {
        Cartao testEntity = new Cartao();

        when(repository.findById(1L)).thenReturn(java.util.Optional.of(testEntity));

        service.deleteCartao(1L);

        verify(repository).delete(testEntity);
    }

}
