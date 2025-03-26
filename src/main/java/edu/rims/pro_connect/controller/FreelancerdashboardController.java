package edu.rims.pro_connect.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.pro_connect.entity.Freelancer;
import edu.rims.pro_connect.entity.ServiceRequest;
import edu.rims.pro_connect.entity.User;
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
  String freelancerproject(Principal principal, Model model) {
    Freelancer freelancer = freelancerRepository.findByUserEmail(principal.getName());
    System.out.println(freelancer.getProjects().size());
    model.addAttribute("freelancer", freelancer);
    return "freelancer/project";
  }

  @GetMapping("/earning")
  String freelancerearning(Principal principal, Model model) {
    Freelancer freelancer = freelancerRepository.findByUserEmail(principal.getName());
    model.addAttribute("projects", freelancer.getProjects());
    return "freelancer/earning";
  }

  @Transactional
  @GetMapping("/servicerequest")
  String freelancerServiceRequest(Principal principal, Model model) {
    Freelancer freelancer = freelancerRepository.findByUserEmail(principal.getName());
    model.addAttribute("freelancer", freelancer);
    System.out.println(freelancer.getServiceRequests().size());
    return "freelancer/servicerequest";
  }

  @Transactional
  @GetMapping("/projectRequest")
  String freelancerProjectRequest(Principal principal, Model model) {
    Freelancer freelancer = freelancerRepository.findByUserEmail(principal.getName());
    model.addAttribute("freelancer", freelancer);
    System.out.println(freelancer.getServiceRequests().size());
    return "freelancer/projectRequest";
  }

  @GetMapping("/profile")
  String freelancerprofile(Principal principal, Model model) {
    Freelancer freelancer = freelancerRepository.findByUserEmail(principal.getName());
    model.addAttribute("freelancer", freelancer);
    return "freelancer/profile";
  }

}