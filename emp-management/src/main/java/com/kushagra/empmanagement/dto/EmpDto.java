package com.kushagra.empmanagement.dto;

import jakarta.validation.constraints.*;
import java.time.LocalDate;

public class EmpDto {

    private Integer empId;

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 25, message = "Name must be between 3 and 25 characters")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "Only alphabets allowed")
    private String empName;

    @Min(value = 1000, message = "Salary must be at least 1000")
    @Max(value = 500000, message = "Salary must not exceed 500000")
    private Double empSal;

    @FutureOrPresent(message = "Date must be present or future")
    private LocalDate empDoj;

    @Pattern(regexp = "^(hr|production)$", message = "Only hr or production allowed")
    private String deptName;

  
    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getEmpSal() {
        return empSal;
    }

    public void setEmpSal(Double empSal) {
        this.empSal = empSal;
    }

    public LocalDate getEmpDoj() {
        return empDoj;
    }

    public void setEmpDoj(LocalDate empDoj) {
        this.empDoj = empDoj;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}