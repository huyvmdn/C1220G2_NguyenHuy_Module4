package com.trungdoan.demosecurity.repository;

import com.trungdoan.demosecurity.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Boolean existsEmployeeByEmail(String email);
    Employee findByEmail(String email);
}
