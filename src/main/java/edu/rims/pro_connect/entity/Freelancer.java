package edu.rims.pro_connect.entity;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "freelancer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "freelancer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ServiceRequest> serviceRequests;

    @OneToMany(mappedBy = "freelancer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<ProjectRequest> projectRequests;

    public void addServiceRequest(ServiceRequest request) {
        if (getServiceRequests() == null) {
            setServiceRequests(new ArrayList<>());
        }

        request.setFreelancer(this);
        getServiceRequests().add(request);
    }

    public void addProjects(Project project) {
        if (getProjects() == null) {
            setProjects(new ArrayList<>());
        }

        project.setFreelancer(this);
        getProjects().add(project);
    }

    public void addProjectRequest(ProjectRequest projectRequest) {
        if (getProjectRequests() == null) {
            setProjectRequests(new ArrayList<>());
        }
        getProjectRequests().add(projectRequest);
        projectRequest.setFreelancer(this);
    }
}
