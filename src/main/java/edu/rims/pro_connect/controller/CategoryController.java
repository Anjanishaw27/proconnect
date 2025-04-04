package edu.rims.pro_connect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.rims.pro_connect.constant.CategoryStatus;
import edu.rims.pro_connect.constant.ProjectStatus;
import edu.rims.pro_connect.entity.Category;
import edu.rims.pro_connect.entity.Project;
//import edu.rims.pro_connect.entity.Freelancer;
import edu.rims.pro_connect.repository.CategoryRepository;
import edu.rims.pro_connect.repository.ProjectRepository;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/category")
    public String category(Model model) {

        List<Category> categories = categoryRepository.findAll();

        model.addAttribute("categories", categories);
        return "client/category";
    }

    @GetMapping("/category/search")
    public String searchCategory(@RequestParam("search") String categoryName,Model model) {

        List<Category> categories = categoryRepository.
        findByCategoryNameContainingIgnoreCaseAndCategoryStatus(categoryName, CategoryStatus.AVAILABLE.toString());

        model.addAttribute("categories", categories);
        return "client/category";
    }

    @GetMapping("/freelancer")
    public String categoryProjectList(Model model, @RequestParam String categoryId) {
        List<Project> projects = projectRepository.findByCategoryCategoryIdAndProjectStatus(categoryId,
                ProjectStatus.OPEN.toString());
        model.addAttribute("projects", projects);
        return "client/project";
    }
}
