package com.case_study.furama.repository;


import com.case_study.furama.model.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Boolean existsEmployeeByEmail(String email);
    Employee findByEmail(String email);


    @Query(value= "select * from employee  \n" +
            "where name like %?1% and position_id like %?2% and " +
            "educationDegree_id like %?3% and division_id like %?4%", nativeQuery = true)
    Page<Employee> search4(String nameEmployee, String position, String educationDegree, String division, Pageable pageable);
}
