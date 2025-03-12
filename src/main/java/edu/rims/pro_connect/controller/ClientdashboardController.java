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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import edu.rims.pro_connect.constant.ProjectStatus;
import edu.rims.pro_connect.entity.Category;
import edu.rims.pro_connect.entity.Project;
import edu.rims.pro_connect.entity.User;
import edu.rims.pro_connect.repository.CategoryRepository;
import edu.rims.pro_connect.repository.ProjectRepository;
import edu.rims.pro_connect.repository.UserRepository;

@Controller
@RequestMapping("/client")
public class ClientdashboardController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/clientdashboard")
    String clientdashboard() {
        return "client/clientdashboard";
    }

    @GetMapping("/profile")
    String clientprofile() {
        return "client/profile";
    }

    @GetMapping("/myproject")
    String clientmyproject(Model model) {
        User user = userRepository.findById(1).orElseThrow();
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("user", user);
        model.addAttribute("categories", categories);
        return "client/myproject";
    }

    @PostMapping("/myproject")
    String clientmyproject(@ModelAttribute Project project, @RequestParam("projectImage") MultipartFile file)
            throws IOException {
        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = "upload_images/" + UUID.randomUUID().toString() + extName;
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();

            project.setProjectImageUrl(fileName);
        }
        project.setUser(userRepository.findById(1).orElseThrow());
        project.setCreatedDate(LocalDate.now());
        project.setProjectStatus(ProjectStatus.OPEN.toString());
        projectRepository.save(project);
        return "redirect:/client/myproject";
    }

    @GetMapping("/myproject/{projectId}")
    @ResponseBody
    byte[] getImage(@PathVariable String projectId)
            throws IOException {
        Project project = projectRepository.findById(projectId).orElseThrow();
        String imageUrl = project.getProjectImageUrl();
        if (imageUrl == null) {
            return null;
        }
        FileInputStream fis = new FileInputStream(imageUrl);
        return fis.readAllBytes();
    }
}
