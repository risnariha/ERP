package com.erp.ERP.Service;

import com.erp.ERP.Model.Student;
import com.erp.ERP.Repository.StudentRepo;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepo studentRepo;

    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }


}
