package com.erp.ERP.Service;

import com.erp.ERP.Model.Attendance;
import com.erp.ERP.Repository.AttendanceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    private final AttendanceRepo attendanceRepo;

    public AttendanceService(AttendanceRepo attendanceRepo) {
        this.attendanceRepo = attendanceRepo;
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepo.findAll();
    }

    public Attendance getAttendanceById(Long id) {
        Optional<Attendance> attendance = attendanceRepo.findById(id);
        return attendance.orElse(null);
    }

    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepo.save(attendance);
    }

    public Attendance updateAttendance(Long id, Attendance attendanceDetails) {
        return attendanceRepo.findById(id).map(attendance -> {
            attendance.setStudentId(attendanceDetails.getStudentId());
            attendance.setDate(attendanceDetails.getDate());
            attendance.setPresent(attendanceDetails.getPresent());
            return attendanceRepo.save(attendance);
        }).orElse(null);
    }

    public void deleteAttendance(Long id) {
        attendanceRepo.deleteById(id);
    }
}
