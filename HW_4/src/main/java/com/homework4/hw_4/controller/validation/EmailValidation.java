package com.homework4.hw_4.controller.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmailCheck.class)
public @interface EmailValidation {

    String message() default "Invalid email!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
