package edu.rims.pro_connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.pro_connect.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    
}
