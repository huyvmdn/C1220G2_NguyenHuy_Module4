package com.baitap.validation.until;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = AgeValidate.class)
public @interface Age {
    String message() default "number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
