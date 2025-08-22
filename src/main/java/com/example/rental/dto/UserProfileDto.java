// src/main/java/com/example/rental/dto/UserProfileDto.java
package com.example.rental.dto;

public class UserProfileDto {
    private Long id;
    private String username;
    private String email;
    private String phone;

    // Constructors
    public UserProfileDto() {}

    public UserProfileDto(Long id, String username, String email, String phone) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.phone = phone;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // toString
    @Override
    public String toString() {
        return "UserProfileDto{id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' + '}';
    }
}
