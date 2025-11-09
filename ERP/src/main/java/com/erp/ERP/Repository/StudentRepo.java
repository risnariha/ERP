package com.erp.ERP.Repository;

import com.erp.ERP.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepo extends JpaRepository<Student, Long> {

}
