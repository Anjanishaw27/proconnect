package edu.rims.pro_connect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.pro_connect.entity.Freelancer;
import edu.rims.pro_connect.entity.ServiceRequest;
import edu.rims.pro_connect.repository.FreelancerRepository;
import edu.rims.pro_connect.repository.ProjectRepository;
import edu.rims.pro_connect.repository.ServiceRequestRepository;
import jakarta.transaction.Transactional;

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

  @Transactional
  @GetMapping("/project")
  String freelancerproject(Model model) {
    Freelancer freelancer = freelancerRepository.findById(3).orElseThrow();
    System.out.println(freelancer.getProjects().size()); // This will now fetch the projects
    model.addAttribute("freelancer", freelancer);
    return "freelancer/project";
  }

  @GetMapping("/earning")
  String freelancerearning(Model model) {
    Freelancer freelancer = freelancerRepository.findById(3).orElseThrow();
    model.addAttribute("projects", freelancer.getProjects());
    return "freelancer/earning";
  }

  @Transactional
  @GetMapping("/servicerequest")
  String freelancerServiceRequest(Model model) {
    Freelancer freelancer = freelancerRepository.findById(3).orElseThrow();
    List<ServiceRequest> serviceRequests = serviceRequestRepository.findByFreelancer(freelancer);
    model.addAttribute("freelancer", freelancer);
    System.out.println(freelancer.getServiceRequests().size());
    return "freelancer/servicerequest";
  }

  @Transactional
  @GetMapping("/projectRequest")
  String freelancerProjectRequest(Model model) {
    Freelancer freelancer = freelancerRepository.findById(3).orElseThrow();
    model.addAttribute("freelancer", freelancer);
    System.out.println(freelancer.getServiceRequests().size());
    return "freelancer/projectRequest";
  }
}