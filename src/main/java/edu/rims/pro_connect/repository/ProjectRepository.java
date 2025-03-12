package edu.rims.pro_connect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.rims.pro_connect.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, String> {

    List<Project> findByCategoryCategoryIdAndProjectStatus(String categoryId, String projectStatus);
}
