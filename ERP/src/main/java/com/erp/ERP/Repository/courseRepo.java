package com.erp.ERP.Repository;


import com.erp.ERP.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface courseRepo extends JpaRepository<Course, Long> {
    // Add custom query methods if needed
}
