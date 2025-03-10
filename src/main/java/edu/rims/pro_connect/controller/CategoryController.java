package edu.rims.pro_connect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.pro_connect.entity.Category;
//import edu.rims.pro_connect.entity.Freelancer;
import edu.rims.pro_connect.repository.CategoryRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/category")
    public String category(Model model) {

        List<Category> categories = categoryRepository.findAll();

        model.addAttribute("categories", categories);
        return "client/category";
    }

    @GetMapping("/freelancer")
    public String categoryFreelancerList(Model model, @RequestParam String categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        model.addAttribute("category", category);
        return "client/freelancer";
    }
}
