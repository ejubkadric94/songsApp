package com.authorization.authorization.repositories;

import com.authorization.authorization.models.BearerToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BearerTokenRepository extends JpaRepository<BearerToken, Long> {
    public BearerToken findByToken(String token);
}
