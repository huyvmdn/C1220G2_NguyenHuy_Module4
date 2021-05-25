package com.case_study.furama.service.impl;

import com.case_study.furama.model.entity.Employee;
import com.case_study.furama.repository.EmployeeRepository;
import com.case_study.furama.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteById(Long idDelete) {
        employeeRepository.deleteById(idDelete);
    }

    @Override
    public boolean checkExistUser(String email) {
        return employeeRepository.existsEmployeeByEmail(email);
    }

    @Override
    public Employee findByEmail(String email) {
        return employeeRepository.findByEmail(email);
    }

    @Override
    public Page<Employee>  search4(String nameEmployee, String position, String educationDegree, String division, Pageable pageable) {
        return employeeRepository.search4(nameEmployee,position,educationDegree,division,pageable);
    }
}
