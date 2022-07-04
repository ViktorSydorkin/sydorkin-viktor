package com.homework4.hw_4.controller.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

public class EmailCheck implements ConstraintValidator<EmailValidation, String> {
    @Override
    public void initialize(EmailValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        Pattern pattern = Pattern.compile("\\w{3,}@([a-z]+\\.[a-z]+){1}");
        return pattern.matcher(email).matches();
    }
}
