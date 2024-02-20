package com.springboot.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.rest.enums.Gender;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Empleado")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "apellido")
    private String lastname;

    private String email;

    @Column(name = "telefono")
    private String phone;

    @Column(name = "edad")
    private byte age;

    @Column(name = "genero")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfBirth;

    @Column(name = "fecha_ingreso")
    @Temporal(TemporalType.DATE)
    private LocalDate dateOfAdmission;

    @Column(name = "salario")
    private BigDecimal salary;

    @ManyToOne(targetEntity = Department.class)
    @JoinColumn(name = "id_departamento", nullable = false)
    @JsonIgnore
    private Department department;

}
