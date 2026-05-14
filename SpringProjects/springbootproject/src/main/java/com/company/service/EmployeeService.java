package com.company.service;

import com.company.bean.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployeeById(String id);

    Employee updateEmployee(String id, Employee employee);

    void deleteEmployee(String id);
}