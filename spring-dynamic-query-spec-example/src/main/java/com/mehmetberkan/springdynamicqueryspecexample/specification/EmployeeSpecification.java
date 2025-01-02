package com.mehmetberkan.springdynamicqueryspecexample.specification;

import com.mehmetberkan.springdynamicqueryspecexample.model.Employee;
import org.springframework.data.jpa.domain.Specification;

public class EmployeeSpecification {

    public static Specification<Employee> hasName(String name) {
        return (root, query, criteriaBuilder) ->
                name != null ? criteriaBuilder.like(root.get("name"), "%" + name + "%") : null;
    }

    public static Specification<Employee> hasDepartment(String department) {
        return (root, query, criteriaBuilder) ->
                department != null ? criteriaBuilder.equal(root.get("department"), department) : null;
    }

    public static Specification<Employee> hasSalaryGreaterThan(Double salary) {
        return (root, query, criteriaBuilder) ->
                salary != null ? criteriaBuilder.greaterThan(root.get("salary"), salary) : null;
    }

}
