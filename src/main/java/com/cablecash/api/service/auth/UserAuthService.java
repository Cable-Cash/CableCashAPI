package com.cablecash.api.service.auth;

import com.cablecash.api.model.dto.auth.UserDTO;
import com.cablecash.api.model.entity.auth.User;
import com.cablecash.api.repository.auth.UserAuthRepository;
import org.springframework.stereotype.Service;

import java.util.stream.Stream;

@Service
public class UserAuthService {

    private final UserAuthRepository repository;

    public UserAuthService(UserAuthRepository repository) {
        this.repository = repository;
    }

    public User addUser(User user) {
        return repository.save(user);
    }

//    public Stream<UserDTO> getUser(Long id) {
//        return repository.findAll().stream().map(UserDTO::new);
//    }

    public User updateUser(Long id, User user) {
        return repository.save(user);
    }

    public void deleteUser(Long id) {
        repository.deleteById(id);
    }

}
