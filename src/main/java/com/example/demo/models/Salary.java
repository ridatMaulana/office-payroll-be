package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "salaries")
public class Salary {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "employee_id", length = 36)
    private String employeeId;

    @Column(name = "base_salary", nullable = false)
    private Long baseSalary;

}