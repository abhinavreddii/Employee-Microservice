package com.springboot.employee.service;

import java.util.List;
import com.springboot.employee.model.Employee;
public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> findAllEmployees();
    Employee findById(Long id);
    Employee updateById(Employee employee);
    void deleteEmployee(Long id);
}
