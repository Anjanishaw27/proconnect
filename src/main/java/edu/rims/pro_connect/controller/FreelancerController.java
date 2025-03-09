package edu.rims.pro_connect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/pdp")
    public String freelancerPdp(@RequestParam long id, Model model){
        Freelancer freelancer = freelancerRepository.findById(id).orElseThrow();
        model.addAttribute("freelancer", freelancer);
        return "client/pdp";
    }

}

