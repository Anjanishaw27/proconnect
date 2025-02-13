package edu.rims.pro_connect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/contact")
public class ContactController {
    @GetMapping("/contact")
    public String contact() {
        return "client/contact";
    }    
}
