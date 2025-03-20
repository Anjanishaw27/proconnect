package edu.rims.pro_connect.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryResponseDTO {
    private String categoryId;
    private String categoryName;
    private String categoryDescription;
    private String categoryImageUrl ;
    private String categoryStatus;
}
