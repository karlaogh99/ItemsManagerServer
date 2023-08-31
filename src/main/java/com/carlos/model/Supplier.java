package com.carlos.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @Column(name = "supplier_id", unique = true, nullable = false )
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int supplier_id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "country", nullable = true)
    private String country;

    @ManyToMany(mappedBy = "supplier")
    @JsonIgnore
    private List<Item> items = new ArrayList<>();


    public int getSupplier_id() {
        return supplier_id;
    }

    public void setSuplier_id(int suplier_id) {
        this.supplier_id = suplier_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


}
