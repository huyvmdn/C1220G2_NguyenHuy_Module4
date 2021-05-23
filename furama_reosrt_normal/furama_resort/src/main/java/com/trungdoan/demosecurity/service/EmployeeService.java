package com.trungdoan.demosecurity.service;

import com.trungdoan.demosecurity.model.entity.Employee;

public interface EmployeeService extends GeneralService<Employee> {
    public boolean checkExistUser(String email);
}
