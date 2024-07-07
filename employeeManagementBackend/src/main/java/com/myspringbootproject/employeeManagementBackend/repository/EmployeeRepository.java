package com.myspringbootproject.employeeManagementBackend.repository;

import com.myspringbootproject.employeeManagementBackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


// to get CRUD methods to perform CRUD database operations on Employee entity
// JpaRepository is a generic interface, need to pass two parameters
// first parameter is the type of the entity, second parameter is the type of the primary key
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
