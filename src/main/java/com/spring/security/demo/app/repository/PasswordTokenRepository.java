package com.spring.security.demo.app.repository;

import com.spring.security.demo.app.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    public PasswordResetToken findByToken(String token);
}
