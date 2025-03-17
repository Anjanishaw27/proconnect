package edu.rims.pro_connect.entity;

import edu.rims.pro_connect.constant.ServiceRequestStatus;
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
public class ServiceRequest extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String serviceRequestId;

    @ManyToOne
    private User user;

    @ManyToOne
    private Freelancer freelancer;

    @ManyToOne
    private Project project;

    private ServiceRequestStatus serviceRequestStatus = ServiceRequestStatus.PENDING;
}
