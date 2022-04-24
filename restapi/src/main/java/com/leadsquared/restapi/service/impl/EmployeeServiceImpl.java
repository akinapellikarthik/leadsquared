package com.leadsquared.restapi.service.impl;

import com.leadsquared.restapi.entity.Department;
import com.leadsquared.restapi.entity.Employee;
import com.leadsquared.restapi.entity.Project;
import com.leadsquared.restapi.repository.EmployeeRepository;
import com.leadsquared.restapi.repository.IProjectRepository;
import com.leadsquared.restapi.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final IProjectRepository projectRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, IProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }


    @Override
    public List<Employee> getAllEmployees(String projectId) {

        //using ProjectId grab the department code
        Project p1;
        var projectIdInfo = projectRepository.findById(projectId);
        if (projectIdInfo.isPresent())
            p1 = projectIdInfo.get();
        else
            throw new RuntimeException("projectId doesn't exist in System");

        List<Department> deptCodeStream = new ArrayList<>(p1.getDepartments());
        return employeeRepository.findEmployeeByDepartmentIn(deptCodeStream);


    }

    @Override
    public Employee disassociateEmployee(String projectId, String empId) {
        Optional<Employee> employee = employeeRepository.findById(empId);
        Employee e;
        if (employee.isPresent())
            e = employee.get();
        else
            throw new RuntimeException("empId doesn't exist in System");
        e.setProject(null);
        e.setDepartment(null);
        return employeeRepository.save(e);
    }
}
