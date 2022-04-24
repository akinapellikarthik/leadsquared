package com.leadsquared.restapi.service.impl;

import com.leadsquared.restapi.entity.Employee;
import com.leadsquared.restapi.entity.Project;
import com.leadsquared.restapi.repository.EmployeeRepository;
import com.leadsquared.restapi.repository.IProjectRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
class EmployeeServiceImplTest {

    private final String projectCode = "TESTP101";

    private final String empId = "TESTEMP101";

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Mock
    private IProjectRepository projectRepository;

    @AfterEach
    public void clearUp() {
        Mockito.clearInvocations(employeeRepository, projectRepository);
    }

    @Test
    public void verifyGetAllEmployeesReturnsEmployeeList() {
        Project project = Project.builder().projectCode(projectCode).departments(Collections.emptyList()).build();
        List<Employee> departmentList = Collections.emptyList();
        when(projectRepository.findById(projectCode)).thenReturn((Optional.of(project)));
        when(employeeRepository.findEmployeeByDepartmentIn(anyList())).thenReturn(departmentList);

        employeeService.getAllEmployees(projectCode);

        verify(projectRepository, times(1)).findById(projectCode);
    }

    @Test
    public void verifyGetAllEmployeesThrowsRunTimeException() {
        when(projectRepository.findById(projectCode)).thenReturn(Optional.empty());
        Assertions.assertThrows(RuntimeException.class, () -> employeeService.getAllEmployees((projectCode)));
    }

    @Test
    public void verifyDisassociateEmployeeWillDisassociate() {
        Employee e = Employee.builder().build();
        when(employeeRepository.findById(empId)).thenReturn(Optional.of(e));

        employeeService.disassociateEmployee(projectCode, empId);

        verify(employeeRepository, times(1)).save(any());
    }

    @Test
    public void verifyDisassociateEmployeeWillThrowsRunTimeException() {
        when(employeeRepository.findById(empId)).thenReturn(Optional.empty());
        Assertions.assertThrows(RuntimeException.class, () -> employeeService.disassociateEmployee(projectCode, empId));
    }


}