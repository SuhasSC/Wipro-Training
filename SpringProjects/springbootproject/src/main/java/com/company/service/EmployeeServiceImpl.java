package com.company.service;

import com.company.bean.Employee;
import com.company.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Employee createEmployee(Employee employee) {

        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {

        return employeeRepo.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(String id) {

        return employeeRepo.findById(id);
    }

    @Override
    public Employee updateEmployee(String id, Employee employee) {

        Optional<Employee> empOptional = employeeRepo.findById(id);

        if (empOptional.isPresent()) {

            Employee existingEmployee = empOptional.get();

            existingEmployee.setFirstname(
                    employee.getFirstname());

            return employeeRepo.save(
                    existingEmployee);
        }

        return null;
    }

    @Override
    public void deleteEmployee(String id) {

        employeeRepo.deleteById(id);
    }
}