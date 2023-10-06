package com.eeu.employeemanager.service;

import com.eeu.employeemanager.exception.UserNotFoundException;
import com.eeu.employeemanager.model.EmployeeModel;
import com.eeu.employeemanager.repo.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeModel addEmployee(EmployeeModel employeeModel) {
        employeeModel.setEmployeeCode(UUID.randomUUID().toString());
        return employeeRepository.save(employeeModel);
    }

    public List<EmployeeModel> findAllEmployees() {
        return employeeRepository.findAll();
    }

    public EmployeeModel updateEmployee(EmployeeModel employeeModel) {
        return employeeRepository.save(employeeModel);
    }

    public EmployeeModel findEmployeeById(Long id) {
        return employeeRepository.findEmployeeById(id)
            .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteEmployeeById(id);
    }

}
