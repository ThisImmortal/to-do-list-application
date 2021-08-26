package com.spring.security.demo.app.repository;

import com.spring.security.demo.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);

    @Modifying
    @Query("update User u set u.active=1 where u.email=:email and u.myHash=:hashcode")
    @Transactional
    void activateAccount(@Param("email") String email, @Param("hashcode") String hashcode);
}
