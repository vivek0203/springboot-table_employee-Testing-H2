package com.example.table_employee.springbootpostgresqltable_employee.controller;

import com.example.table_employee.springbootpostgresqltable_employee.Entity.Table_Employee;
import com.example.table_employee.springbootpostgresqltable_employee.service.Table_employeeService;
import com.sun.istack.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;
@ExtendWith(MockitoExtension.class)
class Table_employeeControllerTest {

    @Mock
    private Table_employeeService service;
    @InjectMocks
    private Table_employeeController controller;

    private Table_Employee employee;

    @BeforeEach
    void setUp() {
        employee = Table_Employee.builder()
                .id(1L)
                .name("Ram Das")
                .department("HR")
                .email("ram@gmail.com")
                .build();

    }
    @Test
    public void getAllTest() {

        Table_Employee employee1 =Table_Employee .builder()
                .id(2L)
                .name("Zara Pandey")
                .department("Sells")
                .email("zara@gmail.com")
                .build();
        given(service.getAll()).willReturn(List.of(employee,employee1));

        List<Table_Employee> employeeList = controller.getAll();

        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);
    }
    @Test
    public void saveTest() {
        given(service.save(employee)).willReturn(employee);
        Table_Employee savedEmployee = controller.save(employee);
        System.out.println(savedEmployee);

        assertThat(savedEmployee.getName()).isEqualTo("Ram Das");
        assertThat(savedEmployee).isNotNull();
    }
    @Test
    public void updateBy() {
       given(service.saveOrUpdate(employee)).willReturn(employee);
       employee.setName("Ram Kumar");
       employee.setDepartment("CEO");

       Table_Employee updatedEmployee= controller.saveOrUpdate(employee);
       
       assertThat(updatedEmployee.getName()).isEqualTo("Ram Kumar");
       assertThat(updatedEmployee.getDepartment()).isEqualTo("CEO");
    }
    @Test
    public void deleteBy() {
        long id = 1l;
        willDoNothing().given(service).deleteBy(id);
        controller.deleteBy(id);

        verify(service,times(1)).deleteBy(id);
    }
    @Test
    void getById() {
        given(service.findById(1L)).willReturn(Optional.of(employee));

        Table_Employee savedEmployee = controller.getById(employee.getId()).get();

        assertThat(savedEmployee).isNotNull();
    }
}