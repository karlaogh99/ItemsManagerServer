package com.carlos.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "suplier")
public class Supplier {
    @Id
    @Column(name = "suplier_id", unique = true, nullable = false )
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long suplier_id;

    @Column(name = "name", nullable = true)
    private String name;

    @Column(name = "country", nullable = true)
    private String country;

    @ManyToMany(mappedBy = "suppliers")
    private Set<Item> items = new HashSet<>();

    @Column(name = "creation_date")
    private Date creation_date;


    public Long getSuplier_id() {
        return suplier_id;
    }

    public void setSuplier_id(Long suplier_id) {
        this.suplier_id = suplier_id;
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

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
    public void addItems(Item item){
        if(item != null){
            if(this.items == null){
                this.items = new HashSet<Item>();
            }
            this.items.add(item);
        }
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}
