package edu.rims.pro_connect.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.pro_connect.constant.ProjectRequestStatus;
import edu.rims.pro_connect.constant.ProjectStatus;
import edu.rims.pro_connect.constant.ServiceRequestStatus;
import edu.rims.pro_connect.entity.Client;
import edu.rims.pro_connect.entity.Freelancer;
import edu.rims.pro_connect.entity.Payment;
import edu.rims.pro_connect.entity.Project;
import edu.rims.pro_connect.entity.ProjectRequest;
import edu.rims.pro_connect.entity.ServiceRequest;
import edu.rims.pro_connect.repository.*;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/projectRequest")
public class ProjectRequestController {

    private final ClientRepository clientRepository;
    @Autowired
    private ProjectRequestRepository projectRequestRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private FreelancerRepository freelancerRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    ProjectRequestController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping("/apply")
    String projectRequest(@RequestParam String id) {
        Project project = projectRepository.findById(id).orElseThrow();
        Freelancer freelancer = project.getFreelancer();
        Client client = project.getClient();

        ProjectRequest projectRequest = new ProjectRequest();
        projectRequest.setProject(project);
        projectRequest.setClient(client);
        projectRequest.setFreelancer(freelancer);
        projectRequest.setCreatedDate(LocalDate.now());
        projectRequest.setCreatedBy(freelancer.getUserName());

        freelancer.addProjectRequest(projectRequest);
        client.addProjectRequest(projectRequest);

        projectRequestRepository.save(projectRequest);
        freelancerRepository.save(freelancer);
        clientRepository.save(client);
        return "redirect:/client/home";
    }

    @GetMapping("/approve")
    @Transactional
    String requestApprove(@RequestParam("id") String id, @RequestParam("status") String status) {
        ProjectRequest projectRequest = projectRequestRepository.findById(id).orElseThrow();
        Project project = projectRequest.getProject();
        System.out.println(status);

        if (status.equals("approve")) {
            // Save the freelancer to persist the updated project list
            projectRequest.setProjectRequestStatus(ProjectRequestStatus.APPROVED);
            project.setProjectStatus(ProjectStatus.COMPLETED.toString());
            projectRepository.save(project);

        } else if (status.equals("cancel")) {
            System.out.println("cancel block executed");
            projectRequest.setProjectRequestStatus(ProjectRequestStatus.REJECTED);
        } else if (status.equals("canceled")) {
            projectRequest.setProjectRequestStatus(ProjectRequestStatus.CANCELED);
        }
        System.out.println("product saved executed");
        projectRequestRepository.save(projectRequest);
        return "redirect:/client/home";
    }
}
