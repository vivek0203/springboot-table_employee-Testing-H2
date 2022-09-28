package com.example.table_employee.springbootpostgresqltable_employee.controller;

import com.example.table_employee.springbootpostgresqltable_employee.Entity.Table_Employee;
import com.example.table_employee.springbootpostgresqltable_employee.service.Table_employeeService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class Table_employeeController {
    @Autowired
    private Table_employeeService employeeService;

    @GetMapping("/table_employee")
    public List<Table_Employee> getAll() {
        return (List<Table_Employee>)employeeService.getAll();
    }
    @PostMapping("/table_employee")
    public Table_Employee save(@RequestBody Table_Employee employee){
     return employeeService.save(employee);
   }

   @PutMapping("table_employee")
    public Table_Employee saveOrUpdate(@RequestBody Table_Employee employee) {
        return employeeService.saveOrUpdate(employee);
   }
   @DeleteMapping("/table_employee/{id}")
    public void deleteBy(@PathVariable("id") long id){
        employeeService.deleteBy(id);
    }
    @GetMapping("table_employee/{id}")
    public Optional<Table_Employee> getById(@PathVariable("id") long id){
        return(Optional<Table_Employee>)employeeService.findById(id) ;
    }


    }
