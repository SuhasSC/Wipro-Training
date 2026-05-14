package com.company.controller;

import com.company.bean.Employee;
import com.company.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("empapi")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(
            @RequestBody Employee employee) {

        Employee emp = employeeService.createEmployee(employee);

        return new ResponseEntity<>(
                emp,
                HttpStatus.OK);
    }

    @GetMapping("/viewall")
    public ResponseEntity<List<Employee>> getAllEmployees() {

        List<Employee> employees = employeeService.getAllEmployees();

        return new ResponseEntity<>(
                employees,
                HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> getEmployeeById(
            @PathVariable String id) {

        Optional<Employee> emp = employeeService.getEmployeeById(id);

        if (emp.isPresent()) {

            return new ResponseEntity<>(
                    emp.get(),
                    HttpStatus.OK);
        }

        return new ResponseEntity<>(
                "Employee Not Found",
                HttpStatus.NOT_FOUND);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateEmployee(
            @PathVariable String id,
            @RequestBody Employee employee) {

        Employee updatedEmployee = employeeService.updateEmployee(
                id,
                employee);

        if (updatedEmployee != null) {

            return new ResponseEntity<>(
                    updatedEmployee,
                    HttpStatus.OK);
        }

        return new ResponseEntity<>(
                "Employee Not Found",
                HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEmployee(
            @PathVariable String id) {

        employeeService.deleteEmployee(id);

        return new ResponseEntity<>(
                "Employee Deleted Successfully",
                HttpStatus.OK);
    }
}