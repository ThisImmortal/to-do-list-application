package com.spring.security.demo.app.model.validation;

import org.hibernate.annotations.Type;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordsValueMatchValidator.class)
@Documented
public @interface PasswordsValueMatch {

    String message() default "Passwords don't match";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
