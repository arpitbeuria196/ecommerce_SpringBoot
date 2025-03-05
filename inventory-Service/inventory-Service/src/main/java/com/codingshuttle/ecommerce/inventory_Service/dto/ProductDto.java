package com.codingshuttle.ecommerce.inventory_Service.dto;


public class ProductDto {
    private Long id;
    private String title;
    private Double price;
    private Integer stock;

    // Default constructor
    public ProductDto() {
    }

    // Parameterized constructor
    public ProductDto(Long id, String title, Double price, Integer stock) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
