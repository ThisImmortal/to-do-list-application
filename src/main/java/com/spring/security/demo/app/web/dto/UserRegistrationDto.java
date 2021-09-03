package com.spring.security.demo.app.web.dto;

import com.spring.security.demo.app.model.validation.PasswordsValueMatch;
import com.spring.security.demo.app.model.validation.ValidEmailSyntax;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@PasswordsValueMatch(first = "password", second = "passwordMatching", message = "The password fields must match")

public class UserRegistrationDto {

    @NotEmpty(message = "First name can not be empty")
    private String firstName;
    private String lastName;

    @ValidEmailSyntax
    private String email;


    @Size(min = 8, max = 25, message = "Password must be min 8 max 25 symbols")
    @NotEmpty(message = "Password can not be empty")
    private String password;

    private String passwordMatching;




    public UserRegistrationDto(){

    }

    public UserRegistrationDto(String firstName, String lastName, String email, String password, String passwordMatching) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.passwordMatching = passwordMatching;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordMatching() { return passwordMatching; }

    public void setPasswordMatching(String passwordMatching) { this.passwordMatching = passwordMatching; }


}
