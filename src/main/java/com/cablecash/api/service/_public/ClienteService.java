package com.cablecash.api.service._public;

import com.cablecash.api.exception.ClienteException;
import com.cablecash.api.model.dto._public.ClienteDTO;
import com.cablecash.api.model.entity._public.Cliente;
import com.cablecash.api.repository._public.ClienteRepository;
import com.cablecash.api.service.validator.ClienteValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import java.util.stream.Stream;

@Service
public class ClienteService {

    @Autowired
    ClienteValidator validator;

    @Autowired
    ClienteRepository repository;

    public ClienteDTO addCliente(Cliente entity) {
        try {
            BindingResult result = new BeanPropertyBindingResult(entity, "cliente");
            validator.validate(entity, result);
            return new ClienteDTO(repository.save(entity));
        } catch (Exception ex) {
            throw new ClienteException("Erro ao adicionar cliente: " + ex.getCause());
        }
    }

    public ClienteDTO getClienteById(Long id) {
        return repository.findById(id)
                .map(ClienteDTO::new)
                .orElseThrow(() -> new ClienteException("Erro ao encontrar cliente. ID: " + id + " não encontrado!"));
    }

    public ClienteDTO updateCliente(Long id, Cliente entity) {
        Cliente patchEntity = repository.findById(id).orElseThrow(
                () -> new ClienteException("Erro ao encontrar cliente. ID: " + id + " não encontrado!")
        );
        try {
            BindingResult result = new BeanPropertyBindingResult(entity, "cliente");
            validator.validate(entity, result);
            return new ClienteDTO(repository.save(validator.updateValivator(entity, patchEntity)));
        } catch (Exception ex) {
            throw new ClienteException("Erro ao atualizar cliente: " + ex.getCause());
        }
    }

    public void deleteCliente(Long id) {
        Cliente entity = repository.findById(id).orElseThrow(
                        () -> new ClienteException("Erro ao encontrar cliente. ID: " + id + " não encontrado!")
                );
        try {
            repository.delete(entity);
        } catch (Exception ex) {
            throw new ClienteException("Erro ao excluir cliente: " + ex.getCause());
        }
    }
}
