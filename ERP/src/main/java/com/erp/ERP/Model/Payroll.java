package com.erp.ERP.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double salary;
    private Double deduction;
    private Double netPay;
    // Reference to staff/employee

    // Constructors, getters, setters
}

