package com.myspringbootproject.employeeManagementBackend.service;

import com.myspringbootproject.employeeManagementBackend.dto.EmployeeDto;

import java.util.List;

// define the methods within the EmployeeService interface
public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee);

    void deleteEmployee(Long employeeId);

}
