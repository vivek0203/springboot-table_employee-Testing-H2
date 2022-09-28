package com.example.table_employee.springbootpostgresqltable_employee.Repository;

import com.example.table_employee.springbootpostgresqltable_employee.Entity.Table_Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Table_employeeRepository extends JpaRepository<Table_Employee,Long> {
}
