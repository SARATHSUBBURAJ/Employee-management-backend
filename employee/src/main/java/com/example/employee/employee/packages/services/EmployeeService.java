package com.example.employee.employee.packages.services;

import com.example.employee.employee.packages.model.Employees;
import com.example.employee.employee.packages.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeesRepository;

    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }

    public List<Employees> saveAllEmployees(List<Employees> employees) {

        return employeesRepository.saveAll(employees);
    }

    public void deletedEmployee(Long id){
        employeesRepository.deleteById(id);
    }

    public Employees updateEmployee(Employees updatedEmployee, Long id) {

        Employees existingEmployee = employeesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        existingEmployee.setFirstName(updatedEmployee.getFirstName());
        existingEmployee.setLastname(updatedEmployee.getLastname());
        existingEmployee.setSalary(updatedEmployee.getSalary());
        existingEmployee.setMobileNumber(updatedEmployee.getMobileNumber());
        existingEmployee.setAddress(updatedEmployee.getAddress());
        return employeesRepository.save(existingEmployee);
    }

    public Optional<Employees> getEmployeeById(Long id) {
        return employeesRepository.findById(id);
    }
}
