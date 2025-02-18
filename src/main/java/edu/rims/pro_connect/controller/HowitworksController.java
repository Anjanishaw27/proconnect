package edu.rims.pro_connect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/howitworks")

public class HowitworksController {
    @GetMapping("/howitworks")
    public String howitworks() {
        return "client/howitworks";
    }    
}

