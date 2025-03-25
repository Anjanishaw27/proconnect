package edu.rims.pro_connect.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

//import edu.rims.pro_connect.constant.CategoryStatus;
import edu.rims.pro_connect.constant.UserType;
//import edu.rims.pro_connect.entity.Category;
import edu.rims.pro_connect.entity.Freelancer;
import edu.rims.pro_connect.entity.User;
import edu.rims.pro_connect.repository.FreelancerRepository;
import edu.rims.pro_connect.repository.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/freelancer")
public class FreelancerController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FreelancerRepository freelancerRepository;

    @GetMapping("/freelancer")
    public String freelancerList(Model model) {
        List<Freelancer> freelancers = freelancerRepository.findAll();
        model.addAttribute("freelancers", freelancers);
        return "client/freelancer";
    }

    @GetMapping("/pdp")
    public String freelancerPdp(@RequestParam int id, Model model) {
        Freelancer freelancer = freelancerRepository.findById(id).orElseThrow();
        model.addAttribute("freelancer", freelancer);
        return "client/pdp";
    }

    @GetMapping("/image/{id}")
    @ResponseBody
    byte[] clientGetImage(@PathVariable int id) throws IOException {
    User user = freelancerRepository.findById(id).orElseThrow();
    String image = user.getUserProfilePicture();

    FileInputStream fileInputStream = new FileInputStream(image);

    return fileInputStream.readAllBytes();
  }

    @GetMapping("/freelancer/search")
    public String searchFreelancer(@RequestParam("search") String userName,Model model) {

        List<User> freelancers = userRepository.
        findByUserNameContainingIgnoreCaseAndUserType(userName,UserType.FREELANCER);
        System.out.println(freelancers.size());
        model.addAttribute("freelancers", freelancers);
        return "client/freelancer";
    }

    @PostMapping("/signup")
    String signUpClient(@ModelAttribute Freelancer freelancer, @RequestParam("userProfilePic") MultipartFile file)
            throws IOException {

        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = "upload_images/" + UUID.randomUUID().toString() + extName;
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();

            freelancer.setUserProfilePicture(fileName);
        }
        freelancer.setCreatedDate(LocalDate.now());
        freelancer.setUserType(UserType.FREELANCER);
        freelancerRepository.save(freelancer);

        return "redirect:/login/login";
    }
}
