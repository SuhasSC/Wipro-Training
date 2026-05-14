package com.company.service;

import com.company.bean.Employee;
import com.company.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    @Override
    public Employee createEmployee(Employee employee) {

        return employeeRepo.save(employee);
    }
}