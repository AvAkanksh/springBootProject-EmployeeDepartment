package com.akanksh.springbootproject.service;

import com.akanksh.springbootproject.entity.Department;
import com.akanksh.springbootproject.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DepartmentServiceTest {

    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("IT").departmentAddress("Banglore").departmentId(1L).departmentCode("IT-01").build();

        Mockito.when(departmentRepository.findByDepartmentName("IT"));
    }

    private DepartmentService departmentService;
    @Test
    @DisplayName("Get Data when valid Department Name")
    public void whenValidDepartmentName_theDepartmentShouldBeFound(){
        String departmentName = "IT";
        Department found = departmentService.findByDepartmentName(departmentName).get(0);
        assertEquals(departmentName,found.getDepartmentName());


    }
}