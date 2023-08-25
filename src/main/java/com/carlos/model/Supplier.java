package com.carlos.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @Column(name = "supplier_id", unique = true, nullable = false )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long supplier_id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "country", nullable = true)
    private String country;

    @ManyToMany(mappedBy = "supplier")
    private List<Item> items = new ArrayList<>();

    @Column(name = "creation_date")
    private Date creation_date;


    public Long getSupplier_id() {
        return supplier_id;
    }

    public void setSuplier_id(Long suplier_id) {
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


    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}
