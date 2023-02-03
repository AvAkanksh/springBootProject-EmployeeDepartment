package com.akanksh.springbootproject.controller;

import com.akanksh.springbootproject.entity.Employee;
import com.akanksh.springbootproject.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    /**
     * 
     * @param employee
     * @return
     */
    @PostMapping("/employees")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer employeeId){
        return employeeService.getEmployeeById(employeeId);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") Integer employeeId,@RequestBody Employee employee){
        return employeeService.updateEmployee(employeeId,employee);
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployeeById(@PathVariable("id") Integer employeeId){
        employeeService.deleteEmployeeById(employeeId);
        return " Employee data entry has been SUCCESSFULLY! ";
    }

}
