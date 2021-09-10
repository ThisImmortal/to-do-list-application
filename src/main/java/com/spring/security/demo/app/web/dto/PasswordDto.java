package com.spring.security.demo.app.web.dto;

import com.spring.security.demo.app.model.validation.PasswordsValueMatch;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@PasswordsValueMatch(first = "password", second = "confirmPassword", message = "The password fields must match")

public class PasswordDto {

    @NotBlank(message = "Password can not be empty")
    @Size(min = 8, max = 25, message = "Password must be min 8 max 25 symbols")
    @Pattern(message = "Password must contain at least one lower case letter", regexp = ".*[a-z].*")
    @Pattern(message = "Password must contain at least one upper case letter", regexp = ".*[A-Z].*")
    @Pattern(message = "Password must contain at least one digit", regexp = ".*\\d+.*")
    @Pattern(message = "Password must contain at least one symbol", regexp = ".*[@#$%^&+=].*")
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
