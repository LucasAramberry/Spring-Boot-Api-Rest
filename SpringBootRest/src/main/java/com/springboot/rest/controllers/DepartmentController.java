package com.springboot.rest.controllers;

import com.springboot.rest.dto.DepartmentDTO;
import com.springboot.rest.entities.Department;
import com.springboot.rest.services.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/department")
public class DepartmentController {

    @Autowired
    private IDepartmentService iDepartmentService;

    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Department> departmentOptional = iDepartmentService.findById(id);

        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();

            DepartmentDTO departmentDTO = DepartmentDTO.builder()
                    .id(department.getId())
                    .name(department.getName())
                    .city(department.getCity())
                    .employees(department.getEmployees())
                    .build();

            return ResponseEntity.ok(departmentDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {

        List<DepartmentDTO> departmentDTOList = iDepartmentService
                .findAll()
                .stream()
                .map(department -> DepartmentDTO.builder()
                        .id(department.getId())
                        .name(department.getName())
                        .city(department.getCity())
                        .employees(department.getEmployees())
                        .build()).toList();

        return ResponseEntity.ok(departmentDTOList);
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody DepartmentDTO departmentDTO) throws URISyntaxException {

        iDepartmentService.save(Department.builder()
                .name(departmentDTO.getName())
                .city(departmentDTO.getCity())
                .build());

        return ResponseEntity.created(new URI("/api/v1/department/save")).build();

        //            return ResponseEntity.badRequest().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody DepartmentDTO departmentDTO) {

        Optional<Department> departmentOptional = iDepartmentService.findById(id);

        if (departmentOptional.isPresent()) {
            Department department = departmentOptional.get();

            department.setName(departmentDTO.getName());
            department.setCity(departmentDTO.getCity());

            iDepartmentService.save(department);

            return ResponseEntity.ok("Departamento actualizado");
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> update(@PathVariable Long id) {

        if (id != null) {
            iDepartmentService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.badRequest().body("Parametro id vacío");
    }
}
