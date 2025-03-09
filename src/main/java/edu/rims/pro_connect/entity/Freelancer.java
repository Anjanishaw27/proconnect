package edu.rims.pro_connect.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "freelancer")
@Getter
@Setter

public class Freelancer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "freelancer_id")
    private long freelancerId;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "full_name", length = 255)
    private String fullName;

    @Column(name = "rating")
    private Double rating;

    @Column(name = "location", length = 255)
    private String location;

    @Column(name = "language", length = 100)
    private String language;

    @Column(name = "completed_projects", columnDefinition = "INT DEFAULT 0")
    private Integer completedProjects;

    @Column(name = "total_clients", columnDefinition = "INT DEFAULT 0")
    private Integer totalClients;

    @Column(name = "years_experience")
    private Integer yearsExperience;

    @Column(name = "specialization", columnDefinition = "TEXT")
    private String specialization;

    @Column(name = "skills", columnDefinition = "TEXT")
    private String skills;

    @Column(name = "profile_description", columnDefinition = "TEXT")
    private String profileDescription;

    @Column(name = "profile_picture", length = 255)
    private String profilePicture;

    @Column(name = "joined_date")
    @Temporal(TemporalType.DATE)
    private Date joinedDate;


}

