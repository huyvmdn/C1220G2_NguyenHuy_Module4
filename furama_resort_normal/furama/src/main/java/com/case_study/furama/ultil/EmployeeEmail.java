package com.case_study.furama.ultil;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmployeeEmailValidate.class)
public @interface EmployeeEmail {
    String message() default "email unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
