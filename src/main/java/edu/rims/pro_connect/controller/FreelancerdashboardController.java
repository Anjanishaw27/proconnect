package edu.rims.pro_connect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.pro_connect.entity.Freelancer;
//import edu.rims.pro_connect.entity.Category;
import edu.rims.pro_connect.entity.Project;
import edu.rims.pro_connect.entity.ServiceRequest;
import edu.rims.pro_connect.repository.FreelancerRepository;
import edu.rims.pro_connect.repository.ProjectRepository;
import edu.rims.pro_connect.repository.ServiceRequestRepository;

import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;

//import edu.rims.pro_connect.entity.Category;

@Controller
@RequestMapping("/freelancer")
public class FreelancerdashboardController {
  @Autowired
  private ProjectRepository projectRepository;

  @Autowired
  private FreelancerRepository freelancerRepository;

  @Autowired
  private ServiceRequestRepository serviceRequestRepository;

  @GetMapping("/freelancerdashboard")
  String freelancerdashboard() {
    return "freelancer/freelancerdashboard";
  }

  @GetMapping("/project")
  String freelancerproject(Model model) {
    List<Project> projects = projectRepository.findAll(); // Call findAll() on the instance
    model.addAttribute("projects", projects); // Use a meaningful attribute name
    return "freelancer/project";
  }

  @PostMapping("/freelancer/project")
  public String projectAdd(@ModelAttribute Project project) {

    // projectRepository.save(project);
    System.out.println(project);
    return "redirect:/freelancer/project";
  }

  @GetMapping("/earning")
  String freelancerearning() {
    return "freelancer/earning";
  }

  @GetMapping("/servicerequest")
  String freelancerservicerequest(Model model) {
    Freelancer freelancer = freelancerRepository.findById(3).orElseThrow();
    List<ServiceRequest> serviceRequests = serviceRequestRepository.findByFreelancer(freelancer);
    model.addAttribute("serviceRequests", serviceRequests);
    return "freelancer/servicerequest";
  }
}