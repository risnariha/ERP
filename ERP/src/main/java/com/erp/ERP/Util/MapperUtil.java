package com.erp.ERP.Util;

import com.erp.ERP.Model.Student;
import com.erp.ERP.DTO.StudentDTO;
import com.erp.ERP.Model.User;
import com.erp.ERP.DTO.UserDTO;

import java.util.Collections;
import java.util.List;
import java.util.Arrays;

public class MapperUtil {

    // Student Entity ↔ StudentDTO
    public static StudentDTO toStudentDTO(Student student) {
        if (student == null) return null;
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setDepartment(student.getDepartment());
        dto.setYear(student.getYear());
        // Add more field mappings as needed
        return dto;
    }

    public static Student fromStudentDTO(StudentDTO dto) {
        if (dto == null) return null;
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setDepartment(dto.getDepartment());
        student.setYear(dto.getYear());
        // Add more field mappings as needed
        return student;
    }

    // User Entity ↔ UserDTO
    public static UserDTO toUserDTO(User user) {
        if (user == null) return null;
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());

        // If roles are comma-separated String, split to List
        if (user.getRoles() != null) {
            List<String> rolesList = Arrays.asList(user.getRoles().split(","));
            dto.setRoles(rolesList);
        } else {
            dto.setRoles(Collections.emptyList());
        }
        return dto;
    }

    public static User fromUserDTO(UserDTO dto) {
        if (dto == null) return null;
        User user = new User();
        user.setId(dto.getId());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());

        // Convert List<String> to comma-separated String
        if (dto.getRoles() != null && !dto.getRoles().isEmpty()) {
            String rolesStr = String.join(",", dto.getRoles());
            user.setRoles(rolesStr);
        } else {
            user.setRoles("");
            user.setRoles("");
        }
        return user;
    }
}