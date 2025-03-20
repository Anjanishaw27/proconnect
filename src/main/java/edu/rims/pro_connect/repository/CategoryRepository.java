package edu.rims.pro_connect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

//import edu.rims.pro_connect.constant.CategoryStatus;
import edu.rims.pro_connect.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, String> {
    List<Category> findByCategoryNameContainingIgnoreCase(String categoryName);

    List<Category> findByCategoryNameContainingIgnoreCaseAndCategoryStatus(String categoryName, String categoryStatus);
}
