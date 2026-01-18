package com.example.employee.employee.packages.controller;

import com.example.employee.employee.packages.model.Employees;
import com.example.employee.employee.packages.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/v1/api/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping("/allemployees")
    public List<Employees> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/allemployees/{id}")
    public Optional<Employees> getEmployeeById(@PathVariable Long id){
        return employeeService.getEmployeeById(id);
    }

    @PostMapping("/saveEmployees")
    public List<Employees> saveAllEmployees(@RequestBody List<Employees> employees){
        employees.forEach(e -> System.out.println(e));
        return employeeService.saveAllEmployees(employees);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deletedEmployee(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/updateEmployees/{id}")
    public Employees updateEmployee(@PathVariable Long id, @RequestBody Employees employee){
        employeeService.updateEmployee(employee, id);
        return employee;
    }

}

