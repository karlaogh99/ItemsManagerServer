package com.carlos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @Column(name = "item_id", unique = true, nullable = false )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int item_id;
    @Column(name = "item_code", unique = true, nullable = false)
    private int item_code;
    @Column(name = "description", unique = false, nullable = false)
    private String description;
    @Column(name = "price", unique = false, nullable = true)
    private double price;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", unique = false, nullable = true)
    private StateEnum state;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "item_supplier", joinColumns = @JoinColumn(name = "item_id", referencedColumnName = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
    )
    @JsonBackReference(value = "itemsup")

    private List<Supplier> supplier = new ArrayList<>();

    @OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "priceReductions")
    private List<PriceReduction> priceReductions = new ArrayList<>();

    @Column(name = "CREATION_DATE", nullable = false)
    private Date creation_date ;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id ")
    @JsonBackReference(value ="user_id11")
    private User user_id ;

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public int getItem_code() {
        return item_code;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public void setItem_code(int item_code) {
        this.item_code = item_code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }

    public List<Supplier> getSupplier() {
        return supplier;
    }

    public void setSupplier(List<Supplier> supplier) {
        this.supplier = supplier;
    }

    public List<PriceReduction> getPriceReductions() {
        return priceReductions;
    }

    public void setPriceReductions(List<PriceReduction> priceReductions) {
        this.priceReductions = priceReductions;
    }

    public User getUser() {
        return user_id;
    }

    public void setUser(User user) {
        this.user_id = user;
    }

    public String getDescripcion() {
        return description;
    }

    public void setDescripcion(String description) {
        this.description = description;
    }
}
