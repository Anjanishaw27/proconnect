package edu.rims.pro_connect.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.pro_connect.entity.Freelancer;
import edu.rims.pro_connect.entity.Project;
import edu.rims.pro_connect.entity.ServiceRequest;
import edu.rims.pro_connect.repository.FreelancerRepository;
import edu.rims.pro_connect.repository.ProjectRepository;
import edu.rims.pro_connect.repository.ServiceRequestRepository;

@Controller
@RequestMapping("/serviceRequest")
public class ServiceRequestController {

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private FreelancerRepository freelancerRepository;

    @GetMapping("/apply")
    String serviceRequest(@RequestParam String id) {
        Project project = projectRepository.findById(id).orElseThrow();
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setProject(project);
        serviceRequest.setUser(project.getUser());
        Freelancer freelancer = freelancerRepository.findById(3).orElseThrow();
        serviceRequest.setFreelancer(freelancer);
        serviceRequest.setCreatedDate(LocalDate.now());
        serviceRequest.setCreatedBy(freelancer.getUserName());
        serviceRequestRepository.save(serviceRequest);
        return "redirect:/client/home";
    }
}
