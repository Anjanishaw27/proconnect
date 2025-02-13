package edu.rims.pro_connect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/admindashboard")
public class AdminController {
  @GetMapping("/admindashboard")
 String admindashboard() {
    return "/client/admindashboard";

  }

}
 

 