package edu.rims.pro_connect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.rims.pro_connect.dto.CategoryResponseDTO;
import edu.rims.pro_connect.dto.ProjectResponseDTO;
import edu.rims.pro_connect.dto.ProjectResponseDTO.CategoryResponse;
import edu.rims.pro_connect.entity.Project;
import edu.rims.pro_connect.repository.ProjectRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/project")
    public String project(Model model) {
        List<Project> projects = projectRepository.findAll(); // Call findAll() on the instance
        model.addAttribute("projects", projects); // Use a meaningful attribute name
        return "client/category";
    }

    @GetMapping("/pdp")
    public String projectDetails(@RequestParam String id, Model model) {
        Project project = projectRepository.findById(id).orElseThrow();
        model.addAttribute("project", project);
        return "client/project_pdp";
    }

    @GetMapping("/projects/{projectId}")
    @ResponseBody
    public ProjectResponseDTO getProject(@PathVariable String projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow();
        ProjectResponseDTO dto = new ProjectResponseDTO();
        dto.setProjectId(projectId);
        dto.setProjectTitle(project.getProjectTitle());
        dto.setProjectDescription(project.getProjectDescription());
        dto.setProjectPrice(project.getProjectPrice());
        dto.setProjectImageUrl(project.getProjectImageUrl());
        dto.setProjectStatus(project.getProjectStatus());

        CategoryResponse category = dto.new CategoryResponse();
        category.setCategoryId(project.getCategory().getCategoryId());
        category.setCategoryName(project.getCategory().getCategoryName());
        dto.setCategory(category);

        return dto;
    }
}
