package com.example.client.service;

import com.example.client.entity.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);

    Department getDepartmentById(Long departmentId);

    List<Department> getAllDepartments();

    Department updateDepartment(Department department);

}
