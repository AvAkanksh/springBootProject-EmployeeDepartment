package com.akanksh.springbootproject.repository;

import com.akanksh.springbootproject.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
