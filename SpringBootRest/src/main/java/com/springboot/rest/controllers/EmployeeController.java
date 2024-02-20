package com.springboot.rest.controllers;

import com.springboot.rest.dto.EmployeeDTO;
import com.springboot.rest.entities.Employee;
import com.springboot.rest.services.IEmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Employee> employeeOptional = iEmployeeService.findById(id);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();

            EmployeeDTO employeeDTO = EmployeeDTO.builder()
                    .id(employee.getId())
                    .name(employee.getName())
                    .lastname(employee.getLastname())
                    .email(employee.getEmail())
                    .phone(employee.getPhone())
                    .age(employee.getAge())
                    .gender(employee.getGender())
                    .dateOfBirth(employee.getDateOfBirth())
                    .dateOfAdmission(employee.getDateOfAdmission())
                    .salary(employee.getSalary())
                    .department(employee.getDepartment())
                    .build();

            return ResponseEntity.ok(employeeDTO);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<EmployeeDTO> employeeDTOList = iEmployeeService
                .findAll()
                .stream()
                .map(employee -> EmployeeDTO.builder()
                        .id(employee.getId())
                        .name(employee.getName())
                        .lastname(employee.getLastname())
                        .email(employee.getEmail())
                        .phone(employee.getPhone())
                        .age(employee.getAge())
                        .gender(employee.getGender())
                        .dateOfBirth(employee.getDateOfBirth())
                        .dateOfAdmission(employee.getDateOfAdmission())
                        .salary(employee.getSalary())
                        .department(employee.getDepartment())
                        .build()).toList();
        return ResponseEntity.ok(employeeDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody @Valid EmployeeDTO employeeDTO) throws URISyntaxException {

        iEmployeeService.save(Employee.builder()
                .id(employeeDTO.getId())
                .name(employeeDTO.getName())
                .lastname(employeeDTO.getLastname())
                .email(employeeDTO.getEmail())
                .phone(employeeDTO.getPhone())
                .age(employeeDTO.getAge())
                .gender(employeeDTO.getGender())
                .dateOfBirth(employeeDTO.getDateOfBirth())
                .dateOfAdmission(employeeDTO.getDateOfAdmission())
                .salary(employeeDTO.getSalary())
                .department(employeeDTO.getDepartment())
                .build());

        return ResponseEntity.created(new URI("/api/v1/employee/save")).build();

//        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody EmployeeDTO employeeDTO) {

        Optional<Employee> employeeOptional = iEmployeeService.findById(id);

        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();

            employee.setName(employeeDTO.getName());
            employee.setLastname(employeeDTO.getLastname());
            employee.setEmail(employeeDTO.getEmail());
            employee.setPhone(employeeDTO.getPhone());
            employee.setAge(employeeDTO.getAge());
            employee.setGender(employeeDTO.getGender());
            employee.setDateOfBirth(employeeDTO.getDateOfBirth());
            employee.setDateOfAdmission(employeeDTO.getDateOfAdmission());
            employee.setSalary(employeeDTO.getSalary());
            employee.setDepartment(employeeDTO.getDepartment());

            iEmployeeService.save(employee);

            return ResponseEntity.ok("Empleado actualizado");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {

        if (id != null) {
            iEmployeeService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body("Parametro id vacío");
    }
}
