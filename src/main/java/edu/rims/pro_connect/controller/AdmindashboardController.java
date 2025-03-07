package edu.rims.pro_connect.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.pro_connect.entity.Category;
import edu.rims.pro_connect.repository.CategoryRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/admin")
public class AdmindashboardController {

  @Autowired
  private CategoryRepository categoryRepository;

  @GetMapping("/admindashboard")
 String admindashboard() {
    return "admin/admindashboard";

  }

 @GetMapping("/category")
  String admincategory(Model model){
    List<Category> categories = categoryRepository.findAll();
    model.addAttribute("categories", categories);
    return "admin/category";
  }

  @PostMapping("/admin/category")
  public String categoryAdd(@ModelAttribute Category category, @RequestParam("categoryImageFile") MultipartFile file)
   throws IOException{
    if(!file.isEmpty()){
      String originalFilename = file.getOriginalFilename();
      String extName = originalFilename.substring(originalFilename.lastIndexOf("."));
      String fileName = "upload_images/"+ UUID.randomUUID().toString() + extName;
      FileOutputStream fileOutputStream = new FileOutputStream(fileName);
      fileOutputStream.write(file.getBytes());
      fileOutputStream.close();
      category.setCategoryImageUrl(fileName);
    }
    categoryRepository.save(category);
    return "redirect:/admin/category";
  }
  
}



 