package com.leadsquared.restapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "department", uniqueConstraints = {
        @UniqueConstraint(name = "uk_department_code", columnNames = "department_code")
})
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Department {

    @Id
    @Column(name = "department_code")
    private String departmentCode;

    @OneToMany(mappedBy = "projectCode", fetch = FetchType.EAGER)
    private Set<Project> project = new HashSet<>();
}
