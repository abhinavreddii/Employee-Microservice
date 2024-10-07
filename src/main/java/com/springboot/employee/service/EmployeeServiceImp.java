package com.springboot.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.employee.model.Employee;
import com.springboot.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{

    @Autowired
    EmployeeRepository employeerepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeerepository.save(employee);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return employeerepository.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeerepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateById(Employee employee) {
        return employeerepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeerepository.deleteById(id);
    }
}
