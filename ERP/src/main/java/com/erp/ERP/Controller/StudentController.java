package com.erp.ERP.Controller;

import com.erp.ERP.Model.Student;
import com.erp.ERP.Service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Add methods: @PostMapping, @PutMapping, @DeleteMapping as needed
}
