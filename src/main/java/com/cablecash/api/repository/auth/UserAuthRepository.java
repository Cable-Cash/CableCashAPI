package com.cablecash.api.repository.auth;

import com.cablecash.api.model.dto.auth.UserDTO;
import com.cablecash.api.model.entity.auth.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthRepository extends JpaRepository<User, Long> {
    Optional<UserDTO> findByEmail(String email);
}
