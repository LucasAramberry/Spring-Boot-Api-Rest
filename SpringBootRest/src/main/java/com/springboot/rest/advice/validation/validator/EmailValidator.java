package com.springboot.rest.advice.validation.validator;

import com.springboot.rest.advice.validation.anotation.ValidEmail;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements ConstraintValidator<ValidEmail, String> {

    private static final String EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,}$";
    private static final Pattern PATTERN = Pattern.compile(EMAIL_PATTERN);

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        if (email == null || email.isBlank()) return false;
        return validateEmail(email);
    }

    private boolean validateEmail(final String email) {
        Matcher matcher = PATTERN.matcher(email);
        return matcher.matches();
    }
}
