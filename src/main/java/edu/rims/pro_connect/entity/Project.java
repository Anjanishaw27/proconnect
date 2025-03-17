package edu.rims.pro_connect.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "project")
public class Project extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Generates UUID automatically
    @Column(name = "project_id", length = 36, updatable = false, nullable = false)
    private String projectId;

    @Column(name = "project_title", nullable = false, length = 255)
    private String projectTitle;

    @Column(name = "project_description", columnDefinition = "TEXT")
    private String projectDescription;

    @Column(name = "project_image_url", length = 250)
    private String projectImageUrl;

    @Column(name = "project_status", nullable = false, length = 50)
    private String projectStatus;

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @ManyToOne
    @JoinColumn(name = "freelancer_id", nullable = true) // Nullable because a project might not have a freelancer//
                                                         // assigned initially
    private Freelancer freelancer;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToOne(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
    private Payment payment;

    @Column(name = "project_price")
    private Double projectPrice;

    @OneToMany(mappedBy = "project")
    private List<ServiceRequest> serviceRequests;

    @OneToMany(mappedBy = "project")
    private List<ProjectRequest> projectRequests;
}
