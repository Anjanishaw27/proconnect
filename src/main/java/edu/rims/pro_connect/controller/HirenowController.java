package edu.rims.pro_connect.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HirenowController {
  @GetMapping("/hirenow/hirenow")
  String hirenow() {
    return "client/hirenow";
  }

}
