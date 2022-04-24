package com.leadsquared.restapi.repository;

import com.leadsquared.restapi.entity.Department;
import com.leadsquared.restapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    List<Employee> findEmployeeByDepartmentIn(List<Department> department);
}
