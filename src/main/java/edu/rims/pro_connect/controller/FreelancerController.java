package edu.rims.pro_connect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.pro_connect.entity.Freelancer;
import edu.rims.pro_connect.repository.FreelancerRepository;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/freelancer")
public class FreelancerController {

    @Autowired
    private FreelancerRepository freelancerRepository;

    @GetMapping("/freelancer")
    public String freelancerList(Model model) {
        List<Freelancer> freelancers = freelancerRepository.findAll();
        model.addAttribute("freelancers", freelancers);
        return "client/freelancer";
    }
}

