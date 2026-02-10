package com.example.employeepayroll.controller;

import com.example.employeepayroll.model.Employee;
import com.example.employeepayroll.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    //Get all employees
    @GetMapping("/")
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> employees = service.getAll();
        return ResponseEntity.ok(employees);
    }

    //Get employee by ID
    @GetMapping("/get/{id}")
    public ResponseEntity<Employee> getOne(@PathVariable Long id) {
        Employee emp = service.getById(id);
        return ResponseEntity.ok(emp);
    }

    //Create a new employee
    @PostMapping("/create")
    public ResponseEntity<Employee> create(
            @Valid @RequestBody Employee employee) {

        Employee saved = service.create(employee);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(saved);
    }

    //Update an existing employee
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> update(
            @PathVariable Long id,
            @Valid @RequestBody Employee employee) {

        Employee updated = service.update(id, employee);
        return ResponseEntity.ok(updated);
    }

    //Delete employee by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {

        service.delete(id);

        return ResponseEntity.ok("Employee deleted successfully");
    }
}
