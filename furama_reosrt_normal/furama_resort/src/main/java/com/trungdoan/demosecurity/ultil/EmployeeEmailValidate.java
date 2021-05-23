package com.trungdoan.demosecurity.ultil;

import com.trungdoan.demosecurity.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmployeeEmailValidate implements ConstraintValidator<EmployeeEmail, String> {

    @Autowired
    private EmployeeService employeeService;


    public void initialize(EmployeeEmail constraint) {
    }

    public boolean isValid(String obj, ConstraintValidatorContext context) {
        return obj != null && !employeeService.checkExistUser(obj);

    }
}
