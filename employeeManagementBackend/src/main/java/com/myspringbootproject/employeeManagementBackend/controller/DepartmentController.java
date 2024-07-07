package com.myspringbootproject.employeeManagementBackend.controller;

import com.myspringbootproject.employeeManagementBackend.dto.DepartmentDto;
import com.myspringbootproject.employeeManagementBackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // indicates that this class is a Spring MVC Controller that handles HTTP requests
@AllArgsConstructor
@RequestMapping("api/departments") // specifies the base URL path (/api/departments)
public class DepartmentController {

    // inject DepartmentService dependency
    // this service is responsible for handling business logic related to departments,
    // such as creating, updating, deleting, and retrieving departments
    private DepartmentService departmentService;


    // Build Add Department REST API

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto){

        DepartmentDto department = departmentService.createDepartment(departmentDto);

        // returns a ResponseEntity with the created DepartmentDto object and HTTP status code 201 Created
        // to indicate successful creation of the resource
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }


    // Build Get Department REST API
    @GetMapping("{departmentId}")
    public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable("departmentId") Long departmentId){
        DepartmentDto departmentDto = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDto);
    }

    // Build Delete Department REST API

    @DeleteMapping("{departmentId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("departmentId") Long departmentId){
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department deleted successfully");
    }
}
