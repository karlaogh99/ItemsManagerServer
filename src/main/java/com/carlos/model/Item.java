package com.carlos.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @Column(name = "id", unique = true, nullable = false )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long item_id;
    @Column(name = "item_code", unique = true, nullable = false)
    private int item_code;

    @Column(name = "price", unique = false, nullable = true)
    private double price;

    @Column(name = "state", unique = false, nullable = true)
    private StateEnum state;

    @ManyToMany
    @JoinTable(name = "item_supplier",
                joinColumns = @JoinColumn(name = "item_id"),
                inverseJoinColumns = @JoinColumn(name = "supplier_id"))
    private Set<Supplier> supplier = new HashSet<>();

    @OneToMany(mappedBy = "item")
    private List<PriceReduction> priceReductions = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public int getItem_code() {
        return item_code;
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

    public Set<Supplier> getSupplier() {
        return supplier;
    }

    public void setSupplier(Set<Supplier> supplier) {
        this.supplier = supplier;
    }

    public List<PriceReduction> getPriceReductions() {
        return priceReductions;
    }

    public void setPriceReductions(List<PriceReduction> priceReductions) {
        this.priceReductions = priceReductions;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
