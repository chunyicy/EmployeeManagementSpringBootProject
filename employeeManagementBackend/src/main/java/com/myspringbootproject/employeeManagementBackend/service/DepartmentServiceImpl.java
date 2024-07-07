package com.myspringbootproject.employeeManagementBackend.service;

import com.myspringbootproject.employeeManagementBackend.dto.DepartmentDto;
import com.myspringbootproject.employeeManagementBackend.entity.Department;
import com.myspringbootproject.employeeManagementBackend.exception.ResourceNotFoundException;
import com.myspringbootproject.employeeManagementBackend.mapper.DepartmentMapper;
import com.myspringbootproject.employeeManagementBackend.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

    // inject departmentRepository using constructor based dependency injection
    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        // first map the incoming DepartmentDto object to a Department entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        // it saves the mapped Department entity to the databse
        Department savedDepartment = departmentRepository.save(department);

        // return departmentDto, map the savedDepartment entity back to a DepartmentDto obejct
        return DepartmentMapper.mapToDepartmentDto(savedDepartment);
    }

    // getDepartmentById method retrieves a department by its id from the databse
    @Override
    public DepartmentDto getDepartmentById(Long departmentId) {

        // if department not found then throw ResourceNotFoundException
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                ()-> new ResourceNotFoundException("Department not found: " + departmentId)
        );

        // returns a DepartmentDto
        return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public void deleteDepartment(Long departmentId) {

        // if department not found then throw ResourceNotFoundException
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                ()-> new ResourceNotFoundException("Department not found: " + departmentId)
        );

        departmentRepository.deleteById(departmentId);
    }
}
