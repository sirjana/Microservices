package com.example.client.service.impl;

import com.example.client.client.AddressClient;
import com.example.client.entity.Employee;
import com.example.client.repository.EmployeeRepository;
import com.example.client.response.AddressResponse;
import com.example.client.response.EmployeeResponse;
import com.example.client.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper mapper;
    private AddressClient addressClient;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ModelMapper mapper, AddressClient addressClient) {
        this.employeeRepository = employeeRepository;
        this.mapper = mapper;
        this.addressClient = addressClient;
    }

    public EmployeeResponse getEmployeeById(int id) {

        Optional<Employee> employee = employeeRepository.findById(id);
        EmployeeResponse employeeResponse = mapper.map(employee, EmployeeResponse.class);

        // Using FeignClient
        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
        employeeResponse.setAddressResponse(addressResponse.getBody());

        return employeeResponse;
    }
}
