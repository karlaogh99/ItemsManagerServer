package com.carlos.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
public class User implements Serializable {
    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long user_id;



    @Column(name = "username", unique = true, nullable = false)
    private String username;


    @Column(name = "password", unique = true, nullable = false)
    private String password;
    @OneToMany(mappedBy = "user")
    private List<Item> createdItems = new ArrayList<>();

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
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
