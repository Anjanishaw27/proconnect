package edu.rims.pro_connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.pro_connect.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
