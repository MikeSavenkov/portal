package com.fides.portal.controller;

import com.fides.portal.domain.Employee;
import com.fides.portal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Map;

@Controller
public class MainController {

    private final EmployeeService employeeService;
    @Autowired
    public MainController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        return "main";
    }
    @GetMapping("/employees")
    public String findAll(Map<String, Object> model) {
        List<Employee> employees = employeeService.findAll();
        model.put("employees", employees);
        return "employee-list";
    }

    @GetMapping("/employee-create")
    public String createEmployeeForm(Employee employee) {
        return "employee-create";
    }

    @PostMapping("/employee-create")
    public String createEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("employee-delete/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteById(id);
        return "redirect:/employees";
    }

    @GetMapping("employee-update/{id}")
    public String updateEmployeeForm(@PathVariable("id") Long id, Map<String, Object> model) {
        Employee employee = employeeService.findById(id);
        model.put("employee", employee);
        return "/employee-update";
    }

    @PostMapping("/employee-update")
    public String updateEmployee(Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

}
