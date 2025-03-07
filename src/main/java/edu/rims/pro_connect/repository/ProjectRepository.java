package edu.rims.pro_connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.pro_connect.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, String>{

    
}
