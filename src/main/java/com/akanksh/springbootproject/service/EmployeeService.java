package com.akanksh.springbootproject.service;

import com.akanksh.springbootproject.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee saveEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(Integer employeeId);

    public Employee updateEmployee(Integer employeeId, Employee employee);

    public void deleteEmployeeById(Integer employeeId);
}
