package com.erp.ERP.Repository;



import com.erp.ERP.Model.Payroll;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PayrollRepo extends JpaRepository<Payroll, Long> {
    // Add custom payroll-specific queries as needed
}
