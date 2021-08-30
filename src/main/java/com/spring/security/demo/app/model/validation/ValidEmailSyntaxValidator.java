package com.spring.security.demo.app.model.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidEmailSyntaxValidator implements ConstraintValidator<ValidEmailSyntax, String> {

    private Pattern pattern;
    private Matcher matcher;
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

//    @Override
//    public boolean isValid(Object value, ConstraintValidatorContext context) {
//
//        UserRegistrationDto userRegistrationDto = (UserRegistrationDto) value;
//        String email = userRegistrationDto.getEmail();
//
//         Pattern VALID_EMAIL_ADDRESS_REGEX =
//                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
//
//        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
//
//        return matcher.find();
//    }

    @Override
    public boolean isValid(final String email, final ConstraintValidatorContext context) {

        pattern = Pattern.compile(EMAIL_PATTERN);

        if(email == null) {

            return false;
        }

        matcher = pattern.matcher(email);

        return matcher.matches();
    }
}
