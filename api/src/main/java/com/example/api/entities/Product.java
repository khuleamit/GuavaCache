package com.example.api.entities;

public class Product {
    String id;
    String name;
    String price;

    public Product(String id, String name, String price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }

    //Getters and Setters

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

    public String getPrice() {
        return price;
    }

    public void setPrice(String role) {
        this.price = price;
    }

}

