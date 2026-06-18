package com.trainingmug.ecommerce.entity;

import com.trainingmug.ecommerce.enums.Available;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name = "products")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int maxRetailPrice;
    private int discountPercentage;
    @Enumerated(EnumType.STRING)
    private Available available;
    private String company;
    private String category;
    private int manufacturedYear;
}