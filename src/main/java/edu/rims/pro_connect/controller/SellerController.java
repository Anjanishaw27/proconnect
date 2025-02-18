package edu.rims.pro_connect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/seller")
public class SellerController {
    @GetMapping("/seller")
    public String seller() {
        return "client/seller";
    }
    
}
