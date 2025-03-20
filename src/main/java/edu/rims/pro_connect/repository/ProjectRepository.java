package edu.rims.pro_connect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import edu.rims.pro_connect.entity.Category;
import edu.rims.pro_connect.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, String> {

    List<Project> findByProjectTitleContainingIgnoreCase(String projectTitle);
    List<Project> findByProjectTitleContainingIgnoreCaseAndProjectStatus(String projectTitle, String projectStatus);


    List<Project> findByCategoryCategoryIdAndProjectStatus(String categoryId, String projectStatus);
}
