package com.spring.security.demo.app.service;

import com.spring.security.demo.app.model.PasswordResetToken;
import com.spring.security.demo.app.model.User;

public interface ForgotPasswordService {

    public String validatePasswordResetToken(String token);

    public boolean isTokenFound(PasswordResetToken passToken);

    public boolean isTokenExpired(PasswordResetToken passToken);


}
