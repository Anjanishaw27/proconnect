package edu.rims.pro_connect.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.pro_connect.constant.ProjectStatus;
import edu.rims.pro_connect.constant.ServiceRequestStatus;
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
        serviceRequest.setCreatedDate(LocalDate.now());
        serviceRequest.setCreatedBy(freelancer.getUserName());
        freelancer.addServiceRequest(serviceRequest);

        serviceRequestRepository.save(serviceRequest);
        freelancerRepository.save(freelancer);
        return "redirect:/client/home";
    }

    @GetMapping("/approve")
    String requestApprove(@RequestParam("id") String id, @RequestParam("status") String status) {
        ServiceRequest serviceRequest = serviceRequestRepository.findById(id).orElseThrow();
        Project project = serviceRequest.getProject();
        Freelancer freelancer = serviceRequest.getFreelancer();
        System.out.println(status);
        if (status.equals("approve")) {
            System.out.println("approve block executed");
            project.setFreelancer(freelancer);
            project.setProjectStatus(ProjectStatus.IN_PROGESS.toString());
            serviceRequest.setServiceRequestStatus(ServiceRequestStatus.APPROVED);
            projectRepository.save(project);
        } else if (status.equals("cancel")) {
            System.out.println("cancel block executed");
            serviceRequest.setServiceRequestStatus(ServiceRequestStatus.REJECTED);
        }
        System.out.println("product saved executed");
        serviceRequestRepository.save(serviceRequest);
        return "redirect:/client/home";
    }
}
