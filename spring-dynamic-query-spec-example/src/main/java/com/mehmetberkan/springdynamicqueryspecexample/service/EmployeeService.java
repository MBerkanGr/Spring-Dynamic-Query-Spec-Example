package com.mehmetberkan.springdynamicqueryspecexample.service;

import com.mehmetberkan.springdynamicqueryspecexample.model.Employee;
import com.mehmetberkan.springdynamicqueryspecexample.repository.EmployeeRepository;
import com.mehmetberkan.springdynamicqueryspecexample.specification.EmployeeSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees(String name, String department, Double salary) {
        Specification<Employee> spec = Specification.where(EmployeeSpecification.hasName(name))
                .and(EmployeeSpecification.hasDepartment(department))
                .and(EmployeeSpecification.hasSalaryGreaterThan(salary));

        return employeeRepository.findAll(spec);
    }
}
