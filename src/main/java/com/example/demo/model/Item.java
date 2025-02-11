package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
@Entity
@Table(name = "items")  // This will map to a MySQL table named 'items'
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;   // Auto-increment primary key

    @NotBlank(message = "Name cannot be empty")
    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @DecimalMin(value = "1.0", message = "Price must be greater than 0")
    @Column(nullable = false)
    private double price;

    // Default Constructor
    public Item() {}

    // Constructor
    public Item(String name, String description, double price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
