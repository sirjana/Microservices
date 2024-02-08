package com.example.client.controller;

import com.example.client.client.EmployeeClient;
import com.example.client.entity.Department;
import com.example.client.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("send-sms")
    public String SendSMS(){
        return "sending sms";
    }

    @GetMapping("hello")
    public String Hello(){
        return "Hello departments";
    }

    @PostMapping("create")
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
        Department savedDepartment = departmentService.saveDepartment(department);
        return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
    }

    @GetMapping("departments/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long departmentId){
        Department department = departmentService.getDepartmentById(departmentId);
        return new ResponseEntity<>(department,HttpStatus.OK);
    }
   @GetMapping("/getAll")
    public ResponseEntity<List<Department>> getAllDepartment() {
      List<Department> departments = departmentService.getAllDepartments();
      return new ResponseEntity<>(departments,HttpStatus.OK);
   }

   @PutMapping("/update")
    public ResponseEntity<Department> updateDepartment(@RequestBody Department department){
        Department departments = departmentService.updateDepartment(department);
        return new ResponseEntity<>(departments,HttpStatus.OK);
   }
}























