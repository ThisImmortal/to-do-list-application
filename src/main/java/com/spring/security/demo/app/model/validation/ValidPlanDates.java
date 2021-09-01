package com.spring.security.demo.app.model.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ValidPlanDatesValidator.class)
@Documented
public @interface ValidPlanDates {

    String message() default "Begin date should be after end date!";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
