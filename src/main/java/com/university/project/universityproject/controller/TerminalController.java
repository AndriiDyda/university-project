package com.university.project.universityproject.controller;

import com.university.project.universityproject.service.DepartmentService;
import com.university.project.universityproject.service.LectorService;
import com.university.project.universityproject.utills.UserCommands;
import jakarta.annotation.PostConstruct;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import java.util.*;

@Controller
public class TerminalController implements CommandLineRunner {
    private final static String USER_CHOICE = """
            Select the desired command:
            1) Who is head of department;
            2) Show department statistics;
            3) Show the average salary for the department;
            4) Show count of employee for the department;
            5) Global search by template
            """;
    private final static String INVALID_INPUT = "Choose between 1-5";
    private final DepartmentService departmentService;
    private final LectorService lectorService;
    private Scanner userInput = new Scanner(System.in);
    private Map<String, UserCommands> commandsMap;

    public TerminalController(DepartmentService departmentService, LectorService lectorService) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }
    @PostConstruct
    private void fillCommandsMap() {
        commandsMap = new HashMap<>();
        commandsMap.put("1", UserCommands.HEAD_OF_DEPARTMENT);
        commandsMap.put("2", UserCommands.STATISTICS_FOR_DEPARTMENT);
        commandsMap.put("3", UserCommands.AVERAGE_EMPLOYEE_SALARY_FOR_DEPARTMENT);
        commandsMap.put("4", UserCommands.COUNT_OF_EMPLOYEE_FOR_DEPARTMENT);
        commandsMap.put("5", UserCommands.GLOBAL_EMPLOYEE_SEARCH);
    }
    @Override
    public void run(String... args) {
        System.out.println(USER_CHOICE);
        System.out.println(readUserChoice() + "\n");
        run(args);
    }
    private String readUserChoice(){
        Optional<UserCommands> userChoiceOptional = Optional.ofNullable(commandsMap.get(userInput.next()));
        if(userChoiceOptional.isPresent())
            return choseCommand(userChoiceOptional.get());
        else {
            return INVALID_INPUT;
        }
    }
    private String choseCommand(UserCommands commands) {
        switch (commands){
            case HEAD_OF_DEPARTMENT:
                return departmentService.getHeadOfDepartment();
            case STATISTICS_FOR_DEPARTMENT:
                return departmentService.getDepartmentStatistics();
            case AVERAGE_EMPLOYEE_SALARY_FOR_DEPARTMENT:
                return lectorService.findAvgSalary();
            case COUNT_OF_EMPLOYEE_FOR_DEPARTMENT:
                return departmentService.countLectors();
            case GLOBAL_EMPLOYEE_SEARCH:
                return lectorService.searchByTemplate();
            default:
                return INVALID_INPUT;
        }
    }
}
