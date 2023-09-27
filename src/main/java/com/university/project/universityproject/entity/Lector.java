package com.university.project.universityproject.entity;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "t_lector")
public class Lector {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lectorId;

    private String name;
    private double salary;
    @Enumerated(EnumType.STRING)
    private Degree degree;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "lector_department",
            joinColumns = @JoinColumn(
                    name = "lector_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "department_id")
    )
    private Set<Department> departments = new HashSet<>();

    public int getLectorId() {
        return lectorId;
    }

    public void setLectorId(int lectorId) {
        this.lectorId = lectorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    @Override
    public String toString() {
        return "Lector{" +
                "name='" + name + '\'' +
                '}';
    }
}
