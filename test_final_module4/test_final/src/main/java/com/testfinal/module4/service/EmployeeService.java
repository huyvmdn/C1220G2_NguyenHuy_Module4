package com.testfinal.module4.service;

import com.testfinal.module4.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService extends GeneralService<Employee> {
    public boolean checkExistUser(String email);
    public Employee findByEmail(String email);

    Page<Employee> search4(String nameEmployee, String position, String educationDegree, String division, Pageable pageable);
}
