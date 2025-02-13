package edu.rims.pro_connect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.service.annotation.GetExchange;

@Controller
    @RequestMapping("clientdashboard")


public class ClientdashboardController {
    @GetMapping("/clientdashboard")
    String clientdashboard(){
        return "client/clientdashboard";
    }
}
