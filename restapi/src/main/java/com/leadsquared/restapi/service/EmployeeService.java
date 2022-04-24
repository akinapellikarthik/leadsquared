package com.leadsquared.restapi.service;

import com.leadsquared.restapi.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployees(String projectId);

    Employee disassociateEmployee(String projectId, String empId);
}
