package com.myspringbootproject.employeeManagementBackend.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// EmployeeDto is used to transfer the data between client and server
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
