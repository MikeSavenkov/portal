package com.fides.portal.controller;

import com.fides.portal.domain.Employee;
import com.fides.portal.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class MainController {

    @Autowired
    private EmployeeRepo employeeRepo;

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {
        return "greeting";
    }
    @GetMapping("/main")
    public String main(Map<String, Object> model) {
        Iterable<Employee> employees = employeeRepo.findAll();

        model.put("employees", employees);
        return "main";
    }

    @PostMapping("/main")
    public String add(@RequestParam String name, @RequestParam String surname, Map<String, Object> model) {
        Employee employee = new Employee(name, surname);
        employeeRepo.save(employee);

        Iterable<Employee> employees = employeeRepo.findAll();
        model.put("employees", employees);

        return "main";
    }

    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Employee> employees;

        if (filter != null && !filter.isEmpty()) {
            employees = employeeRepo.findBySurname(filter);
        } else {
            employees = employeeRepo.findAll();
        }

        model.put("employees", employees);
        return "main";
    }

}
