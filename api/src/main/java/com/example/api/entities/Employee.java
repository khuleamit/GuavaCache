package com.example.api.entities;

public class Employee {

    String id;
    String name;
    String role;

    public Employee(String id, String name, String role) {
        super();
        this.id = id;
        this.name = name;
        this.role = role;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
