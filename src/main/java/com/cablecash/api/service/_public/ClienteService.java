package com.cablecash.api.service._public;

import com.cablecash.api.model.dto._public.ClienteDTO;
import com.cablecash.api.model.entity._public.Cliente;
import com.cablecash.api.repository._public.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public Cliente addCliente(Cliente cliente) {
        return repository.save(cliente);
    }

    public Cliente getCliente(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Stream<ClienteDTO> getClientes() {
        return repository.findAll().stream().map(ClienteDTO::new);
    }

    public Cliente updateCliente(Long id, Cliente cliente) {
        return repository.save(cliente);
    }

    public void deleteCliente(Long id) {
        repository.deleteById(id);
    }
}
