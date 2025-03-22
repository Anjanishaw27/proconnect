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
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

   // @Autowired
  //  Private PasswordEncoder encoder;


    @GetMapping("/login")
    public String loginPage() {
        return "client/sign_in";
    }

    @GetMapping("/signup")
    public String signUpPage() {
        return "client/sign_up";
    }

    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute User user) {
        //user.setuserpassword(encoder.encoder.(user.getUserpassword()));
        userRepository.save(user);
       return "redirect:/client/login";
    }

}
