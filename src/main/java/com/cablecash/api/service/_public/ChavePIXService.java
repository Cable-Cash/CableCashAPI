//package com.cablecash.api.service._public;
//
//import com.cablecash.api.model.dto._public.ChavePIXDTO;
//import com.cablecash.api.model.entity._public.ChavePIX;
//import com.cablecash.api.repository._public.ChavePIXRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.stream.Stream;
//
//@Service
//public class ChavePIXService {
//
//    @Autowired
//    ChavePIXRepository repository;
//
//    public Stream<ChavePIXDTO> getChavePIXs() {
//        return repository.findAll().stream().map(ChavePIXDTO::new);
//    }
//}
