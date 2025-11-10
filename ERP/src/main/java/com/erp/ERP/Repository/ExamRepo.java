package com.erp.ERP.Repository;



import com.erp.ERP.Model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepo extends JpaRepository<Exam, Long> {
    // Add custom query methods here if needed
}
