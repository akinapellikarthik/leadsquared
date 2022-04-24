package com.leadsquared.restapi.controller;

import com.leadsquared.restapi.entity.Employee;
import com.leadsquared.restapi.service.impl.EmployeeServiceImpl;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EmployeeControllerTest {

    private final String projectCode = "TESTP101";
    private final String empId = "TESTE101";

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private EmployeeController employeeController;

    private MockMvc mockMvc;

    @BeforeAll
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
    }

    @Test
    @SneakyThrows
    void verifyEmployeesInProjectReturnsEmployeeList() {
        Mockito.when(employeeService.getAllEmployees(projectCode)).thenReturn(Collections.emptyList());
        String url = String.format("/v1/api/%s/employees", projectCode);
        mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    @SneakyThrows
    void verifyDisassociateEmployeeWillDisassociateEmployee() {
        Employee e = Employee.builder().build();
        Mockito.when(employeeService.disassociateEmployee(projectCode, empId)).thenReturn(e);
        String url = String.format("/v1/api/%s/%s", projectCode, empId);

        mockMvc.perform(MockMvcRequestBuilders.delete(url).content(String.valueOf(MediaType.APPLICATION_JSON)))
                .andExpect(MockMvcResultMatchers.status().is(HttpStatus.NO_CONTENT.value()));

    }
}