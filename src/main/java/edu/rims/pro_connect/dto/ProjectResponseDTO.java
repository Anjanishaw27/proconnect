package edu.rims.pro_connect.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProjectResponseDTO {
   private String projectId;
   private String projectTitle;
   private Double projectPrice;
   private String projectDescription;
   private String projectImageUrl;
   private String projectStatus;
   private CategoryResponse category;

   @Getter
   @Setter
   public class CategoryResponse {
      private String categoryId;
      private String categoryName;
   }
}
