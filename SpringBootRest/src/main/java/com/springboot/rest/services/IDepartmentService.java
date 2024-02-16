package com.springboot.rest.services;

import com.springboot.rest.entities.Department;

import java.util.List;
import java.util.Optional;

public interface IDepartmentService {

    List<Department> findAll();

    Optional<Department> findById(Long id);

    void save(Department department);

    void deleteById(Long id);
}
