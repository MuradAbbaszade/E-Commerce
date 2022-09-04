package com.company.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Range;

public class ProductDto {
    private int id;
    @Size(min=2,max=100,message="Name size must be between 2 and 100")
    @NotEmpty(message = "Please fill the all fields")
    private String name;
    @NotEmpty(message = "Please fill the all fields")
    private String image;
    @NotNull(message = "Please fill the all fields")
    private double price;
    @NotEmpty(message = "Please fill the all fields")
    private String category;
    @Size(min=5,max=100,message="Description size must be between 5 and 100")
    @NotEmpty(message = "Please fill the all fields")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductDto(){
        
    }
    public ProductDto(int id, String name, String image, double price, String category) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.price = price;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
