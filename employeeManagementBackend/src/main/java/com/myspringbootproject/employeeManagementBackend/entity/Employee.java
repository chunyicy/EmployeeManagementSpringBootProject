package com.myspringbootproject.employeeManagementBackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity // specify this class as a JPA entity
@Table(name = "employees") // specify the table details
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increment the primary key from database
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_Address", nullable = false, unique = true)
    private String email;
}
