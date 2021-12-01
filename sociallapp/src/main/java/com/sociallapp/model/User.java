package com.sociallapp.model;

import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Component
public class User {
    private Integer id;
    @NotBlank(message = "Username can not be null. Provide a valid username.")
    @Size(min = 5, max = 10)
    private String name;
    @NotBlank
    @Email
    private String email;
    @NotBlank(message = "Password can't be null.")
    @Size(min = 5, max = 15, message = "Password must be in 5-15 range.")
    private String password;

    private Timestamp createdAt;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

}
