package com.myspringbootproject.employeeManagementBackend.service;


import com.myspringbootproject.employeeManagementBackend.dto.DepartmentDto;

// this interface outlines methods related to managing departments
public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentById(Long departmentId);

    void deleteDepartment(Long departmentId);
}
