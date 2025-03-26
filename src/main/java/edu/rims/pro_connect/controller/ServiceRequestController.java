package edu.rims.pro_connect.controller;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.pro_connect.constant.ProjectRequestStatus;
import edu.rims.pro_connect.constant.ProjectStatus;
import edu.rims.pro_connect.constant.ServiceRequestStatus;
import edu.rims.pro_connect.entity.Freelancer;
import edu.rims.pro_connect.entity.Payment;
import edu.rims.pro_connect.entity.Project;
import edu.rims.pro_connect.entity.ServiceRequest;
import edu.rims.pro_connect.repository.FreelancerRepository;
import edu.rims.pro_connect.repository.PaymentRepository;
import edu.rims.pro_connect.repository.ProjectRepository;
import edu.rims.pro_connect.repository.ServiceRequestRepository;
import jakarta.transaction.Transactional;

@Controller
@RequestMapping("/serviceRequest")
public class ServiceRequestController {

    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private FreelancerRepository freelancerRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/apply")
    String serviceRequest(Principal principal, @RequestParam String id) {
        Project project = projectRepository.findById(id).orElseThrow();
        ServiceRequest serviceRequest = new ServiceRequest();
        serviceRequest.setProject(project);
        serviceRequest.setClient(project.getClient());

        Freelancer freelancer = freelancerRepository.findByUserEmail(principal.getName());
        serviceRequest.setCreatedDate(LocalDate.now());
        serviceRequest.setCreatedBy(freelancer.getUserName());
        freelancer.addServiceRequest(serviceRequest);

        serviceRequestRepository.save(serviceRequest);
        freelancerRepository.save(freelancer);
        return "redirect:/client/home";
    }

    @GetMapping("/approve")
    @Transactional
    String requestApprove(@RequestParam("id") String id, @RequestParam("status") String status) {
        ServiceRequest serviceRequest = serviceRequestRepository.findById(id).orElseThrow();
        Project project = serviceRequest.getProject();
        Freelancer freelancer = serviceRequest.getFreelancer();
        System.out.println(status);

        if (status.equals("approve")) {
            // payment update
            Payment payment = new Payment();
            payment.setCreatedBy(serviceRequest.getClient().getUserName());
            payment.setCreatedDate(LocalDate.now());
            payment.setClient(serviceRequest.getClient());
            payment.setFreelancer(freelancer);
            payment.setAmount(project.getProjectPrice());
            payment.setProject(serviceRequest.getProject());
            paymentRepository.save(payment);

            // project update
            project.setFreelancer(freelancer);
            project.setProjectStatus(ProjectStatus.IN_PROGRESS.toString());
            project.setPayment(payment);

            // Save the freelancer to persist the updated project list
            serviceRequest.setServiceRequestStatus(ServiceRequestStatus.APPROVED);
            projectRepository.save(project);

            freelancer.addProjects(project);
            freelancerRepository.save(freelancer);
        } else if (status.equals("cancel")) {
            System.out.println("cancel block executed");
            serviceRequest.setServiceRequestStatus(ServiceRequestStatus.REJECTED);
        } else if (status.equals("canceled")) {
            serviceRequest.setServiceRequestStatus(ServiceRequestStatus.CANCELED);
        }
        System.out.println("product saved executed");
        serviceRequestRepository.save(serviceRequest);
        return "redirect:/client/home";
    }

}
