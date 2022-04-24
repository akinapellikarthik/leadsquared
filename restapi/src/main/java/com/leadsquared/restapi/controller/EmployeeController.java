package com.leadsquared.restapi.controller;

import com.leadsquared.restapi.entity.Employee;
import com.leadsquared.restapi.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/api")

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{projectId}/employees")
    public ResponseEntity<List<Employee>> employeesInProject(@PathVariable String projectId) {
        return new ResponseEntity<>(employeeService.getAllEmployees(projectId), HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}/{empId}")
    public ResponseEntity<Employee> disassociateEmployee(@PathVariable String projectId, @PathVariable String empId) {
        return new ResponseEntity<>(employeeService.disassociateEmployee(projectId, empId), HttpStatus.NO_CONTENT);
    }

}
