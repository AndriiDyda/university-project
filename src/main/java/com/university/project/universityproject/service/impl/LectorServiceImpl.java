package com.university.project.universityproject.service.impl;

import com.university.project.universityproject.entity.Lector;
import com.university.project.universityproject.repository.LectorRepository;
import com.university.project.universityproject.service.LectorService;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class LectorServiceImpl implements LectorService {
    private final LectorRepository lectorRepository;
    private Scanner userInput = new Scanner(System.in);

    public LectorServiceImpl(LectorRepository lectorRepository) {
        this.lectorRepository = lectorRepository;
    }

    @Override
    public String findAvgSalary() {
        String departmentName = getUserInput("Input department name:");
        return lectorRepository.findAvgSalary(departmentName).toString();
    }

    @Override
    public String searchByTemplate() {
        String template = getUserInput("Input template:");
        return lectorRepository.findByNameContaining(template).stream()
                .map(Lector::getName).toList().toString();
    }

    private String getUserInput(String input) {
        System.out.println(input);
        return userInput.nextLine();
    }

}

