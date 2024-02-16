package com.springboot.rest.services;

import com.springboot.rest.entities.Employee;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {

    List<Employee> findAll();

    Optional<Employee> findById(Long id);

    void save(Employee employee);

    void deleteById(Long id);
}
