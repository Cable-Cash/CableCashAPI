package com.cablecash.api.unit.service;

import com.cablecash.api.exception.ClienteException;
import com.cablecash.api.model.dto._public.ClienteDTO;
import com.cablecash.api.model.entity._public.Cliente;
import com.cablecash.api.repository._public.ClienteRepository;
import com.cablecash.api.service._public.ClienteService;
import com.cablecash.api.service.validator.ClienteValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import java.math.BigDecimal;

import static com.cablecash.api.config.MockDataConfig.mockClienteUpdatedValues;
import static com.cablecash.api.config.MockDataConfig.mockClienteValues;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ClienteServiceUnitTest {

    @Mock
    private ClienteRepository repository;

    @Mock
    private ClienteValidator validator;

    @InjectMocks
    private ClienteService service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void addClienteTest() {
        Cliente testEntity = new Cliente();

        BindingResult result = new BeanPropertyBindingResult(mockClienteValues(testEntity), "cliente");

        doNothing().when(validator).validate(mockClienteValues(testEntity), result);
        when(repository.save(mockClienteValues(testEntity))).thenReturn(mockClienteValues(testEntity));

        ClienteDTO dto = service.addCliente(mockClienteValues(testEntity));

        assertNotNull(dto);
        assertEquals("Nome", dto.getNome());
        verify(validator, times(1)).validate(mockClienteValues(testEntity), result);
        verify(repository, times(1)).save(mockClienteValues(testEntity));
    }

    @Test
    public void addClienteExceptionTest() {
        Cliente testEntity = new Cliente();
        String errorMessage = "Erro ao adicionar cliente!";

        BindingResult result = new BeanPropertyBindingResult(mockClienteValues(testEntity), "cliente");

        doNothing().when(validator).validate(mockClienteValues(testEntity), result);
        when(repository.save(mockClienteValues(testEntity))).thenThrow(new ClienteException(errorMessage));

        ClienteException exception = assertThrows(ClienteException.class, () -> {
            service.addCliente(mockClienteValues(testEntity));
        });

        assertEquals(errorMessage, exception.getMessage());
        verify(validator, times(1)).validate(mockClienteValues(testEntity), result);
        verify(repository, times(1)).save(mockClienteValues(testEntity));
    }

    @Test
    public void getClienteByIdTest() {
        Cliente testEntity = new Cliente();

        when(repository.findById(mockClienteValues(testEntity).getId())).thenReturn(java.util.Optional.of(mockClienteValues(testEntity)));

        ClienteDTO dto = service.getClienteById(mockClienteValues(testEntity).getId());

        assertNotNull(dto);
        assertEquals("Nome", dto.getNome());
        assertEquals("Sobrenome", dto.getSobrenome());
        assertEquals("12345678901", dto.getCpf());
        assertEquals("teste@email.com", dto.getEmail());
        assertEquals("5519123456789", dto.getTelefone());
        assertEquals(BigDecimal.valueOf(1000), dto.getRendaMensal());

        verify(repository, times(1)).findById(mockClienteValues(testEntity).getId());
    }

    @Test
    public void getClienteByIdExceptionTest() {
        Cliente testEntity = new Cliente();
        String errorMessage = "Cliente não encontrado!";

        when(repository.findById(mockClienteValues(testEntity).getId())).thenReturn(java.util.Optional.empty());

        ClienteException exception = assertThrows(ClienteException.class, () -> {
            service.getClienteById(mockClienteValues(testEntity).getId());
        });

        assertEquals(errorMessage, exception.getMessage());
        verify(repository, times(1)).findById(mockClienteValues(testEntity).getId());
    }

    @Test
    public void updateClienteTest() {
        Cliente testEntity = mockClienteValues(new Cliente());
        Cliente updatedEntity = mockClienteUpdatedValues(testEntity);

        BindingResult result = new BeanPropertyBindingResult(updatedEntity, "cliente");

        doNothing().when(validator).validate(updatedEntity, result);
        when(repository.findById(testEntity.getId())).thenReturn(java.util.Optional.of(testEntity));
        when(validator.updateValivator(updatedEntity, testEntity)).thenReturn(updatedEntity);
        when(repository.save(updatedEntity)).thenReturn(updatedEntity);

        ClienteDTO dto = service.updateCliente(testEntity.getId(), updatedEntity);

        assertNotNull(dto);
        assertEquals("Nome atualizado", dto.getNome());
        assertEquals("Sobrenome atualizado", dto.getSobrenome());
        assertEquals("60345274902", dto.getCpf());
        assertEquals("testeatualizado@email.com", dto.getEmail());
        assertEquals("5519312645978", dto.getTelefone());
        assertEquals(BigDecimal.valueOf(2000), dto.getRendaMensal());

        verify(repository, times(1)).findById(testEntity.getId());
        verify(validator, times(1)).updateValivator(testEntity, updatedEntity);
        verify(repository, times(1)).save(updatedEntity);
    }

    @Test
    public void updateClienteExceptionTest() {
        Cliente testEntity = mockClienteValues(new Cliente());
        Cliente updatedEntity = mockClienteUpdatedValues(testEntity);
        String errorMessage = "Erro ao atualizar cliente!";

        when(repository.findById(testEntity.getId())).thenReturn(java.util.Optional.of(testEntity));
        when(validator.updateValivator(testEntity, updatedEntity)).thenReturn(updatedEntity);
        when(repository.save(updatedEntity)).thenThrow(new ClienteException(errorMessage));

        ClienteException exception = assertThrows(ClienteException.class, () -> {
            service.updateCliente(testEntity.getId(), updatedEntity);
        });

        assertEquals(errorMessage, exception.getMessage());
        verify(repository, times(1)).findById(testEntity.getId());
        verify(validator, times(1)).updateValivator(updatedEntity, testEntity);
        verify(repository, times(1)).save(updatedEntity);
    }

    @Test
    public void updateClienteNotFoundExceptionTest() {
        Cliente testEntity = new Cliente();
        String errorMessage = "Cliente não encontrado!";

        when(repository.findById(testEntity.getId())).thenReturn(java.util.Optional.empty());

        ClienteException exception = assertThrows(ClienteException.class, () -> {
            service.updateCliente(testEntity.getId(), testEntity);
        });

        assertEquals(errorMessage, exception.getMessage());
        verify(repository, times(1)).findById(testEntity.getId());
    }

    @Test
    public void deleteClienteTest() {
        Cliente testEntity = new Cliente();
        mockClienteValues(testEntity);

        when(repository.findById(testEntity.getId())).thenReturn(java.util.Optional.of(testEntity));
        doNothing().when(repository).delete(testEntity);

        service.deleteCliente(testEntity.getId());

        verify(repository, times(1)).findById(testEntity.getId());
        verify(repository, times(1)).delete(testEntity);
    }

    @Test
    public void deleteClienteNotFoundExceptionTest() {
        Cliente testEntity = new Cliente();
        String errorMessage = "Cliente não encontrado!";

        when(repository.findById(testEntity.getId())).thenReturn(java.util.Optional.empty());

        ClienteException exception = assertThrows(ClienteException.class, () -> {
            service.deleteCliente(testEntity.getId());
        });

        assertEquals(errorMessage, exception.getMessage());
        verify(repository, times(1)).findById(testEntity.getId());
    }

    @Test
    public void deleteClienteExceptionTest() {
        Cliente testEntity = new Cliente();
        mockClienteValues(testEntity);
        String errorMessage = "Erro ao excluir cliente!";

        when(repository.findById(testEntity.getId())).thenReturn(java.util.Optional.of(testEntity));
        doThrow(new ClienteException(errorMessage)).when(repository).delete(testEntity);

        ClienteException exception = assertThrows(ClienteException.class, () -> {
            service.deleteCliente(testEntity.getId());
        });

        assertEquals(errorMessage, exception.getMessage());
        verify(repository, times(1)).findById(testEntity.getId());
        verify(repository, times(1)).delete(testEntity);
    }
}
