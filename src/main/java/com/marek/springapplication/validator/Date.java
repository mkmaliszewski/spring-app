package com.marek.springapplication.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = DateValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Date {
    String message() default "The born date must be correct and match the dd.mm.yyyy pattern!";
     
    Class<?>[] groups() default {};
     
    Class<? extends Payload>[] payload() default {};
}
