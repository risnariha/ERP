package com.erp.ERP.Service;


import com.erp.ERP.Model.Course;
import com.erp.ERP.Repository.courseRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    private final courseRepo courseRepo;

    public CourseService(courseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public List<Course> getAllCourses() {
        return courseRepo.findAll();
    }

    public Course getCourseById(Long id) {
        Optional<Course> course = courseRepo.findById(id);
        return course.orElse(null);
    }

    public Course createCourse(Course course) {
        return courseRepo.save(course);
    }

    public Course updateCourse(Long id, Course courseDetails) {
        return courseRepo.findById(id).map(course -> {
            course.setName(courseDetails.getName());
            course.setCode(courseDetails.getCode());
            course.setDescription(courseDetails.getDescription());
            course.setCredits(courseDetails.getCredits());
            // Add more fields as needed
            return courseRepo.save(course);
        }).orElse(null);
    }

    public void deleteCourse(Long id) {
        courseRepo.deleteById(id);
    }
}
