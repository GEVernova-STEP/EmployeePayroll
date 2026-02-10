package com.example.employeepayroll.service;

import com.example.employeepayroll.exception.ResourceNotFoundException;
import com.example.employeepayroll.model.Employee;
import com.example.employeepayroll.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repo;

    //Get all employee
    public List<Employee> getAll() {
        return repo.findAll();
    }

    //Get employee by id
    public Employee getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee not found: " + id));
    }

    //Create employee
    public Employee create(Employee employee) {
        return repo.save(employee);
    }

    //Update employee
    public Employee update(Long id, Employee employee) {
        Employee existing = getById(id);
        existing.setName(employee.getName());
        existing.setSalary(employee.getSalary());
        return repo.save(existing);
    }

    //Delete Employee
    public void delete(Long id) {
        repo.delete(getById(id));
    }
}
