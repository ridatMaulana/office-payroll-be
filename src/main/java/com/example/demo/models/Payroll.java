package com.example.demo.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "payrolls")
public class Payroll {
    @Id
    @Column(name = "id", nullable = false, length = 36)
    private String id;

    @Column(name = "employee_id", length = 36)
    private String employeeId;

    @Column(name = "salary_id", length = 36)
    private String salaryId;

    @Column(name = "pay_date", nullable = false)
    private LocalDate payDate;

    @Column(name = "bonus")
    private Long bonus;

    @Column(name = "total")
    private Long total;

}