package edu.rims.pro_connect.controller;

import java.io.FileOutputStream;
import java.io.IOException;
//import java.security.PrivateKey;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.rims.pro_connect.constant.UserType;
import edu.rims.pro_connect.entity.User;
import edu.rims.pro_connect.repository.UserRepository;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/client")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/sign_in")
    public String sign_inPage() {
        return "client/sign_in";
    }

    @GetMapping("/sign_up")
    public String signUpPage() {
        return "client/sign_up";
    }

    @PostMapping("/sign_up")
    public String signUp(@ModelAttribute User user, @RequestParam("userProfilePic") MultipartFile file) 
     throws IOException {
        

        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = "upload_images/" + UUID.randomUUID().toString() + extName;
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();

            user.setUserProfilePicture(fileName);
        }
    
        System.out.println(user.getUserEmail());
        user.setCreatedDate(LocalDate.now());
        user.setUpdatedDate(LocalDate.now());
        user.setCreatedBy("user");
        user.setUpdatedBy("user");
        user.setUserType(UserType.ADMIN);
        
        user.setUserPassword(passwordEncoder.encode(user.getUserPassword()));
        System.out.println(user.getUserPassword());
        userRepository.save(user);
        return "redirect:/client/sign_in";
    }

}
