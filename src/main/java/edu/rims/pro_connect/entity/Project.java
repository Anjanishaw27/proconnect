package edu.rims.pro_connect.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "project")

public class Project {

    @Id
    @Column(name = "project_id", length = 255)
    private String projectId;

    @Column(name = "project_title", nullable = false, length = 255)
    private String projectTitle;

    @Column(name = "project_description", columnDefinition = "TEXT")
    private String projectDescription;

    @Column(name = "project_budget", nullable = false, precision = 10, scale = 2)
    private BigDecimal projectBudget;



    
}

