package edu.rims.pro_connect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.pro_connect.entity.ServiceRequest;
import edu.rims.pro_connect.repository.ServiceRequestRepository;

@Controller
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private ServiceRequestRepository serviceRequestRepository;

    @GetMapping("/approve")
    public String payment(@RequestParam String id, Model model) {
        ServiceRequest serviceRequest = serviceRequestRepository.findById(id).orElseThrow();
        model.addAttribute("serviceRequest", serviceRequest);
        return "client/payment";
    }

}
