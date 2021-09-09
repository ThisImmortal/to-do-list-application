package com.spring.security.demo.app.web.dto;

import com.spring.security.demo.app.model.validation.PasswordsValueMatch;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@PasswordsValueMatch(first = "password", second = "confirmPassword", message = "The password fields must match")

public class PasswordDto {

    @Size(min = 8, max = 25, message = "Password must be min 8 max 25 symbols")
    @NotEmpty(message = "Password can not be empty")
    private String password;

    private String token;

    private String confirmPassword;

    public PasswordDto(){

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
