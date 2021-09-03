package com.spring.security.demo.app.model.validation;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;
import java.util.Date;


@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidPlanDatesValidator.class)
@Documented
public @interface ValidPlanDates {

    String message() default "Begin date should be after end date!";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String first();

    String second();


    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List{
        ValidPlanDates[] value();
    }
}
