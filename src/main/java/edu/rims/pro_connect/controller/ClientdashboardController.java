package edu.rims.pro_connect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.pro_connect.entity.User;
import edu.rims.pro_connect.repository.ProjectRepository;
import edu.rims.pro_connect.repository.UserRepository;

@Controller
@RequestMapping("/client")
public class ClientdashboardController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/clientdashboard")
    String clientdashboard(){
        return "client/clientdashboard";
    }
    @GetMapping("/profile")
    String clientprofile(){
        return "client/profile";
    }
    
    @GetMapping("/myproject")
    String clientmyproject(Model model){
        User user = userRepository.findById(1).orElseThrow();
        model.addAttribute("user", user);
        return "client/myproject";
    }
}
