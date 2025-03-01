package edu.rims.pro_connect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/freelancer")
public class FreelancerdashboardController {
    @GetMapping("/freelancerdashboard")
    String freelancerdashboard(){
        return "/freelancer/freelancerdashboard";
    }
}