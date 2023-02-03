package com.akanksh.springbootproject.service;

import com.akanksh.springbootproject.entity.Employee;
import com.akanksh.springbootproject.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Integer employeeId) {
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public Employee updateEmployee(Integer employeeId, Employee employee) {
        Employee employeeDB = employeeRepository.findById(employeeId).get();
        if(Objects.nonNull(employee.getEmployeeName())&&!"".equals(employee.getEmployeeName())){
            employeeDB.setEmployeeName(employee.getEmployeeName());
        }
        if(Objects.nonNull(employee.getEmployeeEmail())&&!"".equals(employee.getEmployeeEmail())){
            employeeDB.setEmployeeEmail(employee.getEmployeeEmail());
        }
        return employeeRepository.findById(employeeId).get();
    }

    @Override
    public void deleteEmployeeById(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }


}
