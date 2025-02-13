package edu.rims.pro_connect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/solution")
public class SolutionController {
  @GetMapping("/solution")
  public String solution(){
    return "client/solution";
  }
}