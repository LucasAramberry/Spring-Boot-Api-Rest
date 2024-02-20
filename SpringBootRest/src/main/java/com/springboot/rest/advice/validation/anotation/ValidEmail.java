package com.springboot.rest.advice.validation.anotation;

import com.springboot.rest.advice.validation.validator.EmailValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidEmail {

    String message() default "{custom.validation.email}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
