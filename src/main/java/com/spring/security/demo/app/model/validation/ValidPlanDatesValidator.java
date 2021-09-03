package com.spring.security.demo.app.model.validation;

import com.spring.security.demo.app.model.PlanToDo;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.text.SimpleDateFormat;
import java.util.Date;


public class ValidPlanDatesValidator implements ConstraintValidator<ValidPlanDates, PlanToDo> {

    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(final ValidPlanDates constraintAnnotation) {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(final PlanToDo value, final ConstraintValidatorContext context) {

        boolean valid = true;

        try {
            final Date firstObj = new SimpleDateFormat("yyyy-MM-dd").parse(BeanUtils.getProperty(value, firstFieldName));
            final Date secondObj = new SimpleDateFormat("yyyy-MM-dd").parse(BeanUtils.getProperty(value, secondFieldName));

            System.out.println(firstObj+"My date");


            valid = firstObj.before(secondObj);
        }
        catch (Exception e){
            System.out.println(e.toString());
        }

        if(!valid){
            context.buildConstraintViolationWithTemplate(message).addPropertyNode(firstFieldName).
                    addConstraintViolation().disableDefaultConstraintViolation();
        }

        return valid;

//        PlanToDo planToDo = (PlanToDo) value;
//
//        return planToDo.getBeginDate().before(planToDo.getEndDate());
    }
}
