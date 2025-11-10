package com.erp.ERP.Repository;



import com.erp.ERP.Model.Timetable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimetableRepo extends JpaRepository<Timetable, Long> {
    // Custom query methods if needed
}
