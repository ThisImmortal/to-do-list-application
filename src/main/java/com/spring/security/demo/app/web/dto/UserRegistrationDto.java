package com.spring.security.demo.app.web.dto;

import com.spring.security.demo.app.model.validation.PasswordsValueMatch;
import com.spring.security.demo.app.model.validation.ValidEmailSyntax;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@PasswordsValueMatch(first = "password", second = "passwordMatching", message = "The password fields must match")

public class UserRegistrationDto {

    @NotEmpty(message = "First name can not be empty")
    private String firstName;
    private String lastName;

    @ValidEmailSyntax
    private String email;


    @NotBlank(message = "Password can not be empty")
    @Size(min = 8, max = 25, message = "Password must be min 8 max 25 symbols")
    @Pattern(message = "Password must contain at least one lower case letter", regexp = ".*[a-z].*")
    @Pattern(message = "Password must contain at least one upper case letter", regexp = ".*[A-Z].*")
    @Pattern(message = "Password must contain at least one digit", regexp = ".*\\d+.*")
    @Pattern(message = "Password must contain at least one symbol", regexp = ".*[@#$%^&+=].*")
    private String password;
//    @Pattern(message = "Password must contain at least: one digit, one lower case and one upper case letter, one symbol and no whitespace",
//            regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$)$")


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
