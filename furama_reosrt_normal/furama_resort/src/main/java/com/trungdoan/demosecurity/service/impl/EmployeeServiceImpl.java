package com.trungdoan.demosecurity.service.impl;

import com.trungdoan.demosecurity.model.entity.Employee;
import com.trungdoan.demosecurity.repository.EmployeeRepository;
import com.trungdoan.demosecurity.service.EmployeeService;
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
}
