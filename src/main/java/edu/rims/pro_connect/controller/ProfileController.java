package edu.rims.pro_connect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.rims.pro_connect.entity.Profile;
import edu.rims.pro_connect.repository.ProfileRepository;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/profile")
public class ProfileController {
    @Autowired
    private ProfileRepository profileRepository;

    @GetMapping("/profile")
    public String profile(Model model) {

        List<Profile> profiles = profileRepository.findAll();

        model.addAttribute("profiles", profiles);
        return "client/profile";
    }

}
