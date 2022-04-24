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
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "project", uniqueConstraints = {
        @UniqueConstraint(name = "uk_project_code", columnNames = {"project_code"})
})
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    @Id
    @Column(name = "project_code")
    private String projectCode;

    @Column(unique = true)
    @OneToMany(mappedBy = "departmentCode")
    private List<Department> departments = new ArrayList<>();
}
