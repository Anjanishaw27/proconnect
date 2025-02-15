package edu.rims.pro_connect.entity;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "category")
public class Category extends Auditable {

    @Id
    @Column(name = "category_id", nullable = false, length = 255)
    @GeneratedValue(strategy = GenerationType.UUID)
    private String categoryId;

    @Column(name = "category_name", nullable = false, length = 255)
    private String categoryName;

    @Column(name = "category_description", nullable = false, columnDefinition = "TEXT")
    private String categoryDescription;

}
