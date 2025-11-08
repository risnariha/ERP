package com.erp.ERP.Service;

import com.erp.ERP.Model.Faculty;
import com.erp.ERP.Repository.FacultyRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyService {

    private final FacultyRepo facultyRepo;

    public FacultyService(FacultyRepo facultyRepo) {
        this.facultyRepo = facultyRepo;
    }

    public List<Faculty> getAllFaculty() {
        return facultyRepo.findAll();
    }

    public Faculty getFacultyById(Long id) {
        Optional<Faculty> faculty = facultyRepo.findById(id);
        return faculty.orElse(null); // Handle not found appropriately as needed
    }

    public Faculty createFaculty(Faculty faculty) {
        return facultyRepo.save(faculty);
    }

    public Faculty updateFaculty(Long id, Faculty facultyDetails) {
        return facultyRepo.findById(id).map(faculty -> {
            faculty.setName(facultyDetails.getName());
            faculty.setDepartment(facultyDetails.getDepartment());
            // Update more fields as necessary
            return facultyRepo.save(faculty);
        }).orElse(null); // Handle not found appropriately as needed
    }

    public void deleteFaculty(Long id) {
        facultyRepo.deleteById(id);
    }
}
