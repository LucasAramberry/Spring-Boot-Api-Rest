package com.springboot.rest.dto;

import com.springboot.rest.entities.Department;
import com.springboot.rest.enums.Gender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private byte age;
    private Gender gender;
    private LocalDate dateOfBirth;
    private LocalDate dateOfAdmission;
    private BigDecimal salary;
    private Department department;
}
