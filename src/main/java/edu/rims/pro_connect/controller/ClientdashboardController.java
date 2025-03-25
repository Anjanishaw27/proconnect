package edu.rims.pro_connect.controller;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.Principal;
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

import edu.rims.pro_connect.constant.CategoryStatus;
import edu.rims.pro_connect.constant.ProjectStatus;
import edu.rims.pro_connect.dto.ProjectResponseDTO;
import edu.rims.pro_connect.dto.ProjectResponseDTO.CategoryResponse;
import edu.rims.pro_connect.entity.Category;
import edu.rims.pro_connect.entity.Client;
import edu.rims.pro_connect.entity.Project;
import edu.rims.pro_connect.entity.User;
import edu.rims.pro_connect.repository.CategoryRepository;
import edu.rims.pro_connect.repository.ClientRepository;
import edu.rims.pro_connect.repository.ProjectRepository;
import edu.rims.pro_connect.repository.UserRepository;
import edu.rims.pro_connect.service.UserService;

@Controller
@RequestMapping("/client")
public class ClientdashboardController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/clientdashboard")
    String clientdashboard() {
        return "client/clientdashboard";
    }

    @GetMapping("/profile")
    String clientprofile(Model model) {
        User user = clientRepository.findById(1).orElseThrow();
        model.addAttribute("user", user);
        return "client/profile";
    }

    @GetMapping("/request")
    String clientrequest(Model model) {
        User user = clientRepository.findById(1).orElseThrow();
        model.addAttribute("user", user);
        return "client/request";
    }

    @GetMapping("/myproject")
    String clientmyproject(Model model, Principal principal) {
        // User user = userService.getUser(principal.getName());
        Client user1 = clientRepository.findByUserEmail(principal.getName()); 
        List<Category> categories = categoryRepository.findAll();
        model.addAttribute("user", user1);
        model.addAttribute("categories", categories);
        return "client/myproject";
    }

    @PostMapping("/myproject")
    String clientmyproject(@ModelAttribute Project project, @RequestParam("projectImage") MultipartFile file,@RequestParam("projectImageName") String imageName, Principal principal)
            throws IOException {

        String projectId = project.getProjectId();
        project.setProjectId(projectId == null || projectId.isEmpty() ? null : projectId);
        if (!file.isEmpty()) {
            String originalFilename = file.getOriginalFilename();
            String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
            String fileName = "upload_images/" + UUID.randomUUID().toString() + extName;
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(file.getBytes());
            fileOutputStream.close();

            project.setProjectImageUrl(fileName);
        }else if(imageName!= null){
            project.setProjectImageUrl(imageName);
        }
        int  userId = userService.getuserId(principal.getName());
        Client client2 = clientRepository.findById(userId).orElseThrow();
        project.setClient(client2);
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

    @GetMapping("/myproject/delete")
    public String deletemyproject(@RequestParam("project") String projectId) {
      Project project = projectRepository.findById(projectId).orElseThrow();
      project.setProjectStatus(ProjectStatus.CANCELED.toString());
      projectRepository.save(project);
      return "redirect:/client/myproject";
  }

    @GetMapping("/reviewrating")
    String clientreviewrating() {
        return "client/reviewrating";
    }

    @GetMapping("/projectRequest")
    String clientProjectRequest(Model model) {
        User user = clientRepository.findById(1).orElseThrow();
        model.addAttribute("user", user);
        return "client/projectRequest";
    }

    @GetMapping("/myprojectedit/{id}")
    @ResponseBody
    ProjectResponseDTO myProjectEdit(@PathVariable String id){
        Project project = projectRepository.findById(id).orElseThrow();
        
        ProjectResponseDTO dto =  new ProjectResponseDTO();
        dto.setProjectId(project.getProjectId());
        dto.setProjectTitle(project.getProjectTitle());
        dto.setProjectPrice(project.getProjectPrice());
        dto.setProjectDescription(project.getProjectDescription());
        dto.setProjectImageUrl(project.getProjectImageUrl());
        dto.setProjectStatus(project.getProjectStatus());
        CategoryResponse categoryResponse = dto.new CategoryResponse();
        categoryResponse.setCategoryId(project.getCategory().getCategoryId());
        categoryResponse.setCategoryName(project.getCategory().getCategoryName());
        dto.setCategory(categoryResponse);
        return dto;
    }
}
