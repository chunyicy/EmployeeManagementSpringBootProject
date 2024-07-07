package com.myspringbootproject.employeeManagementBackend.mapper;

import com.myspringbootproject.employeeManagementBackend.dto.EmployeeDto;
import com.myspringbootproject.employeeManagementBackend.entity.Employee;

// EmployeeMapper class is typically used to facilitate the conversion between
// Employee entities (domain objects) and EmployeeDto objects (Data Transfer Objects).
// Mapper class facilitate the conversion between DTOs and domain objects (entities),
// ensuring separation of concerns and maintainability. Create EmployeeMapper class to
// map Employee entity to EmployeeDto and EmployeeDto to Employee entity
public class EmployeeMapper {

    // map Employee JPA entity into EmployeeDto
    // get all the values from Employee JPA entity and set those values to EmployeeDto

    public static EmployeeDto mapToEmployeeDto(Employee employee){
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    // map EmployeeDto to Employee JAP entity

    public static Employee mapToEmployee(EmployeeDto employeeDto){
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }

}
