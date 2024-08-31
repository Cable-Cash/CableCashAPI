//package com.cablecash.api.service._public;
//
//import com.cablecash.api.model.dto._public.EmprestimoDTO;
//import com.cablecash.api.repository._public.EmprestimoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.stream.Stream;
//
//@Service
//public class EmprestimoService {
//
//    @Autowired
//    EmprestimoRepository repository;
//
//    public Stream<EmprestimoDTO> getAllEmprestimos() {
//        return repository.findAll().stream().map(EmprestimoDTO::new);
//    }
//}
