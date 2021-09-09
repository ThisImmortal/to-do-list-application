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
    @Query(value = "SELECT * FROM user u where u.email=:email AND u.active='1'", nativeQuery = true)
    User findByEmail(@Param("email") String email);

    @Modifying
    @Query("update User u set u.active=1 where u.email=:email and u.myHash=:hashcode")
    @Transactional
    void activateAccount(@Param("email") String email, @Param("hashcode") String hashcode);

    @Query(value = "SELECT * from user u join password_reset_token p on (u.id=p.user_id) where p.token=:token", nativeQuery = true)
    public User getUserByToken(@Param("token") String token);
}
