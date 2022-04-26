package com.fides.portal.service;

import com.fides.portal.domain.Employee;
import com.fides.portal.repos.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee findById(Long id) {
        return employeeRepo.findById(id).orElse(null);
    }
    public List<Employee> findAll() {
        return (List<Employee>) employeeRepo.findAll();
    }
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    public void deleteById(Long id) {
        employeeRepo.deleteById(id);
    }
}
