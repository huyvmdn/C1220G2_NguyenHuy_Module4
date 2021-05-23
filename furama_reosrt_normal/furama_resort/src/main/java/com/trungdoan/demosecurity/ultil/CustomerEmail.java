package com.trungdoan.demosecurity.ultil;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniQueEmailValidate.class)
public @interface CustomerEmail {
    String message() default "email unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
