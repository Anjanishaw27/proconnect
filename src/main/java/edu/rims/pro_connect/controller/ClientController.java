package edu.rims.pro_connect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/client")
public class ClientController {
  @GetMapping("/home")
  String clienthome() {
    return "client/home";
  }
}