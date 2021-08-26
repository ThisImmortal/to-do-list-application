package com.spring.security.demo.app.model.validation;

import com.spring.security.demo.app.web.dto.UserRegistrationDto;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsValueMatchValidator implements ConstraintValidator<PasswordsValueMatch, Object> {


    @Override
    public void initialize(PasswordsValueMatch constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        UserRegistrationDto userRegistrationDto = (UserRegistrationDto) value;
        return userRegistrationDto.getPassword().equals(userRegistrationDto.getPasswordMatching());

    }
}
