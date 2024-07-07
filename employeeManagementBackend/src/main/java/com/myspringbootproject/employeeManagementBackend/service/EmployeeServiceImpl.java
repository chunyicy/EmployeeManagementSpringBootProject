package com.myspringbootproject.employeeManagementBackend.service;


import com.myspringbootproject.employeeManagementBackend.dto.EmployeeDto;
import com.myspringbootproject.employeeManagementBackend.entity.Employee;
import com.myspringbootproject.employeeManagementBackend.exception.ResourceNotFoundException;
import com.myspringbootproject.employeeManagementBackend.mapper.EmployeeMapper;
import com.myspringbootproject.employeeManagementBackend.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// create EmployeeServiceImpl class that implements EmployeeService interface and it's methods
// annotate the @Service, the class becomes a spring bean, for managing service components

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    // inject EmployeeRepository as a dependency
    private EmployeeRepository employeeRepository;

    // implement createEmployee method
    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        // map EmployeeDto to Employee JPA entity
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        // employeeRepository save() method to store the Employee entity into database
        Employee savedEmployee = employeeRepository.save(employee);

        // return savedEmployee object back to the client side
        // convert savedEmployee JPA entity into EmployeeDto
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);

    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        // here will retrieve "Optional" object from repository method (fetching an 'Employee' by id)
        // in service layer, you can retrieve 'Optional<Employee>' from the repository, and use 'orElseThrow' to handle
        // the case where the Employee with the given id does not exist. Optional's orElseThrow method

        // retrieve the Employee entity from the repository by employeeId
        Employee employee = employeeRepository.findById(employeeId)
                // if the employee is found, return it. Otherwise, throw a ResourceNotFoundException
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + employeeId));

        // map the Employee entity to EmployeeDto using EmployeeMapper
        return EmployeeMapper.mapToEmployeeDto(employee);

    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        // call employeeRepository findAll() method, it returns a List of type Employee entity, here is list of Employee JPA entities
        // but getAllEmployees method returns a list of EmployeeDto, so let's convert a list of Employee entities into list of EmployeeDto
        // use map method to map one object into another object, so in this case convert Employee entity into EmployeeDto
        // .stream() converts the list of employees into a stream of elements
        // .collect(Collectors.toList()) collects the mapped EmployeeDto objects into a new List<EmployeeDto>
        // EmployeeMapper responsible for mapping between 'Employee' entities and 'EmployeeDto' data transfer objects
        // it encapsulates the logic for converting one type of object (entity) to another (DTO)

        // retrieve all "Employee" objects from the database using the 'findAll()' method provided by 'employeeRepository'
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());

    }


    // updates an existing employee's information based on the provided 'employeeId' and 'updatedEmployee' DTO

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        // find the employee by employeeId from the repository
        // if no employee is found (example: 'findById' returns an empty 'Optional'), a 'ResourceNotFoundException' is thrown
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->new ResourceNotFoundException("Employee not found with id: " + employeeId));

        // set all the details from updatedEmployee object into this employee object
        // update the employee object with new data from updatedEmployee DTO
        // update the fields of the 'employee' object with the corresponding data from 'updatedEmployee' DTO
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        // save the updated employee object back to the repository
        // this save method perform both save and update operation
        // the updated 'employee' object is saved or updated in the database using 'save method of 'employeeRepository'
        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) { // delete an employee based on the provided employeeId

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                ()->new ResourceNotFoundException("Employee not found with id: " + employeeId)
        );

        // once the employee is successfully found (without throwing an exception), deleteById method of
        // employeeRepository is called to delete the employee from the database based on the provided employeeId
        employeeRepository.deleteById(employeeId);


    }
}
