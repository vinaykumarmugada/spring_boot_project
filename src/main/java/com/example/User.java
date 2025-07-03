package com.example;



public class User {
    private long id;
    private String name;
    private String email;

    // Constructors

    public User(long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Optional: toString method
    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "', email='" + email + "}";
    }
}
