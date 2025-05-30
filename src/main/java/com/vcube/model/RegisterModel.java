package com.vcube.model;

public class RegisterModel {
    private int id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String passwor;
    private String role;

    // Default Constructor
    public RegisterModel() {
    }

    // Parameterized Constructor
    public RegisterModel(int id, String username, String firstname, String lastname, String email, String password, String role) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.passwor = passwor;
        this.role = role;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return passwor;
    }

    public void setPassword(String passwor) {
        this.passwor = passwor;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    public String toString() {
    	return username;
    }
}
