package com.university.project.universityproject.repository;

import com.university.project.universityproject.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Optional<Department> findByName(String name);

    @Query(value = "SELECT count(l.name) FROM t_department d " +
            "INNER JOIN lector_department ld ON d.department_id = ld.department_id " +
            "INNER JOIN t_lector l ON l.lector_id = ld.lector_id " +
            "WHERE d.name = :name",
            nativeQuery = true)
    Long countLectorsByName(String name);
}

