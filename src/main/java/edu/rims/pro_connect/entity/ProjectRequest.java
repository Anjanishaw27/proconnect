package edu.rims.pro_connect.entity;

import edu.rims.pro_connect.constant.ProjectRequestStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class ProjectRequest extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String projectRequestId;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Freelancer freelancer;

    @ManyToOne
    private Project project;

    private ProjectRequestStatus projectRequestStatus = ProjectRequestStatus.PENDING;
}
