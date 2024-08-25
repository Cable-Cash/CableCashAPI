package com.cablecash.api.service._public;

import com.cablecash.api.exception.cliente.ClienteException;
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
            if (result.hasErrors()) {
                Stream.of(result.getAllErrors()).forEach(error -> {
                    throw new ClienteException("Erro de validação!");
                });
            }
            Cliente newEntity = repository.save(entity);
            return new ClienteDTO(newEntity);
        } catch (Exception ex) {
            throw new ClienteException("Erro ao adicionar cliente!");
        }
    }

    public ClienteDTO getClienteById(Long id) {
        try {
            Cliente entity = repository.findById(id).orElse(null);
            assert entity != null;
            return new ClienteDTO(entity);
        } catch (Exception ex) {
            throw new ClienteException("Cliente não encontrado!");
        }
    }

    public ClienteDTO updateCliente(Long id, Cliente entity) {
        try {
            Cliente patchEntity = repository.findById(id).orElseThrow(
                            () -> new ClienteException("Cliente não encontrado!")
                    );
            if (entity != null) {
                if (entity.getNome() != null) {
                    patchEntity.setNome(entity.getNome());
                }
                if (entity.getSobrenome() != null) {
                    patchEntity.setSobrenome(entity.getSobrenome());
                }
                if (entity.getDataNascimento() != null) {
                    patchEntity.setDataNascimento(entity.getDataNascimento());
                }
                if (entity.getCpf() != null) {
                    patchEntity.setCpf(entity.getCpf());
                }
                if (entity.getEmail() != null) {
                    patchEntity.setEmail(entity.getEmail());
                }
                if (entity.getEndereco() != null) {
                    patchEntity.setEndereco(entity.getEndereco());
                }
                patchEntity.setTelefone(entity.getTelefone());
                patchEntity.setRendaMensal(entity.getRendaMensal());
            }
            Cliente updatedEntity = repository.save(patchEntity);
            return new ClienteDTO(updatedEntity);
        } catch (Exception ex) {
            throw new ClienteException("Erro ao atualizar cliente!");
        }
    }

    public void deleteCliente(Long id) {
        Cliente entity = repository.findById(id).orElseThrow(
                        () -> new ClienteException("Cliente não encontrado!")
                );
        try {
            repository.delete(entity);
        } catch (Exception ex) {
            throw new ClienteException("Erro ao excluir cliente!");
        }
    }
}
