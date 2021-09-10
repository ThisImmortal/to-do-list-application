package com.spring.security.demo.app.model.validation;

import org.apache.commons.beanutils.BeanUtils;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordsValueMatchValidator implements ConstraintValidator<PasswordsValueMatch, Object> {


    private String firstFieldName;
    private String secondFieldName;
    private String message;

    @Override
    public void initialize(final PasswordsValueMatch constraintAnnotation) {

        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
        message = constraintAnnotation.message();

    }

    @Override
    public boolean isValid(final Object value, final ConstraintValidatorContext context) {

        boolean valid = true;
        try {

            final Object firstObj = BeanUtils.getProperty(value, firstFieldName);
            final Object secondObj = BeanUtils.getProperty(value, secondFieldName);

            valid =  firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);


        }
        catch (final Exception e){
            System.out.println(e.toString());
        }

        if(!valid){

            context.buildConstraintViolationWithTemplate(message).addPropertyNode(secondFieldName).
                    addConstraintViolation().disableDefaultConstraintViolation();
        }
        return valid;

    }
}
