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

    private Long staffId;      // Reference to staff/employee
    private Double salary;
    private Double deduction;
    private Double netPay;
    private String payDate;    // Use String or LocalDate

    public Payroll() {}

    public Payroll(Long staffId, Double salary, Double deduction, Double netPay, String payDate) {
        this.staffId = staffId;
        this.salary = salary;
        this.deduction = deduction;
        this.netPay = netPay;
        this.payDate = payDate;
    }

    public Long getId() { return id; }
    public Long getStaffId() { return staffId; }
    public Double getSalary() { return salary; }
    public Double getDeduction() { return deduction; }
    public Double getNetPay() { return netPay; }
    public String getPayDate() { return payDate; }

    public void setId(Long id) { this.id = id; }
    public void setStaffId(Long staffId) { this.staffId = staffId; }
    public void setSalary(Double salary) { this.salary = salary; }
    public void setDeduction(Double deduction) { this.deduction = deduction; }
    public void setNetPay(Double netPay) { this.netPay = netPay; }
    public void setPayDate(String payDate) { this.payDate = payDate; }
}
