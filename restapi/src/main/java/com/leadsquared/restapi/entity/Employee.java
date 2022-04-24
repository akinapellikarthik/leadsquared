package com.leadsquared.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "employee", uniqueConstraints = {
        @UniqueConstraint(name = "uk_empcode", columnNames = "employee_code")
})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @Column(name = "employee_code")
    private String employeeCode;

    @OneToMany(mappedBy = "departmentCode")
    private Set<Department> department = new HashSet<>();

    @OneToMany(mappedBy = "projectCode")
    private Set<Project> project = new HashSet<>();


}
