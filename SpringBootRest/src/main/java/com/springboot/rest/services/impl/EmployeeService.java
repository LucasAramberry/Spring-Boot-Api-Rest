package com.springboot.rest.services.impl;

import com.springboot.rest.entities.Employee;
import com.springboot.rest.persistence.IEmployeeDAO;
import com.springboot.rest.services.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    private IEmployeeDAO employeeDAO;

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) employeeDAO.findAll();
    }

    @Override
    public Optional<Employee> findById(Long id) {
        return employeeDAO.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public void deleteById(Long id) {
        employeeDAO.deleteById(id);
    }
}
