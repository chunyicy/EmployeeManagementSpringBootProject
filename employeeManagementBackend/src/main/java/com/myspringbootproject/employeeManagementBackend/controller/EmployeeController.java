package com.myspringbootproject.employeeManagementBackend.controller;


import com.myspringbootproject.employeeManagementBackend.dto.EmployeeDto;
import com.myspringbootproject.employeeManagementBackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // handle HTTP request
@AllArgsConstructor
@RequestMapping("api/employees") // define the base URL
public class EmployeeController {

    // inject EmployeeService dependency
    private EmployeeService employeeService;

    // Build Add Employee REST API
    // @PostMapping is used to handle HTTP POST requests
    // @RequestBody to bind the incoming HTTP request body

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmployee = employeeService.createEmployee(employeeDto);

        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }



    // Build Get Employee by id REST API

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("employeeId") Long employeeId){

        // call the service layer to retrieve EmployeeDto
        EmployeeDto employeeDto = employeeService.getEmployeeById(employeeId);

        // return 200 ok with the retrieved EmployeeDto
        return ResponseEntity.ok(employeeDto);
    }


    // Build Get All Employees REST API

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){

        List<EmployeeDto> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }


    // Build Update Employee REST API
    // PutMapping is a controller method that handles HTTP PUT requests to update employee information
    // based on the 'employeeId' path variable and the 'updatedEmployee' request body
    // @RequestBody EmployeeDto updatedEmployee: this annotation binds the HTTP request body (typically in JSON format) to the 'updatedEmployee'
    // parameter, which is of type 'EmployeeDto'

    @PutMapping("{employeeId}") // maps HTTP PUT requests to the endpoint '/employeeId' where 'employeeId' is a path variable
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("employeeId") Long employeeId, @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(employeeId, updatedEmployee);

        // if the update operation is successful, the controller returns an HTTP 200 OK response
        // with the updated EmployeeDto object as the response body wrapped in a ResponseEntity
        return ResponseEntity.ok(employeeDto);
    }


    // Build Delete Employee REST API

    // This @DeleteMapping annotation maps HTTP DELETE requests to the endpoint /employeeId where employeeId is a path variable
    // this means the method will handle DELETE requests at URLs like /employees/123, where 123 is the employeeId
    // @PathVariable("employeeId") binds the value of the employeeId path variable from the URL to the method parameter Long employeeId

    @DeleteMapping("{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") Long employeeId){
        // invokes the service layer to delete the employee
        employeeService.deleteEmployee(employeeId);

        // returns a 200 OK response with a success message
        // indicating that employee was deleted
        return ResponseEntity.ok("Employee deleted successfully");
    }

}
