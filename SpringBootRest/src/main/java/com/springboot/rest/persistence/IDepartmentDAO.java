package com.springboot.rest.persistence;

import com.springboot.rest.entities.Department;

import java.util.List;
import java.util.Optional;

public interface IDepartmentDAO {

    List<Department> findAll();

    Optional<Department> findById(Long id);

    void save(Department department);

    void deleteById(Long id);
}
