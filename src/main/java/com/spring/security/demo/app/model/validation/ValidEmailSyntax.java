package com.spring.security.demo.app.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;


@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidEmailSyntaxValidator.class)
@Documented
public @interface ValidEmailSyntax {

    String message() default "This is not valid email syntax";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
