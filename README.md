

# EmployeeManagement_System



## Building my first Spring Boot Project: I utilize Spring Boot and MySQL to build a CRUD (Create, Read, Update, Delete) REST API for an Employee Management System.

-	Add Employee
-	Get Employee
-	Get All Employees
-	Update Employee
-	Delete Employee
-	Add Department
-	Get Department
-	Delete Department
-	Create custom exceptions and implement a global exception handler to handle errors and exceptions

 	<br/>

***TECHNOLOGY STACK:*** 


IntelliJ IDEA, Spring Boot 3, Spring Data JPA, MySQL Database, Postman Client
Follow the Three Layer Architecture to organize my application code into distinct layers (Controller layer, Service layer and Repository layer), each responsible for specific concerns. Implementing the Controller Layer to handle incoming HTTP request and responses, Service layer to handle business logic and interacts with the repository layer for CRUD (Create, Read, Update, Delete) operations, this layer encapsulates the application business logic, Repository Layer to handle data access and interacts with the database. Controller layer depends on the Service layer, and Service layer depends on the Repository layer.

<br/>
<br/>

![projectSetup](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/10a20155-b953-430c-b509-5a7e9ff65d9f)

 <br/>
 
![employeeEntity](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/296da939-6da8-47ef-b9a9-bc1a109ac235)

 
Create Employee JPA entity. Define this Employee class to represents the structure of an employee and annotating it with JPA annotations to map it to a MySQL database table.

<br/>
<br/>

![employeeRepository](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/9508c27b-befa-48c8-b476-7fe336c44478)



Create EmployeeRepository interface. By extending JpaRepository<Employee, Long>, EmployeeRepository will inherits the CRUD methods and get these methods (Create, Read, Update, Delete) to perform CRUD database operations on Employee entity.

<br/>
<br/>

![employeeDto](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/4bdd7044-db1d-4835-bcf0-407d87f544ed)


<br/>

![employeeMapper](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/d9f675da-cb23-4636-8281-a49f3fb78da9)

 
Create EmployeeDto and EmployeeMapper, making use of EmployeeDto class to transfer the data between client and server. EmployeeMapper class is used to facilitate the conversion between Employee entity and EmployeeDto objects (Data Transfer Objects). 

<br/>
<br/>


### 1.	Build Add Employee REST API

<br/>

![createEmployeeServiceInterface](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/bd7800ed-dd24-475d-8f7c-dbca566f2b47)

 
Define createEmployee() method within the EmployeeService interface.

<br/>
<br/>


![createEmployeeServiceImpl](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/5aa48523-a2f8-4299-9ea6-34c66ec3fa5f)

 
This EmployeeServiceImpl class implements the EmployeeService interface. Implementing the createEmployee() method within EmployeeServiceImpl class.

<br/>
<br/>

![createEmployeeController](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/8b845d12-c693-43b3-b2bd-6733083e277f)

 
Build Add Employee REST API within EmployeeController class.
Create EmployeeController class and annotate this class with @RestController annotation to handle HTTP requests and responses.

 <br/>
 <br/>
 
![testCreateEmployee](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/4db0f062-6b6b-4d50-b808-0aeb7219cd6f)

Test Add Employee REST API using postman client.

<br/>
<br/>

### 2.	Build Get Employee REST API

<br/>

![getEmployeeServiceInterface](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/4a69324f-5c68-4f88-8f1b-21e90a07cc75)

Define getEmployeeById() method within the EmployeeService interface.

<br/>
<br/>

![resourceNotFoundException](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/30c3fed0-7bbd-46f0-afae-382215c2ac70)

 
Create custom exception name as ResourceNotFoundException and extend this class from RunTimeException. If Employee with a given id is not found in the MySQL database, then throw this ResourceNotFoundException.

<br/>
<br/>

![globalException](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/4d1b863d-77df-428f-a8bf-043f842aa227)

 
Define global exception handling for all controllers.
Set up global exception handler using @ControllerAdvice or @RestControllerAdvice to define global exception handling for all controllers in the application. 

<br/>
<br/>

![getEmployeeServiceImpl](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/27dcb6b9-a540-4704-b13d-b860bceae659)

 
Implement getEmployeeById() method within EmployeeServiceImp class.

<br/>
<br/>


![getEmployeeController](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/81fe9e26-1933-4f13-88a2-c9f5fe31a4c1)

 
Build Get Employee by Id REST API within EmployeeController class.

<br/>
<br/>

![testGetEmployee1](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/1e6da216-a91a-4779-a437-c1df8d89edc9)



<br/>

![testGetEmployee2](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/9635fe92-b758-465b-ae18-a6fd65fada22)


 
Test Get Employee by Id REST API using postman client.

<br/>
<br/>

### 3. Build Get All Employee REST API

<br/>

![getAllEmployeeServiceInterface](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/c7672711-b244-4429-9aa5-32edf06e4653)


Define getAllEmployee() method within the EmployeeService interface.

<br/>
<br/>


![getAllEmployeeServiceImpl](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/45957d0d-83b5-45a4-b4b6-b272c79916ea)

 
Implement getAllEmployee() method within the EmployeeServiceImpl class.

<br/>
<br/>

![getAllEmployeeController](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/549b0f93-d1d0-45c5-9dae-614f833f257c)

 
Build Get All Employees REST API within EmployeeController class.

<br/>
<br/>


 ![testGetAllEmployee](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/faeef374-ff3d-413d-843e-5f7819a630cc)


Test Get All Employees REST API using postman client.

<br/>
<br/>

### 4.	Build Update Employee REST API

<br/>

![updateEmployeeServiceInterface](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/616349eb-0cf6-4a04-bbc2-bc6b55fdaf8e)

 
Define updateEmployee() method within the EmployeeService interface.

<br/>
<br/>

![updateEmployeeServiceImpl](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/1c0b12e0-c317-4b38-82df-f11701ed7191)

 
Implement updateEmployee() method within EmployeeServiceImp class.

<br/>
<br/>

 
![updateEmployeeController](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/f53947bc-c763-4519-bbb6-27d655b3ec7d)


Build Update Employee REST API within EmployeeController class.

<br/>
<br/>

![testUpdateEmployeeGetEmployeeFirst](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/83a580dc-6f80-4061-b94f-d178d16ff9c4)


<br/>

![testUpdateEmployee](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/6440963f-7df2-4159-be8a-05d783946673)

 
Test Update Employee REST API using postman client. For example, updating Chery’s email address to cherylng@gmail.com


<br/>
<br/>


### 5.	Build Delete Employee REST API.

<br/>

![deleteEmployeeServiceInterface](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/f0ff451e-ed29-4930-8638-e4eca965c20a)

 
Define deleteEmployee() method within the EmployeeService interface.

<br/>
<br/>

![deleteEmployeeServiceImpl](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/b40ccc88-a6f6-4067-a36e-46a70fbe3096)


 
Implement deleteEmployee() method within EmployeeServiceImp class.

<br/>
<br/>
 
![deleteEmployeeController](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/74a40531-5a1a-4295-95e9-4556c03268ce)


Build Delete Employee REST API within EmployeeController class.

<br/>
<br/>

 ![testDeleteEmployee1](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/1890d78c-63fb-4d31-b171-de64e4b7be66)


<br/>

![testDeleteEmployee2](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/e05d6449-4f03-45e4-9ef6-f5cd68d4b70a)


Test Delete Employee REST API using postman client.

<br/>
<br/>


## Build REST API for Department Management Module to Add Department, Get Department and Delete Department.

<br/>

 ![departmentEntity](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/813bcb8f-3078-4ea4-af7e-a32375d65db0)



<br/>

![departmentRepository](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/84c8ce12-d4a4-4837-861e-e8dc4ef74653)


Create Department Entity and departmentRepository interface.

<br/>
<br/>

![departmentDto](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/77c99357-dd07-43f5-8df3-c86ae6f6ff50)


<br/>

![departmentMapper](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/f3a91fc3-64c6-41e6-a68e-393fb71d233c)

 
Create DepartmentDto and DepartmentMapper.

<br/>
<br/>


### 6.	Build Add Department REST API.

<br/>

![addDepartmentServiceInterface](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/3a4d3112-6302-484f-8da6-49c4537bee68)

<br/>

![addDepartmentServiceImpl](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/d68289ce-c14e-406b-8a39-06a0677e01cf)


<br/>

![addDepartmentController](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/d9931691-e0f3-419d-b35c-749ff8993a6b)

<br/>

![testAddDepartment](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/b5a92d43-08a9-4ebd-80a3-a5058b77f999)


<br/>
<br/>


### 7.	Build Get Department REST API

<br/>

![getDepartmentServiceInterface](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/07bee75e-7eed-4ee3-a93e-1a2abfaae4b5)


<br/>

![getDepartmentServiceImpl](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/23c3078d-41c6-40e0-9586-8eaca15b843c)


<br/>

![getDepartmentController](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/54bfe1f3-e899-49be-b709-a389e4d0c71a)


<br/>

![testGetDepartment](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/cda8e444-233e-4768-95ee-04e9d3b72cd9)


<br/>
<br/>
 

### 8.	Build Delete Department REST API

<br/>

![deleteDepartmentServiceInterface](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/ad2a59f1-c93a-4d4c-98b4-6a1ae48db6d6)

 
<br/>

![deleteDepartmentServiceImpl](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/e799e7b2-1e3e-44be-815d-12fbda2b844c)


<br/>

![deleteDepartmentController](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/5fbba294-e2d2-46d7-af20-aeeab12b7ba0)


<br/>

![testDeleteDepartment](https://github.com/chunyicy/EmployeeManagementSpringBootProject/assets/116086176/36f6b2e5-3acb-4f00-9fb8-385017220585)

<br/>
<br/>

