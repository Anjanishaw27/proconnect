package edu.rims.pro_connect.controller;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import edu.rims.pro_connect.entity.Category;
import edu.rims.pro_connect.repository.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ProductController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/client/category")
    public String getProductByCategoryId(@RequestParam("category") String categoryId, Model model) {
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        model.addAttribute("category",category);
        return "client/category";
    }
    
    @GetMapping(value = "/category/image/{categoryId}", produces = {"image/jpg", "image/png", "image/jpeg"})
    @ResponseBody
    byte[] getCategoryImage(@PathVariable String categoryId) throws IOException{
        Category category = categoryRepository.findById(categoryId).orElseThrow();
        String categoryImageUrl = category.getCategoryImageUrl();
        if(categoryImageUrl != null && categoryImageUrl.startsWith("http")){
            return null;
        }
        FileInputStream fis = new FileInputStream(categoryImageUrl);
        return fis.readAllBytes();
    }
    
}
