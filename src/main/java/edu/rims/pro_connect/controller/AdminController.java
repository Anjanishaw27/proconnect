package edu.rims.pro_connect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/Admin")
public class AdminController {
  @GetMapping("/index")
 String adminIndex() {
    return "admin/index";
}

}
  


