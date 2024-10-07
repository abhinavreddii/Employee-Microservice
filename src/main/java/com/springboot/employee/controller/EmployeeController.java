package com.springboot.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee.model.Employee;
import com.springboot.employee.service.EmployeeService;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeservice;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/getEmployeeSalary/{id}")
    public ResponseEntity<String> getEmployeeSalary(@PathVariable String id) {
        String salaryServiceUrl = "http://localhost:8099/salary/find/" + id;
        try {
            ResponseEntity<String> response = restTemplate.getForEntity(salaryServiceUrl, String.class);
            return response;
        } catch (Exception e) {
            // Log the error details
            System.err.println("Error fetching salary: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error fetching salary");
        }
    }

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeservice.saveEmployee(employee);
    }

    @GetMapping("/findAll")
    public List<Employee> findAllEmployees() {
        return employeeservice.findAllEmployees();
    }

    @GetMapping("/findById/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeservice.findById(id);
    }

    @PutMapping("/update/{id}")
    public Employee updateById(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setEmployeeId(id);
        return employeeservice.updateById(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeservice.deleteEmployee(id);
    }

}
