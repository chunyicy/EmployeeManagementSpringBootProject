package com.myspringbootproject.employeeManagementBackend.repository;

import com.myspringbootproject.employeeManagementBackend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;


// by extending JpaRepository<Department, Long>, DepartmentRepository inherits several methods:
// CRUD operations: Methods like save, findById, findAll, delete and deleteById are provided by default
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
