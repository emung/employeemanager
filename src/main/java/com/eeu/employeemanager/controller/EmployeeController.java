package com.eeu.employeemanager.controller;

import com.eeu.employeemanager.model.EmployeeModel;
import com.eeu.employeemanager.service.EmployeeService;
import lombok.RequiredArgsConstructor;
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

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<List<EmployeeModel>> getAllEmployees() {
        List<EmployeeModel> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable("id") Long id) {
        EmployeeModel employee = employeeService.findEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeModel> addEmployee(@RequestBody EmployeeModel employeeModel) {
        EmployeeModel newEmployee = employeeService.addEmployee(employeeModel);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<EmployeeModel> updateEmployee(@RequestBody EmployeeModel employeeModel) {
        EmployeeModel updateEmployee = employeeService.updateEmployee(employeeModel);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
