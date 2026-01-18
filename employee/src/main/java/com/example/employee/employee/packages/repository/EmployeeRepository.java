package com.example.employee.employee.packages.repository;

import com.example.employee.employee.packages.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Long> {
}

