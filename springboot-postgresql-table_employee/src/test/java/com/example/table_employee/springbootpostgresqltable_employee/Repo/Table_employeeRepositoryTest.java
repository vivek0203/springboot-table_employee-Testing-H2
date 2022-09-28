package com.example.table_employee.springbootpostgresqltable_employee.Repo;

import com.example.table_employee.springbootpostgresqltable_employee.Entity.Table_Employee;
import com.example.table_employee.springbootpostgresqltable_employee.Repository.Table_employeeRepository;
import com.example.table_employee.springbootpostgresqltable_employee.SpringbootPostgresqlTableEmployeeApplication;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Optional;

@SpringBootTest(classes = SpringbootPostgresqlTableEmployeeApplication.class)
@ExtendWith(SpringExtension.class)
class Table_employeeRepositoryTest {

    @Autowired
    private Table_employeeRepository repository;

    private Table_Employee employee;

    @BeforeEach
    public void setUp() {
        employee  = Table_Employee.builder()
                .name("Rony Singh")
                .department("BackEnd")
                .email("rony@gmail.com")
                .build();
    }
    @Test
    public void givenTable_EmpList_whenFindAll_thenReturnTable_EmpList(){
        Table_Employee employee1 = Table_Employee.builder()
                .name("Reena Jha")
                .department("FrontEnd")
                .email("reena@gmail.com")
                .build();

        repository.save(employee);
        repository.save(employee1);

        List<Table_Employee> employeeList = repository.findAll();

        assertThat(employeeList).isNotNull();

    }
    @Test
    public void givenTable_EmpObj_whenSave_thenReturnTable_Emp(){
        Table_Employee employee  = Table_Employee.builder()
                .name("Rony Singh")
                .department("BackEnd")
                .email("rony@gmail.com")
                .build();

        Table_Employee saveEmployee = repository.save(employee);

        assertThat(saveEmployee).isNotNull();
        assertThat(saveEmployee.getId()).isGreaterThan(0);

    }
    @Test
    public void givenTable_EmpObj_whenUpdate_thenReturnUpdatedTable_Employee(){

        repository.save(employee);
        Table_Employee savedEmployee = repository.findById(employee.getId()).get();
        savedEmployee.setEmail("ram@gmail.com");
        savedEmployee.setName("Ram Das");
        Table_Employee updatedEmployee = repository.save(savedEmployee);

        assertThat(updatedEmployee.getEmail()).isEqualTo("ram@gmail.com");
        assertThat(updatedEmployee.getName()).isEqualTo("Ram Das");
    }
    @Test
    public void givenTable_EmpObj_whenDelete_thenRemoveTable_Employee(){
        repository.save(employee);
        repository.deleteById(employee.getId());
        Optional<Table_Employee> employeeOptional = repository.findById(employee.getId());

        assertThat(employeeOptional).isEmpty();
   }
   @Test
   public void givenTable_EmpObj_whenFindById_thenReturnTable_Employee(){
       repository.save(employee);
       Table_Employee employeeDb = repository.findById(employee.getId()).get();
       assertThat(employeeDb).isNotNull();
   }



}