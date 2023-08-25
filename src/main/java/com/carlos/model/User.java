package com.carlos.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int user_id;



    @Column(name = "username", unique = true, nullable = false)
    private String username;


    @Column(name = "password", unique = true, nullable = false)
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Item> createdItems = new ArrayList<>();

    public User(int user_id, String username, String password, List<Item> createdItems) {
        this.user_id = user_id;
        this.username = username;
        this.password = password;
        this.createdItems = createdItems;
    }

    public User() {
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Item> getCreatedItems() {
        return createdItems;
    }

    public void setCreatedItems(List<Item> createdItems) {
        this.createdItems = createdItems;
    }
}
