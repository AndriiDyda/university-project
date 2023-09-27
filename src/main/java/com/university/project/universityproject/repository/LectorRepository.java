package com.university.project.universityproject.repository;

import com.university.project.universityproject.entity.Lector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Set;

public interface LectorRepository extends JpaRepository<Lector, Integer> {
    @Query(value = "SELECT avg(l.salary) FROM t_lector l " +
            "INNER JOIN lector_department ld ON l.lector_id = ld.lector_id " +
            "INNER JOIN t_department d ON ld.department_id = d.department_id " +
            "WHERE d.name = :name",
            nativeQuery = true)
    Double findAvgSalary(@Param("name") String departmentName);

    Set<Lector> findByNameContaining(String template);

}
