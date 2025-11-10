package com.erp.ERP.Service;


import com.erp.ERP.Model.Exam;
import com.erp.ERP.Repository.ExamRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExamService {

    private final ExamRepo examRepo;

    public ExamService(ExamRepo examRepo) {
        this.examRepo = examRepo;
    }

    public List<Exam> getAllExams() {
        return examRepo.findAll();
    }

    public Exam getExamById(Long id) {
        Optional<Exam> exam = examRepo.findById(id);
        return exam.orElse(null);
    }

    public Exam createExam(Exam exam) {
        return examRepo.save(exam);
    }

    public Exam updateExam(Long id, Exam examDetails) {
        return examRepo.findById(id).map(exam -> {
            exam.setExamName(examDetails.getExamName());
            exam.setSubject(examDetails.getSubject());
            exam.setDate(examDetails.getDate());
            // Add or update more fields as needed
            return examRepo.save(exam);
        }).orElse(null);
    }

    public void deleteExam(Long id) {
        examRepo.deleteById(id);
    }
}
