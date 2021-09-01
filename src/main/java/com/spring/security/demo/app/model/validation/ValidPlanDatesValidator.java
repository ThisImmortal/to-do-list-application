package com.spring.security.demo.app.model.validation;

import com.spring.security.demo.app.model.PlanToDo;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class ValidPlanDatesValidator implements ConstraintValidator<ValidPlanDates, Object> {

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {

        PlanToDo planToDo = (PlanToDo) value;

        return planToDo.getBeginDate().before(planToDo.getEndDate());
    }
}
