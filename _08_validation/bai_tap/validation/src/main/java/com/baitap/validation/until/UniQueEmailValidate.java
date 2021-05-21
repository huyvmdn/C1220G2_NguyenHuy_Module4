package com.baitap.validation.until;

import com.baitap.validation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Component
public class UniQueEmailValidate implements ConstraintValidator<UniqueEmail, String> {

   @Autowired
   private UserService userService;

   public void initialize(UniqueEmail constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return obj!=null&& !userService.checkExistUser(obj);
   }
}
