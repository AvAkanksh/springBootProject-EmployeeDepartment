package com.akanksh.springbootproject.controller;

import com.akanksh.springbootproject.entity.Department;
import com.akanksh.springbootproject.service.DepartmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private DepartmentService departmentService;

    private Department department;
    @BeforeEach
    void setUp() {
        department = Department.builder()
                .departmentName("HR")
                .departmentAddress("Pune")
                .departmentCode("hr-08")
                .departmentId(1L)
                .build();

    }

    @Test
    @DisplayName("saveDepartmentTest")
    void saveDepartment() throws Exception {
        Department inputDepartment = Department.builder()
                .departmentName("HR")
                .departmentAddress("Pune")
                .departmentCode("hr-08")
                .build();
        Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

        mockMvc.perform(post("/departments").contentType(MediaType.APPLICATION_JSON).content("{\n" +
                "\t\"departmentName\":\"HR\",\n" +
                "\t\"departmentAddress\":\"Pune\",\n" +
                "\t\"departmentCode\":\"hr-08\"\n" +
                "}")).andExpect(status().isOk());
    }

    @Test

    void fetchDepartmentById() throws Exception {
        Mockito.when(departmentService.fetchDepartmentById(1L)).thenReturn(department);
        mockMvc.perform(get("/departments/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }


}