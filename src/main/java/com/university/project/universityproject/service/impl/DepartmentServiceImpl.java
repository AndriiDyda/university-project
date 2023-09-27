package com.university.project.universityproject.service.impl;

import com.university.project.universityproject.entity.Department;
import com.university.project.universityproject.entity.Lector;
import com.university.project.universityproject.exception.DepartmentNotFoundException;
import com.university.project.universityproject.repository.DepartmentRepository;
import com.university.project.universityproject.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.Scanner;

import static java.util.stream.Collectors.*;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private static final String WHO_IS_HEAD_OF_DEPARTMENT = "Head of %s department is %s";
    private static final String DEPARTMENT_STATISTIC_MESSAGE = "%s - %d";
    private static final String AVG_SALARY_MESSAGE = "The average salary of %s is %f";
    private static final String NUMBER_OF_EMPLOYEE = "%d employee work in %s department";
    private static final String INPUT_DEPARTMENT_MESSAGE = "Input department name:";
    private static final String INPUT_TEMPLATE_MESSAGE = "Input template:";
    private final DepartmentRepository departmentRepository;
    private Scanner userInput = new Scanner(System.in);
    private static final String USER_MESSAGE = "Input department name:";


    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public String getHeadOfDepartment() {
        String departmentName = getUserInput(USER_MESSAGE);
        return getDepartmentByName(departmentName).getLector().getName();
    }

    @Override
    public String countLectors() {
        String departmentName = getUserInput(USER_MESSAGE);
        return departmentRepository.countLectorsByName(departmentName).toString();
    }

    @Override
    public String getDepartmentStatistics() {
        String departmentName = getUserInput(USER_MESSAGE);
        Department department = getDepartmentByName(departmentName);
        return department.getLectors().stream()
                .collect(groupingBy(Lector::getDegree, counting()))
                .entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(joining("\n"));
    }
    private String getUserInput(String input) {
        System.out.println(input);
        return userInput.nextLine();
    }
    private Department getDepartmentByName(String name){
        try {
            return departmentRepository.findByName(name).orElseThrow(() -> new DepartmentNotFoundException("There is no department with such a name"));
        } catch (DepartmentNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
