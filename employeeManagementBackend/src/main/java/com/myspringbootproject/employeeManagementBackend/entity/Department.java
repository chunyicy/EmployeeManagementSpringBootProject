package com.myspringbootproject.employeeManagementBackend.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// create Department Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity // indicates that this is a JPA entity and should be mapped to the database table
@Table(name = "departments") // specifies the name of the database table
public class Department {

    // @Id denotes the primary key of the entity
    // specify the strategy for generating primary keys. 'IDENTITY' indicates that the database will
    // automatically assign a unique primary key value when a new 'Department' entity is persisted
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "department_name")
    private String departmentName;

    @Column(name = "department_description")
    private String departmentDescription;
}
