package com.example.table_employee.springbootpostgresqltable_employee.service;



import com.example.table_employee.springbootpostgresqltable_employee.Entity.Table_Employee;

import java.util.List;
import java.util.Optional;

public interface Table_employeeService {

    List<Table_Employee> getAll();

    Table_Employee save(Table_Employee employee);

    Table_Employee saveOrUpdate(Table_Employee employee);

    void deleteBy(long id);

    Optional<Table_Employee> findById(long id);
}
