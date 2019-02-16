package com.authorization.authorization.repositories;

import com.authorization.authorization.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByEmailAndPassword(String email, String password);
    public Optional<User> findByBearerToken(String bearerToken);
}
