package com.erp.ERP.Repository;


import com.erp.ERP.Model.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepo extends JpaRepository<Attendance, Long> {
    // You can add custom query methods here if needed
}
