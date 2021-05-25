package com.case_study.furama.dto;


import com.case_study.furama.model.entity.Customer;
import com.case_study.furama.model.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;

public interface Mapping {



    public static Customer dtoToCustomer(CustomerDTO object) {
        Customer customer= new Customer();
        customer.setId(object.getId());
        customer.setName(object.getName());
        customer.setCode(object.getCode());
        customer.setBirthday(object.getBirthday());
        customer.setGender(object.isGender());
        customer.setIdCard(object.getIdCard());
        customer.setPhone(object.getPhone());
        customer.setEmail(object.getEmail());
        customer.setAddress(object.getAddress());
        customer.setCustomerType(object.getCustomerType());
        return customer;
    }

    public static Employee dtoToEmployee(EmployeeDTO object) {
        Employee employee= new Employee();
        employee.setId(object.getId());
        employee.setName(object.getName());
        employee.setBirthday(object.getBirthday());
        employee.setIdCard(object.getIdCard());
        employee.setSalary(object.getSalary());
        employee.setPhone(object.getPhone());
        employee.setEmail(object.getEmail());
        employee.setAddress(object.getAddress());
        employee.setPosition(object.getPosition());
        employee.setEducationDegree(object.getEducationDegree());
        employee.setDivision(object.getDivision());

        return employee;
    }
}
