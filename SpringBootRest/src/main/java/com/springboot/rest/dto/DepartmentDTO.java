package com.springboot.rest.dto;

import com.springboot.rest.entities.Employee;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Data
//@Validated
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDTO {

    private Long id;

    @NotBlank
    @Size(min = 2, max = 20)
    private String name;

    @NotBlank
    @Size(min = 2, max = 50)
    private String city;

    private List<Employee> employees;
}
