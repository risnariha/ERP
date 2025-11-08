package com.erp.ERP.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Student {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@NotBlank(message = "Student ID is required")
@Column(unique = true, nullable = false)
private String studentId;

@NotBlank(message = "First name is required")
private String firstName;

@NotBlank(message = "Last name is required")
private String lastName;

@Email(message = "Invalid email format")
@Column(unique = true)
private String email;

@Pattern(regexp = "^[0-9]{10}$", message = "Phone number must be 10 digits")
private String phone;

private LocalDate dateOfBirth;

@Enumerated(EnumType.STRING)
private Gender gender;

private String address;

private String city;

private String state;

@Pattern(regexp = "^[0-9]{6}$", message = "Pincode must be 6 digits")
private String pincode;

@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "department_id")
private Department department;

private String semester;

private LocalDate admissionDate;

@Enumerated(EnumType.STRING)
private StudentStatus status;

private String profilePhoto;

@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
private Set<Enrollment> enrollments;

@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
private Set<Attendance> attendances;

@CreationTimestamp
private LocalDate createdAt;

@UpdateTimestamp
private LocalDate updatedAt;
}

enum Gender {
    MALE, FEMALE, OTHER
}

enum StudentStatus {
    ACTIVE, INACTIVE, GRADUATED, SUSPENDED
}
