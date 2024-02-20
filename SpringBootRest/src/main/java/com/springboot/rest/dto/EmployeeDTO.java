package com.springboot.rest.dto;

import com.springboot.rest.advice.validation.anotation.ValidEmail;
import com.springboot.rest.advice.validation.anotation.ValidName;
import com.springboot.rest.entities.Department;
import com.springboot.rest.enums.Gender;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDTO {

    private Long id;

    @ValidName
    private String name;

    @NotBlank
    @Size(min = 3, max = 45)
    private String lastname;

    @ValidEmail
    private String email;

    @NotBlank
    @Size(min = 8, max = 16)
    private String phone;

    @Min(18)
    @Max(100)
    private byte age;

    @NotNull
    private Gender gender;

    @Past
    private LocalDate dateOfBirth;

    @PastOrPresent
    private LocalDate dateOfAdmission;

    @Digits(integer = 10, fraction = 2)
    private BigDecimal salary;

//    @Valid
    private Department department;
}
