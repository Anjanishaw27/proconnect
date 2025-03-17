package edu.rims.pro_connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.pro_connect.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, String> {

}