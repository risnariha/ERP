package com.erp.ERP.Repository;

import com.erp.ERP.Model.Student; // update this path if needed
import org.springframework.data.jpa.repository.JpaRepository;

// Use interface, not class
public interface StudentRepo extends JpaRepository<Student, Long> {
    // You can add custom query methods here if required
}
