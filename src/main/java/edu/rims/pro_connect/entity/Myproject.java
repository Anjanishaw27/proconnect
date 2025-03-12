package edu.rims.pro_connect.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Myproject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "project_name", nullable = false)
    private String projectName;

    @Column(name = "client", nullable = false)
    private String client;

    @Column(name = "deadline")
    private LocalDate deadline;

    @Column(name = "status")
    private String status;

    @Column(name = "actions")
    private String actions;
}

