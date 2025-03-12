package edu.rims.pro_connect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/client")
public class ClientdashboardController {
    @GetMapping("/clientdashboard")
    String clientdashboard(){
        return "client/clientdashboard";
    }
    @GetMapping("/profile")
    String clientprofile(){
        return "client/profile";
    }
    
    @GetMapping("/myproject")
    String clientmyproject(){
        return "client/myproject";
    }
}
