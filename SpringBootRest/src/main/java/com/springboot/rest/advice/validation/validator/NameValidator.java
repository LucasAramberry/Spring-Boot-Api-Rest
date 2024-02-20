package com.springboot.rest.advice.validation.validator;

import com.springboot.rest.advice.validation.anotation.ValidName;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<ValidName, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {

        if (value == null || value.isBlank() || value.length() < 3 || value.length() > 25) {
            return false;
        }

        return true;
    }

}
