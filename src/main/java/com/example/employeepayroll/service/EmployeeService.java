package com.example.employeepayroll.service;

import com.example.employeepayroll.model.Employee;
import com.example.employeepayroll.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repo;

    public List<Employee> getAll() {
        return repo.findAll();
    }
}
