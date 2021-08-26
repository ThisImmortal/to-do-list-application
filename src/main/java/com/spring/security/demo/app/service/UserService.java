package com.spring.security.demo.app.service;

import com.spring.security.demo.app.model.User;
import com.spring.security.demo.app.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User getUserByEmail(String email);
    User save(UserRegistrationDto userRegistrationDto, String hashcode);
    void activateAccount(String email, String hashcode);
}
