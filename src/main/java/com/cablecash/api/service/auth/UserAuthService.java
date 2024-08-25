//package com.cablecash.api.service.auth;
//
//import com.cablecash.api.model.dto.auth.UserDTO;
//import com.cablecash.api.model.entity.auth.User;
//import com.cablecash.api.repository.auth.UserAuthRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.stream.Stream;
//
//@Service
//public class UserAuthService {
//
//    final
//    UserAuthRepository repository;
//
//    public UserAuthService(UserAuthRepository repository) {
//        this.repository = repository;
//    }
//
////    @Override
////    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
////        UserDTO user = repository.findByEmail(email)
////                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + email));
////
////        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getSenha(),
////                true, true, true, true,
////                List.of(new SimpleGrantedAuthority(user.getRole())));
////    }
//}
