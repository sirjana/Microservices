package com.example.client.service.impl;

import com.example.client.entity.Department;
import com.example.client.repository.DepartmentRepository;
import com.example.client.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class DepartmentServiceImpl implements DepartmentService {

    DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }


    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }
    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }

    @Override
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll().stream().collect(Collectors.toList());
    }

    @Override
    public Department updateDepartment(Department department) {
        Department departments = departmentRepository.findById(department.getId()).get();
        departments.setDepartmentName(department.getDepartmentName());
        departments.setDepartmentAddress(department.getDepartmentAddress());
        departments.setDepartmentCode(department.getDepartmentCode());
        return departmentRepository.save(departments);
    }
}
