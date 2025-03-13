package edu.rims.pro_connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.pro_connect.entity.ServiceRequest;

public interface ServiceRequestRepository extends JpaRepository<ServiceRequest, String> {
}