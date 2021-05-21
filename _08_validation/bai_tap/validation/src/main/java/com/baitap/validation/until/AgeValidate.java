package com.baitap.validation.until;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Component
public class AgeValidate implements ConstraintValidator<Age, Long> {
   public void initialize(Age constraint) {
   }

   public boolean isValid(Long obj, ConstraintValidatorContext context) {
      return obj!=null && obj>18;
   }
}
