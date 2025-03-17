package edu.rims.pro_connect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.pro_connect.entity.Freelancer;
import edu.rims.pro_connect.entity.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, String> {

    List<ServiceRequest> findByFreelancer(Freelancer freelancer);
}