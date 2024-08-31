//package com.cablecash.api.controller;
//
//import com.cablecash.api.model.dto._public.CartaoDTO;
//import com.cablecash.api.service._public.CartaoService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.stream.Stream;
//
//@RestController
//@RequestMapping(value = "/cartao", produces = "application/json")
//public class CartaoController {
//
//    @Autowired
//    CartaoService service;
//
//    @GetMapping("/get")
//    public Stream<CartaoDTO> findAll() {
//        return service.findAll();
//    }
//}
