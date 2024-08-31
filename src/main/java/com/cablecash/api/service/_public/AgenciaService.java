//package com.cablecash.api.service._public;
//
//import com.cablecash.api.model.dto._public.AgenciaDTO;
//import com.cablecash.api.repository._public.AgenciaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.stream.Stream;
//
//@Service
//public class AgenciaService {
//
//    @Autowired
//    AgenciaRepository repository;
//
//    public Stream<AgenciaDTO> getAgencias() {
//        return repository.findAll().stream().map(AgenciaDTO::new);
//    }
//}
