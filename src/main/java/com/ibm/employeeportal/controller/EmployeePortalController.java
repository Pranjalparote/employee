package com.ibm.employeeportal.controller;

import com.ibm.employeeportal.domain.Employee;
import com.ibm.employeeportal.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin("*")
@RestController
public class EmployeePortalController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @GetMapping("/employees")
    private List<Employee> getAllEmployees() {
        return employeeServiceImpl.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    private Employee getEmployee(@PathVariable("id") int id) {
        return employeeServiceImpl.getEmployeeById(id);
    }

    @DeleteMapping("/employees/{id}")
    private void deleteEmployee(@PathVariable("id") int id) {
      employeeServiceImpl.delete(id);
    }

    @PostMapping("/employees")
    private int saveEmployee(@RequestBody Employee employee) {
        employeeServiceImpl.saveOrUpdate(employee);
        return employee.getId();
    }
}

