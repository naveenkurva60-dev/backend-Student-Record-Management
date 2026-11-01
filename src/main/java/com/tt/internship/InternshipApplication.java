package com.tt.internship;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "internship_applications")
public class InternshipApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Student name is required")
    @Column(name = "student_name", nullable = false)
    private String studentName;

    @NotBlank(message = "Student roll number is required")
    @Column(name = "roll_number", nullable = false)
    private String rollNumber;

    @NotBlank(message = "Company name is required")
    @Column(name = "company_name", nullable = false)
    private String companyName;

    @NotBlank(message = "Status is required")
    @Column(name = "status", nullable = false)
    private String status;

    public InternshipApplication() {
    }

    public InternshipApplication(String studentName, String rollNumber, String companyName, String status) {
        this.studentName = studentName;
        this.rollNumber = rollNumber;
        this.companyName = companyName;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
