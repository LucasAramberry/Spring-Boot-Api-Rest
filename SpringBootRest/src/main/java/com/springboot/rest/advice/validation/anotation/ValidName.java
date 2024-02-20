package com.springboot.rest.advice.validation.anotation;

import com.springboot.rest.advice.validation.validator.NameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = NameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface ValidName {

    String message() default "{custom.validation.name}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
