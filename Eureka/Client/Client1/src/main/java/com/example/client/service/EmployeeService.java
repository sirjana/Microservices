package com.example.client.service;

import com.example.client.entity.Employee;
import com.example.client.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    public EmployeeResponse getEmployeeById(int id);

//    List<Employee> findAll();
//
//    Employee findById(int id);
//    Employee save(Employee employee);
//
//    Employee update(int id, Employee employee);
//
//    void deleteById(int id);

}
