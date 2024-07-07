package com.myspringbootproject.employeeManagementBackend.mapper;

import com.myspringbootproject.employeeManagementBackend.dto.DepartmentDto;
import com.myspringbootproject.employeeManagementBackend.entity.Department;

public class DepartmentMapper {

    // convert department JPA entity into department DTO
    public static DepartmentDto mapToDepartmentDto(Department department){

        // returns a DepartmentDto object populated with data from the Department entity
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }

    // convert DepartmentDto object into Department entity object

    public static Department mapToDepartment(DepartmentDto departmentDto){

        // returns a Department entity object initialized with the data from the DepartmentDto
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }
}
