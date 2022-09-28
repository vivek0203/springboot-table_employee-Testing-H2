package com.example.table_employee.springbootpostgresqltable_employee.Service;

import com.example.table_employee.springbootpostgresqltable_employee.Entity.Table_Employee;
import com.example.table_employee.springbootpostgresqltable_employee.Repository.Table_employeeRepository;;
import com.example.table_employee.springbootpostgresqltable_employee.service.Table_employeeServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)

class Table_employeeServiceImplTest {
    @Mock
    private Table_employeeRepository repository;
    @InjectMocks
    private Table_employeeServiceImpl service;

    private Table_Employee employee;

    @BeforeEach
    void setUp() {
        employee  = Table_Employee.builder()
                .id(1L)
                .name("Rony Singh")
                .department("BackEnd")
                .email("rony@gmail.com")
                .build();
    }

    @Test
    void getAll() {
        Table_Employee employee1 = Table_Employee.builder()
                .id(2L)
                .name("Mona Chopda")
                .department("Marketing")
                .email("mona@gmail.com")
                .build();
        given(repository.findAll()).willReturn( List.of(employee,employee1));

        List<Table_Employee>employeeList = service.getAll();
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);

    }
    @Test
    void save() {
        given(repository.save(employee)).willReturn(employee);

        System.out.println(repository);
        System.out.println(service);

        Table_Employee savedEmployee = service.save(employee);

        assertThat(savedEmployee).isNotNull();
    }

    @Test
    void updateBy() {
        given(repository.save(employee)).willReturn(employee);
        employee.setDepartment("HR");


        Table_Employee updatedEmployee = service.saveOrUpdate(employee);

        assertThat(updatedEmployee.getDepartment()).isEqualTo("HR");

    }

    @Test
    void deleteBy() {

        long id =1L;

        willDoNothing().given(repository).deleteById(id);
        service.deleteBy(id);

        verify(repository,times(1)).deleteById(id);
    }

    @Test
    void getById() {
        given(repository.findById(1L)).willReturn(Optional.of(employee));

        Table_Employee savedEmployee = service.findById(employee.getId()).get();

        assertThat(savedEmployee).isNotNull();
    }
}