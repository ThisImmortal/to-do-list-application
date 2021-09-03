package com.spring.security.demo.app.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordsValueMatchValidator.class)
@Documented
public @interface PasswordsValueMatch {

    String message() default "The passwords must match";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String first();

    String second();


    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List{
        PasswordsValueMatch[] value();
    }
}
