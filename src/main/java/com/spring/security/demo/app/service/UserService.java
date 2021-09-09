package com.spring.security.demo.app.service;

import com.spring.security.demo.app.model.User;
import com.spring.security.demo.app.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Date;

public interface UserService extends UserDetailsService {

    User getUserByEmail(String email);
    User save(UserRegistrationDto userRegistrationDto, String hashcode);
    void activateAccount(String email, String hashcode);
    public void createPasswordResetTokenForUser(User user, String token, Date currentDate);
    public User getUserByToken(String token);
    public void changeUserPassword(User user, String newPassword);
}
