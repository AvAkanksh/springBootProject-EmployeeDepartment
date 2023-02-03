package com.akanksh.springbootproject.service;

import com.akanksh.springbootproject.entity.Department;

import java.util.List;

public interface DepartmentService {

   public Department saveDepartment(Department department);

   public List<Department> fetchAllDepartments();

   public Department fetchDepartmentById(Long departmentId);

  public void deleteDepartmentById(Long departmentId);

   public Department updateDepartment(Long departmentId, Department department);

    public List<Department> findByDepartmentName(String departmentName);
}
