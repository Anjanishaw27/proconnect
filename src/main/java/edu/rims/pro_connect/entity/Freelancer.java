package edu.rims.pro_connect.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

// import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "freelancer")
@PrimaryKeyJoinColumn(name = "user_id") // Inherits primary key from User
public class Freelancer extends User {

    @Column(name = "rating")
    private Double rating;

    @Column(name = "language", length = 100)
    private String language;

    @Column(name = "completed_projects", columnDefinition = "INT DEFAULT 0")
    private int completedProjects;

    @Column(name = "total_clients", columnDefinition = "INT DEFAULT 0")
    private int totalClients;

    @Column(name = "years_experience")
    private int yearsExperience;

    @Column(name = "specialization", columnDefinition = "TEXT")
    private String specialization;

    @Column(name = "skills", columnDefinition = "TEXT")
    private String skills;
}
