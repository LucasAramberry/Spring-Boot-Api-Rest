package com.springboot.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Departamento")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "ciudad")
    private String city;

    @OneToMany(targetEntity = Employee.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "department", orphanRemoval = true)
    @JsonIgnore
    private List<Employee> employees;
}
