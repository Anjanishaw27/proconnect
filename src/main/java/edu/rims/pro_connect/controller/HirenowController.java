package edu.rims.pro_connect.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HirenowController {
  @GetMapping("/hirenow")
  String hirenow() {
    return "client/hirenow";
  }

}
