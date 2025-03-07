package edu.rims.pro_connect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.pro_connect.entity.Project;
import edu.rims.pro_connect.repository.ProjectRepository;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/project")
    public String project(Model model) {
        List<Project> projects = projectRepository.findAll();  // Call findAll() on the instance
        model.addAttribute("projects", projects);  // Use a meaningful attribute name
        return "client/category";
    }
}
