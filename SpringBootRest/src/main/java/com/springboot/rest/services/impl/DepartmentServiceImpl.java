package com.springboot.rest.services.impl;

import com.springboot.rest.entities.Department;
import com.springboot.rest.persistence.IDepartmentDAO;
import com.springboot.rest.services.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentServiceImpl implements IDepartmentService {

    @Autowired
    private IDepartmentDAO departmentDAO;

    @Transactional(readOnly = true)//Indicamos que solo realiza lectura
    @Override
    public List<Department> findAll() {
        return (List<Department>) departmentDAO.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<Department> findById(Long id) {
        return departmentDAO.findById(id);
    }

    @Transactional
    @Override
    public void save(Department department) {
        departmentDAO.save(department);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        departmentDAO.deleteById(id);
    }
}
