package com.example.cuddletoys;

public class Toy {

    private String id;
    private String name;
    private String category;
    private double price;
    private int quantity;
    private String description;
    private String brand;
    private boolean inStock;
    private int imageResId;
    private boolean isHandmade;
    public Toy(String id, String name, String category, double price, int quantity,
               String description, String brand, boolean inStock,
               int imageResId, boolean isHandmade) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.brand = brand;
        this.inStock = inStock;
        this.imageResId = imageResId;
        this.isHandmade = isHandmade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    public int getImageResId() {
        return imageResId;
    }

    public void setImageResId(int imageResId) {
        this.imageResId = imageResId;
    }

    public boolean isHandmade() {
        return isHandmade;
    }

    public void setHandmade(boolean handmade) {
        isHandmade = handmade;
    }
    @Override
    public String toString() {
        return name + " (" + category + "):  $" + price + "\n" +
                description + "\n" +
                "Brand: " + brand + "\n" +
                "Handmade: " + (isHandmade ? "Yes" : "No");
    }

}

