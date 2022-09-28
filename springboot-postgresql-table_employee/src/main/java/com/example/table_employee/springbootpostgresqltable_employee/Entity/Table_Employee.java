package com.example.table_employee.springbootpostgresqltable_employee.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Table_Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private long id;
    @Column
    private String name;
    @Column
    private String department;
    @Column
    private String email;
}