package com.mehmetberkan.springdynamicqueryspecexample.controller;

import com.mehmetberkan.springdynamicqueryspecexample.model.Employee;
import com.mehmetberkan.springdynamicqueryspecexample.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees(@RequestParam(required = false) String name,
                                       @RequestParam(required = false) String department,
                                       @RequestParam(required = false) Double salary) {
        return employeeService.getEmployees(name, department, salary);
    }
}
