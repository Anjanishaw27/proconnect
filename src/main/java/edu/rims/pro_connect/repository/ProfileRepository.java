package edu.rims.pro_connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.pro_connect.entity.Profile;

public interface ProfileRepository  extends JpaRepository<Profile, String>{

    
}