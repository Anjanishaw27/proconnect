package edu.rims.pro_connect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.pro_connect.entity.User;
import edu.rims.pro_connect.repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;



@Controller
@RequestMapping("/client")
public class LoginController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping("/login")
    public String loginPage(){
        return "client/login";
    }

    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute User user) {
        userRepository.save(user);
        System.out.println(user.getUserName());
        System.out.println(user.getUserEmail());
        System.out.println(user.getUserPassword());
        System.out.println(user.getUserConfirmPassword());
        System.out.println(user.getUserPhone());
        System.out.println(user.getUserBio());
        return "redirect:/client/login";
    }
    
}
