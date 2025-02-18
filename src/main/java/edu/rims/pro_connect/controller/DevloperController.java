package edu.rims.pro_connect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/developer")
public class DevloperController {
    @GetMapping("/developer")
    public String developer() {
        return "client/developer";
    } 
}