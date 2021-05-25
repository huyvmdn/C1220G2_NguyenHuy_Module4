package com.case_study.furama.ultil;


import com.case_study.furama.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Component
public class UniQueEmailValidate implements ConstraintValidator<CustomerEmail, String> {

   @Autowired
   private CustomerService customerService;

   public void initialize(CustomerEmail constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return obj!=null&& !customerService.checkExistUser(obj);
   }
}
