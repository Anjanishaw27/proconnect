package edu.rims.pro_connect.controller;

import java.io.FileInputStream;
// import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.rims.pro_connect.constant.UserType;
import edu.rims.pro_connect.dto.CategoryResponseDTO;
import edu.rims.pro_connect.entity.Category;
import edu.rims.pro_connect.entity.Freelancer;
import edu.rims.pro_connect.entity.User;
import edu.rims.pro_connect.repository.CategoryRepository;
import edu.rims.pro_connect.repository.FreelancerRepository;
import edu.rims.pro_connect.repository.UserRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/admin")
public class AdmindashboardController {

  private final FreelancerRepository freelancerRepository;

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private UserRepository userRepository;

  AdmindashboardController(FreelancerRepository freelancerRepository) {
    this.freelancerRepository = freelancerRepository;
  }

  @GetMapping("/admindashboard")
  String admindashboard() {
    return "admin/admindashboard";

  }

  @GetMapping("/category")
  String admincategory(Model model) {
    List<Category> categories = categoryRepository.findAll();
    model.addAttribute("categories", categories);
    return "admin/category";
  }

  @PostMapping("/admin/category")
  public String categoryAdd(@ModelAttribute Category category, @RequestParam("categoryImageFile") MultipartFile file, @RequestParam(required = false) String categoryImages)
      throws IOException {
    if (!file.isEmpty()) {
      String originalFilename = file.getOriginalFilename();
      String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
      String fileName = "upload_images/" + UUID.randomUUID().toString() + extName;
      FileOutputStream fileOutputStream = new FileOutputStream(fileName);
      fileOutputStream.write(file.getBytes());
      fileOutputStream.close();
      category.setCategoryImageUrl(fileName);
    }
    if (categoryImages != null) {
      category.setCategoryImageUrl(categoryImages);
    }
    categoryRepository.save(category);
    return "redirect:/admin/category";
  }

  @GetMapping(value = "/category/image/{categoryId}", produces = { "image/jpg", "image/jpeg", "image/png" })
  @ResponseBody
  public byte[] getImage(@PathVariable String categoryId) throws IOException {

    Category category = categoryRepository.findById(categoryId).orElseThrow();
    String categoryImageUrl = category.getCategoryImageUrl();
    if (categoryImageUrl == null || categoryImageUrl.startsWith("http")) {
      return null;
    }
    FileInputStream fis = new FileInputStream(categoryImageUrl);
    byte[] image = fis.readAllBytes();
    fis.close();
    return image;
  }

  @GetMapping("/usermanagment")
  String adminusermanagment(Model model) {
    List<User> users = userRepository.findByUserType(UserType.CLIENT);
    model.addAttribute("users", users);
    return "admin/usermanagment";
  }

  @GetMapping("/freelancermanagment")
  String adminFreelancermanagment(Model model) {
    List<Freelancer> freelancers = freelancerRepository.findByUserType(UserType.FREELANCER);
    model.addAttribute("freelancers", freelancers);
    return "admin/freelancermanagment";
  }
  @GetMapping("/report")
  String adminreport() {
    return "admin/report";

  }
  
  @GetMapping("/category/{categoryId}")
  @ResponseBody
  public CategoryResponseDTO getcategory(@PathVariable String categoryId){
  Category category=categoryRepository.findById(categoryId).orElseThrow();
  CategoryResponseDTO dto = new CategoryResponseDTO();
  dto.setCategoryId(categoryId);
  dto.setCategoryName(category.getCategoryName());
  dto.setCategoryDescription(category.getCategoryDescription());
  dto.setCategoryImageUrl(category.getCategoryImageUrl());
  dto.setCategoryStatus(category.getCategoryStatus());

    return dto;
  }
}
